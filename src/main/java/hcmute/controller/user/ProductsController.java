package hcmute.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hcmute.entity.MilkTeaCategoryEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.entity.MilkTeaTypeEntity;
import hcmute.service.IMilkTeaCategoryService;
import hcmute.service.IMilkTeaService;
import hcmute.service.IMilkTeaTypeService;

@Controller
@RequestMapping("products")
public class ProductsController {

	@Autowired
	IMilkTeaCategoryService milkTeaCategoryService;
	@Autowired
	IMilkTeaTypeService milkTeaTypeService;
	@Autowired
	IMilkTeaService milkTeaService;

	@GetMapping("")
	public String showCategory(Model model, @RequestParam("page") Optional<Integer> page) {
		List<MilkTeaCategoryEntity> categories = milkTeaCategoryService.findAll();
		List<List<MilkTeaTypeEntity>> types = new ArrayList<List<MilkTeaTypeEntity>>();
		model.addAttribute("categories", categories);
		for (MilkTeaCategoryEntity category : categories) {
			List<MilkTeaTypeEntity> categoriesWithTypes = milkTeaTypeService
					.findAllByCategoryId(category.getIdCategory());
			types.add(categoriesWithTypes);
		}
		model.addAttribute("types", types);

		int count = (int) milkTeaService.count();
		int currentPage = page.orElse(1);
		int pageSize = 6;

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("idMilkTea"));
		Page<MilkTeaEntity> resultpaPage = null;

		resultpaPage = milkTeaService.findAll(pageable);

		int totalPages = resultpaPage.getTotalPages();
		if (totalPages > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPages);
			if (totalPages > count) {
				if (end == totalPages)
					start = end - count;
				else if (start == 1)
					end = start + count;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);

		}
		model.addAttribute("milkTeas", resultpaPage);

		return "user/products";

	}

	@RequestMapping("type/{id}")
	public String getMilkTeaByType(Model model, @PathVariable("id") int typeId,
			@RequestParam("page") Optional<Integer> page) {
		List<MilkTeaCategoryEntity> categories = milkTeaCategoryService.findAll();
		List<List<MilkTeaTypeEntity>> types = new ArrayList<List<MilkTeaTypeEntity>>();
		model.addAttribute("categories", categories);
		for (MilkTeaCategoryEntity category : categories) {
			List<MilkTeaTypeEntity> categoriesWithTypes = milkTeaTypeService
					.findAllByCategoryId(category.getIdCategory());
			types.add(categoriesWithTypes);
		}
		model.addAttribute("types", types);

		int count = milkTeaService.countByTypeId(typeId);
		int currentPage = page.orElse(1);
		int pageSize = 6;

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("idMilkTea"));
		Page<MilkTeaEntity> resultpaPage = null;

		resultpaPage = milkTeaService.findAllByTypeId(typeId, pageable);

		int totalPages = resultpaPage.getTotalPages();
		if (totalPages > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPages);
			if (totalPages > count) {
				if (end == totalPages)
					start = end - count;
				else if (start == 1)
					end = start + count;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);

		}
		model.addAttribute("milkTeaByTypes", resultpaPage);
		model.addAttribute("idActive", typeId);
		return "user/products";
	}

}
