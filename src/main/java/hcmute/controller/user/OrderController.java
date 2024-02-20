package hcmute.controller.user;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.entity.BranchEntity;
import hcmute.entity.CartEntity;
import hcmute.entity.OrderDetailEntity;
import hcmute.entity.OrderEntity;
import hcmute.entity.PayMethodEntity;
import hcmute.entity.UserEntity;
import hcmute.service.IBranchService;
import hcmute.service.ICartService;
import hcmute.service.IOrderDetailService;
import hcmute.service.IOrderService;
import hcmute.service.impl.CookieServiceImpl;

@Controller
@RequestMapping("order")
public class OrderController {

	@Autowired
	IOrderService orderService;
	
	@Autowired
	IOrderDetailService orderDetailService;
	
	@Autowired
	IBranchService branchService;
	
	@Autowired
	ICartService cartService;
	
	@Autowired
	CookieServiceImpl cookieServiceImpl;
	
	@RequestMapping("")
	public String showAllOrders(ModelMap model) {
		try {
			int idUser = Integer.parseInt(cookieServiceImpl.getValue("USER_ID"));
			List<OrderEntity> list = orderService.findAllOrdersByUserId(idUser);
			model.addAttribute("orders", list);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/order";
	}
	
	@RequestMapping("order-detail/{idOrder}")
	public String showOrderDetail(ModelMap model,@PathVariable("idOrder") Integer idOrder) {
		try {
			int idUser = Integer.parseInt(cookieServiceImpl.getValue("USER_ID"));
			List<OrderEntity> list = orderService.findAllOrdersByUserId(idUser);
			OrderEntity userOrder = orderService.getById(idOrder);
			model.addAttribute("orders", list);
			model.addAttribute("userOrder", userOrder);	
			model.addAttribute("idOrder", idOrder);
			BranchEntity entity = userOrder.getBranchByOrder();
			model.addAttribute("addressOrder", entity.getAddressDetail());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/order";
	}
	
}
