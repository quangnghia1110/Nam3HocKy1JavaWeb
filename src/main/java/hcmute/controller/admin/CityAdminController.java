package hcmute.controller.admin;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import hcmute.entity.BranchEntity;
import hcmute.entity.CityEntity;
import hcmute.model.BranchModel;
import hcmute.model.CityModel;
import hcmute.service.IBranchService;
import hcmute.service.ICityService;

import javax.validation.Valid;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/city")
public class CityAdminController {

    @Autowired
    private ICityService cityService;

    @GetMapping("")
    public String indexViewCity(ModelMap model) {
        List<CityEntity> cities = cityService.findAll();
        model.addAttribute("cities", cities);  // Updated attribute name to "branches"
        return "admin/view/view-city";
    }

    @GetMapping("add")
    public String add(ModelMap model) {
        CityModel city = new CityModel();
        city.setIsEdit(false);
        model.addAttribute("city", city);
        return "admin/customize/customize-city";
    }
    
    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("city") BranchModel city, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("admin/customize/customize-city");
        }
        if (city != null) {
            CityEntity entity = new CityEntity();
            if (city.getIdCity() != null) {
                entity.setIdCity(city.getIdCity());
            }
            if (city.getName() != null) {
                entity.setName(city.getName());
            }
           
            cityService.save(entity);
            String message = city.getIsEdit() ? "City đã được cập nhật thành công" : "City đã được thêm thành công";
            model.addAttribute("message", message);
        } else {
            model.addAttribute("message", "Không thể lưu City với dữ liệu null");
        }

        return new ModelAndView("redirect:/admin/city", model);
    }

    @GetMapping("edit/{idCity}")
    public ModelAndView edit(ModelMap model, @PathVariable("idCity") String idCity) {
        Optional<CityEntity> opt = cityService.findById(idCity);
        CityModel city = new CityModel();
        if (opt.isPresent()) {
            CityEntity entity = opt.get();
            BeanUtils.copyProperties(entity, city);
            city.setIsEdit(true);
            model.addAttribute("city", city);
            return new ModelAndView("admin/customize/customize-city", model);
        }

        model.addAttribute("message", "City không tồn tại");
        return new ModelAndView("forward:/admin/city", model);
    }
}
