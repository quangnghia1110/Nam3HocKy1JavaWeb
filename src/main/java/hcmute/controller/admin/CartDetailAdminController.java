package hcmute.controller.admin;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import hcmute.entity.CartDetailEntity;
import hcmute.entity.CartEntity;
import hcmute.model.CartDetailModel;
import hcmute.model.CartModel;
import hcmute.service.ICartDetailService;
import hcmute.service.ICartService;

@Controller
public class CartDetailAdminController {
	@Autowired
	ICartDetailService cartDetailService;
	@GetMapping("view-cart-detail")
	public String IndexViewCartDetail() {
		return "admin/view/view-cart-detail";
	}
	@GetMapping("customize-cart-detail")
	public String IndexCustomizeCartDetail() {
		return "admin/customize/customize-cart-detail";
	}
	@GetMapping("customize-cart-detail/add")
	public String Add(ModelMap model) {
		CartDetailModel cart = new CartDetailModel();
		cart.setIsEdit(false);
		model.addAttribute("cart", cart);
		return "admin/customize/customize-cart-detail";
	}
	@PostMapping("customize-cart-detail/saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("cartDetail") CartDetailModel cartDetail, BindingResult result) {
	    if (result.hasErrors()) {
	        return new ModelAndView("admin/customize/customize-cart-detail");
	    }
	    CartDetailEntity entity = new CartDetailEntity();
	    BeanUtils.copyProperties(cartDetail, entity);
	    cartDetailService.save(entity);
	    String message = "";
	    if (cartDetail.getIsEdit()==true) {
	        message = "cart đã được cập nhật thành công";
	    } else {
	        message = "cart đã được thêm thành công";
	    }
	    model.addAttribute("message", message);
	    return new ModelAndView("forward:/admin/view-cart-detail", model);
	}
//	@GetMapping("customize-cart/edit/{idAccount}")
//	public ModelAndView edit(ModelMap model, @PathVariable("idcart") int idcart) {
//	    Optional<CartDetailEntity> opt = cartDetailService.findById(idcart);
//	    CartDetailModel cart = new CartDetailModel();
//	    if(opt.isPresent()) {
//	    	CartDetailEntity entity = opt.get();
//	    	BeanUtils.copyProperties(entity, cart);
//	    	cart.setIsEdit(true);
//	    	model.addAttribute("cart", cart);
//	    	return new ModelAndView("admin/customize/customize-cart", model);
//	    }
//	    model.addAttribute("message", "cart không tồn tại");
//		return new ModelAndView("forward:/admin/view-cart-detail", model);
//	}
}
