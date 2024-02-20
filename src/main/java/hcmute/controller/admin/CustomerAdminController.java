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
import hcmute.entity.UserEntity;
import hcmute.entity.UserRoleEntity;
import hcmute.model.BranchModel;
import hcmute.model.CityModel;
import hcmute.model.UserModel;
import hcmute.service.IBranchService;
import hcmute.service.ICityService;
import hcmute.service.IUserRoleService;
import hcmute.service.IUserService;

import javax.validation.Valid;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/customer")
public class CustomerAdminController {

	@Autowired
	private IUserService userService;
	
	@Autowired 
	private IUserRoleService userRoleService;

	@GetMapping("")
	public String indexViewCustomer(ModelMap model) {
		List<UserRoleEntity> listUserRole = userRoleService.findByRoleId("USER");
		List<UserEntity> listUser = new ArrayList<UserEntity>();
		for(UserRoleEntity entity : listUserRole) {
			listUser.add(entity.getUser());
		}
		model.addAttribute("listUser", listUser);
		return "admin/view/view-customer";
	}
  
	@PostMapping("saveOrUpdate/{user_id}")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("customer") UserModel customer,
			@PathVariable("user_id") int idUser, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/customize/customize-customer");
		}
		if (customer != null) {
			Optional<UserEntity> opt = userService.findById(idUser);
			if (opt.isPresent()) {
				UserEntity entity = opt.get();
				if (customer.getSurname() != null) {
					entity.setSurname(customer.getSurname());
				}
				if (customer.getName() != null) {
					entity.setName(customer.getName());
				}
				if (customer.getBirthday() != null) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate = LocalDate.parse(customer.getBirthday(), formatter);
					entity.setBirthday(localDate);
				}
				if (customer.getPhoneNumber() != null) {
					entity.setPhoneNumber(customer.getPhoneNumber());
				}
				if (customer.getGender() != -1) {
					entity.setGender(customer.getGender());
				}
				userService.save(entity);
			}
		} else {
			model.addAttribute("message", "Không thể lưu User với dữ liệu null");
		}

		return new ModelAndView("redirect:/admin/customer", model);
	}

	@GetMapping("edit/{idUser}")
	public ModelAndView edit(ModelMap model, @PathVariable("idUser") int idUser) {
		Optional<UserEntity> opt = userService.findById(idUser);
		UserModel user = new UserModel();
		if (opt.isPresent()) {
			UserEntity entity = opt.get();
			BeanUtils.copyProperties(entity, user);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = formatter.format(entity.getBirthday());
			user.setBirthday(dateString);
			user.setIsEdit(true);
			model.addAttribute("customer", user);
			return new ModelAndView("admin/customize/customize-customer", model);
		}

		model.addAttribute("message", "User không tồn tại");
		return new ModelAndView("forward:/admin/customer", model);
	}
}
