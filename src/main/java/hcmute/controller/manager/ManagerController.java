package hcmute.controller.manager;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.entity.BranchEntity;
import hcmute.entity.BranchMilkTea;
import hcmute.entity.MilkTeaEntity;
import hcmute.entity.UserEntity;
import hcmute.service.IUserService;
import hcmute.service.impl.CookieServiceImpl;

@Controller
@RequestMapping("manager")
public class ManagerController {
	
	@Autowired
	CookieServiceImpl cookieServiceImpl;
	
	@Autowired
	IUserService userService;
	
	@GetMapping("index")
	public String indexManager(ModelMap model) {
		int userId = Integer.parseInt(cookieServiceImpl.getValue("USER_ID"));
		Optional<UserEntity> opt = userService.findById(userId);
		if(opt.isPresent()) {
			UserEntity entity = opt.get();
			BranchEntity branch = entity.getBranchByUser();
			model.addAttribute("branch", branch);
		}
		return "manager/index";
	}
	
	
}
