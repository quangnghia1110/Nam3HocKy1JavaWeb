package hcmute.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hcmute.entity.BranchEntity;
import hcmute.entity.RoleEntity;
import hcmute.entity.UserEntity;
import hcmute.entity.UserRoleEntity;
import hcmute.model.BranchModel;
import hcmute.model.UserRoleModel;
import hcmute.service.IBranchService;
import hcmute.service.IRoleService;
import hcmute.service.IUserRoleService;
import hcmute.service.IUserService;

@Controller
@RequestMapping("admin/userrole")
public class UserRoleAdminController {
	@Autowired
	IUserRoleService userRoleService;

	@Autowired
	IRoleService roleService;

	@Autowired
	IBranchService branchService;

	@Autowired
	IUserService userService;

	@GetMapping("")
	public String IndexViewUserRole(ModelMap model) {
		List<UserRoleEntity> listUserRole = userRoleService.findAll();

		model.addAttribute("listUserRole", listUserRole);
		return "admin/view/view-user-role";
	}

	@GetMapping("edit/{userRoleId}")
	public ModelAndView edit(ModelMap model, @PathVariable("userRoleId") int userRoleId) {
		List<BranchEntity> listBranch = branchService.findAll();
		List<RoleEntity> listRole = roleService.findAll();
		Optional<UserRoleEntity> opt = userRoleService.findById(userRoleId);
		UserRoleModel userRole = new UserRoleModel();
		if (opt.isPresent()) {
			UserRoleEntity entity = opt.get();
			BeanUtils.copyProperties(entity, userRole);
			userRole.setIsEdit(true);
			model.addAttribute("userRole", userRole);
			model.addAttribute("listRole", listRole);
			model.addAttribute("listBranch", listBranch);
			BranchEntity branchEntity = entity.getUser().getBranchByUser();
			if (branchEntity != null) {
				model.addAttribute("idBranch", branchEntity.getIdBranch());
			}
			return new ModelAndView("admin/customize/customize-user-role", model);
		}

		model.addAttribute("message", "UserRole không tồn tại");
		return new ModelAndView("forward:/admin/userrole", model);
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("userRole") UserRoleModel userRole,
			BindingResult result) {
		if (userRole != null) {
			Optional<UserRoleEntity> opt = userRoleService.findById(userRole.getRole_user_id());
			if (opt.isPresent()) {
				UserRoleEntity entity = opt.get();
				Optional<RoleEntity> roleOpt = roleService.findById(userRole.getRole_id());
				if (roleOpt.isPresent()) {
					entity.setRole(roleOpt.get());
					userRoleService.save(entity);
				}
				Optional<UserEntity> userOpt = userService.findById(userRole.getUser_id());
				if (userOpt.isPresent()) {
					UserEntity userEntity = userOpt.get();
					if ("MANAGER".equals(userRole.getRole_id())) {
						Optional<BranchEntity> branchOpt = branchService.findById(userRole.getIdBranch());
						if (branchOpt.isPresent()) {
							BranchEntity branchEntity = branchOpt.get();
							userEntity.setBranchByUser(branchEntity);
							userService.save(userEntity);
						}
					}
				}
			}
		} else {
			model.addAttribute("message", "Không thể lưu UserRole với dữ liệu null");
		}

		return new ModelAndView("redirect:/admin/userrole", model);
	}

}
