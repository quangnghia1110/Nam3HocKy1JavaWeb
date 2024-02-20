package hcmute.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class OrderDetailAdminController {
	@GetMapping("view-order-detail")
	public String IndexViewOrderDetail() {
		return "admin/view/view-order-detail";
	}
	@GetMapping("customize-order-detail")
	public String IndexCustomizeOrderDetail() {
		return "admin/customize/customize-order-detail";
	}
}
