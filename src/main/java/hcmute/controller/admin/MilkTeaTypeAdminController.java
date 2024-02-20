package hcmute.controller.admin;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hcmute.entity.MilkTeaCategoryEntity;
import hcmute.entity.MilkTeaTypeEntity;
import hcmute.model.MilkTeaTypeModel;
import hcmute.service.IMilkTeaCategoryService;
import hcmute.service.IMilkTeaTypeService;

@Controller
@RequestMapping("admin/milk-tea-type")
public class MilkTeaTypeAdminController {

	@Autowired
	private IMilkTeaTypeService milkTeaTypeService;
	
	@Autowired
	private IMilkTeaCategoryService milkTeaCategoryService;

	@GetMapping("")
	public String IndexViewMilkTeaType(ModelMap model) {
		List<MilkTeaTypeEntity> milkTeaTypes = milkTeaTypeService.findAll();
		model.addAttribute("milkTeaTypes", milkTeaTypes);
		return "admin/view/view-milk-tea-type";
	}
	@GetMapping("add")
	public String add(ModelMap model) {
		MilkTeaTypeModel milkTeaType = new MilkTeaTypeModel();
		milkTeaType.setIsEdit(false);
		model.addAttribute("milkTeaType", milkTeaType);
		return "admin/customize/customize-milk-tea-type";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("milkTeaType") MilkTeaTypeModel milkTeaType,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/customize/customize-milk-tea-type");
		}
		if (milkTeaType != null) {
            MilkTeaTypeEntity entity = new MilkTeaTypeEntity();
            entity.setIdType(milkTeaType.getIdType());
            Optional<MilkTeaCategoryEntity> opt = milkTeaCategoryService.findById(milkTeaType.getIdCategory());
            if (milkTeaType.getName() != null) {
                entity.setName(milkTeaType.getName());
            }
            entity.setMilkTeaCategoryByMilkTeaType(opt.get());
            milkTeaTypeService.save(entity);
            String message = milkTeaType.getIsEdit() ? "milkTeaType đã được cập nhật thành công" : "milkTeaType đã được thêm thành công";
            model.addAttribute("message", message);
        } else {
            model.addAttribute("message", "Không thể lưu milkTeaType với dữ liệu null");
        }
		return new ModelAndView("redirect:/admin/milk-tea-type", model);
	}
}
