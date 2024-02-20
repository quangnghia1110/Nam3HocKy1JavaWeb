package hcmute.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



import hcmute.embeddedId.BranchMilkTeaId;
import hcmute.entity.BranchEntity;
import hcmute.entity.BranchMilkTea;
import hcmute.entity.MilkTeaEntity;
import hcmute.model.BranchMilkTeaModel;

import hcmute.service.IBranchMilkTeaService;
import hcmute.service.IBranchService;
import hcmute.service.IMilkTeaService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("admin/branch-milk-tea")
public class BranchMilkTeaAdminController {

	@Autowired
	private IBranchMilkTeaService branchMilkTeaService;
	
	@Autowired
	private IBranchService branchService;
	
	@Autowired
	private IMilkTeaService milkTeaService;
	
	@GetMapping("")
	public String indexViewBranchMilkTea(ModelMap model) {
		List<BranchMilkTea> branchMilkTeas = branchMilkTeaService.findAll();
		model.addAttribute("branchMilkTeas", branchMilkTeas); // Updated attribute name to "branches"
		return "admin/view/view-branch-milk-tea";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		BranchMilkTeaModel branchMilkTea = new BranchMilkTeaModel();
		branchMilkTea.setIsEdit(false);
		model.addAttribute("branchMilkTea", branchMilkTea);
		return "admin/customize/customize-branch-milk-tea";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("branchMilkTea") BranchMilkTeaModel branchMilkTea,
			BindingResult result) {
		if (branchMilkTea != null) {
			BranchMilkTea entity = new BranchMilkTea();
			BranchMilkTeaId branchMilkTeaId = new BranchMilkTeaId(branchMilkTea.getIdBranch(),branchMilkTea.getIdMilkTea(),branchMilkTea.getSize());
			entity.setBranchMilkTeaId(branchMilkTeaId);
			entity.setRemainQuantity(branchMilkTea.getRemainQuantity());
			
			Optional<MilkTeaEntity> opt_milkTea = milkTeaService.findById(branchMilkTea.getIdMilkTea());
			Optional<BranchEntity> opt_branch = branchService.findById(branchMilkTea.getIdBranch());
			entity.setBranchByBranchMilkTea(opt_branch.get());
			entity.setMilkTeaByBranchMilkTea(opt_milkTea.get());
			branchMilkTeaService.save(entity);
			String message = branchMilkTea.getIsEdit() ? "Branch Milk Tea đã được cập nhật thành công"
					: "Branch Milk Tea đã được thêm thành công";
			model.addAttribute("message", message);
		}else {
			model.addAttribute("message", "Không thể lưu Branch với dữ liệu null");
		}
		return new ModelAndView("redirect:/admin/branch-milk-tea", model);
	}
	@GetMapping("edit/{idBranch}/{idMilkTea}/{size}")
	public ModelAndView edit(ModelMap model, @PathVariable("idBranch") int idBranch,@PathVariable("idMilkTea") int idMilkTea,@PathVariable("size") String size) {
		BranchMilkTeaId branchMilkTeaId = new BranchMilkTeaId(idBranch,idMilkTea,size);
		Optional<BranchMilkTea> opt = branchMilkTeaService.findById(branchMilkTeaId);
		BranchMilkTeaModel branchMilkTea = new BranchMilkTeaModel();
		if (opt.isPresent()) {
			BranchMilkTea entity = opt.get();
			branchMilkTea.setBranchByBranchMilkTea(entity.getBranchByBranchMilkTea());
			branchMilkTea.setIdBranch(entity.getBranchByBranchMilkTea().getIdBranch());
			branchMilkTea.setMilkTeaByBranchMilkTea(entity.getMilkTeaByBranchMilkTea());
			branchMilkTea.setIdMilkTea(entity.getMilkTeaByBranchMilkTea().getIdMilkTea());
			branchMilkTea.setSize(entity.getBranchMilkTeaId().getSize());
			branchMilkTea.setRemainQuantity(entity.getRemainQuantity());
			branchMilkTea.setIsEdit(true);
			model.addAttribute("branchMilkTea", branchMilkTea);
			return new ModelAndView("admin/customize/customize-branch-milk-tea", model);
		}
		model.addAttribute("message", "Branch không tồn tại");
		return new ModelAndView("forward:/admin/branch-milk-tea", model);
	}
}
