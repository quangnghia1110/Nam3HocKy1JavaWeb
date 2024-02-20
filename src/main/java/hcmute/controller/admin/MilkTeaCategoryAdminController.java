package hcmute.controller.admin;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import hcmute.entity.MilkTeaCategoryEntity;

import hcmute.model.MilkTeaCategoryModel;

import hcmute.service.IMilkTeaCategoryService;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/category")
public class MilkTeaCategoryAdminController {

	@Autowired
	private IMilkTeaCategoryService milkTeaCategoryService;

	@GetMapping("")
	public String indexViewCategory(ModelMap model) {
		List<MilkTeaCategoryEntity> categories = milkTeaCategoryService.findAll();
		model.addAttribute("categories", categories); // Updated attribute name to "branches"
		return "admin/view/view-milk-tea-category";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		MilkTeaCategoryModel category = new MilkTeaCategoryModel();
		category.setIsEdit(false);
		model.addAttribute("category", category);
		return "admin/customize/customize-milk-tea-category";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") MilkTeaCategoryModel category,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/customize/customize-milk-tea-category");
		}
		if (category != null) {
			MilkTeaCategoryEntity entity = new MilkTeaCategoryEntity();
			entity.setIdCategory(category.getIdCategory());
			System.out.println(category.getIdCategory());
			System.out.println(category.getName());
			if (category.getName() != null) {
				entity.setName(category.getName());
			}

			milkTeaCategoryService.save(entity);
			String message = category.getIsEdit() ? "Danh mục đã được cập nhật thành công"
					: "Danh mục đã được thêm thành công";
			model.addAttribute("message", message);
		} else {
			model.addAttribute("message", "Không thể lưu  với dữ liệu null");
		}

		return new ModelAndView("redirect:/admin/category", model);
	}

	@GetMapping("edit/{idCategory}")
	public ModelAndView edit(ModelMap model, @PathVariable("idCategory") int idCategory) {
		Optional<MilkTeaCategoryEntity> opt = milkTeaCategoryService.findById(idCategory);
		MilkTeaCategoryModel category = new MilkTeaCategoryModel();
		if (opt.isPresent()) {
			MilkTeaCategoryEntity entity = opt.get();
			BeanUtils.copyProperties(entity, category);
			category.setIsEdit(true);
			model.addAttribute("category", category);
			return new ModelAndView("admin/customize/customize-milk-tea-category", model);
		}

		model.addAttribute("message", "Danh mục không tồn tại không tồn tại");
		return new ModelAndView("forward:/admin/category", model);
	}
}
