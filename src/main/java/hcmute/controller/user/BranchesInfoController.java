package hcmute.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.entity.BranchEntity;
import hcmute.service.IBranchService;

@Controller
@RequestMapping("branch-info")
public class BranchesInfoController {
	@Autowired
	private IBranchService branchService;

	
	@GetMapping("/{idBranch}")
	public String listByCity(ModelMap model,@PathVariable("idBranch") Integer idBranch) {
		BranchEntity branch = branchService.getById(idBranch);
		model.addAttribute("branch", branch);
		return "user/branches_info";
	}
}
