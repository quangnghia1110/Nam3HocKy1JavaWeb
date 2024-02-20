package hcmute.controller.manager;

import java.util.List;
import java.util.Optional;

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
import hcmute.entity.OrderEntity;
import hcmute.entity.UserEntity;
import hcmute.model.OrderModel;
import hcmute.service.IOrderService;
import hcmute.service.IUserService;
import hcmute.service.impl.CookieServiceImpl;

@Controller
@RequestMapping("manager/order")
public class OrderManagerController {
	@Autowired
	CookieServiceImpl cookieServiceImpl;
	
	@Autowired
	IOrderService orderService;
	
	@Autowired
	IUserService userService;
	
	@GetMapping("")
	public String getOrder(ModelMap model) {
		int userId = Integer.parseInt(cookieServiceImpl.getValue("USER_ID"));
		Optional<UserEntity> opt = userService.findById(userId);
		if(opt.isPresent()) {
			UserEntity entity = opt.get();
			BranchEntity branch = entity.getBranchByUser();
			List<OrderEntity> listOrder = orderService.findByBranchByOrder(branch);
			model.addAttribute("listOrder", listOrder);
		}
		return "manager/view/view-user-order";
	}
	
	@GetMapping("edit/{userOrderId}")
	public ModelAndView edit(ModelMap model, @PathVariable("userOrderId") int userOrderId) {
		Optional<OrderEntity> opt = orderService.findById(userOrderId);
		OrderModel order = new OrderModel();
		if (opt.isPresent()) {
			OrderEntity entity = opt.get();
			BeanUtils.copyProperties(entity, order);
			order.setIsEdit(true);
			model.addAttribute("userOrder", order);
			return new ModelAndView("manager/customize/customize-user-order", model);
		}

		model.addAttribute("message", "UserOrder không tồn tại");
		return new ModelAndView("forward:/manager/order", model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("userOrder") OrderModel userOrder,
			BindingResult result) {
		if (userOrder != null) {
			Optional<OrderEntity> opt = orderService.findById(userOrder.getIdOrder());
			if(opt.isPresent()) {
				OrderEntity entity = opt.get();
				entity.setOrderState(userOrder.getOrderState());
				orderService.save(entity);
			}
		}else {
			model.addAttribute("message", "Không thể lưu UserOrder với dữ liệu null");
		}

		return new ModelAndView("redirect:/manager/order", model);
	}
}
