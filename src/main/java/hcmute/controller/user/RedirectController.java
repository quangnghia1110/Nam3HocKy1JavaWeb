package hcmute.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.entity.MilkTeaCategoryEntity;
import hcmute.entity.MilkTeaTypeEntity;
import hcmute.service.IMilkTeaCategoryService;
import hcmute.service.IMilkTeaService;
import hcmute.service.IMilkTeaTypeService;

@Controller
@RequestMapping("")
public class RedirectController {

	@Autowired
	IMilkTeaCategoryService milkTeaCategoryService;
	@Autowired
	IMilkTeaTypeService milkTeaTypeService;
	@Autowired
	IMilkTeaService milkTeaService;

	@GetMapping("")
	public String LoadHeader(Model model) {
		List<MilkTeaCategoryEntity> categories = milkTeaCategoryService.findAll();
		List<List<MilkTeaTypeEntity>> types = new ArrayList<List<MilkTeaTypeEntity>>();
		model.addAttribute("categories", categories);
		for (MilkTeaCategoryEntity category : categories) {
			List<MilkTeaTypeEntity> categoriesWithTypes = milkTeaTypeService
					.findAllByCategoryId(category.getIdCategory());
			types.add(categoriesWithTypes);
		}
		model.addAttribute("types", types);
		return "user/header/header";
	}

	@RequestMapping("/")
	public String Index() {
		return "redirect:/security/login";
	}

	@GetMapping(value = "/test")
	public String IndexTest() {
		return "user/test";
	}
//	@GetMapping(value="/admin/city/add")
//	public String CustomizeCity() {
//		return "admin/customize/customize-city";
//	}
//	@GetMapping(value="/admin/city")
//	public String ViewCity() {
//		return "admin/view/view-city";
//	}
}
