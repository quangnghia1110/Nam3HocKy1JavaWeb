package hcmute.controller.admin;

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
import hcmute.entity.CartEntity;
import hcmute.model.CartModel;
import hcmute.service.IBranchService;
import hcmute.service.ICartService;

@Controller
@RequestMapping("admin")
public class CartAdminController {
	@Autowired
	ICartService cartService;
	@GetMapping("view-cart")
	public String IndexViewCart(ModelMap model) {
		List<CartEntity> cart = cartService.findAll();
		model.addAttribute("cart", cart);
		return "admin/view/view-cart";
	}
	@GetMapping("customize-cart")
	public String IndexCustomizeCart() {
		return "admin/customize/customize-cart";
	}
	@GetMapping("customize-cart/add")
	public String Add(ModelMap model) {
		CartModel cart = new CartModel();
		cart.setIsEdit(false);
		model.addAttribute("cart", cart);
		return "admin/customize/customize-cart";
	}
	@PostMapping("customize-cart/saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("cart") CartModel cart, BindingResult result) {
	    if (result.hasErrors()) {
	        return new ModelAndView("admin/customize/customize-cart");
	    }
	    CartEntity entity = new CartEntity();
	    BeanUtils.copyProperties(cart, entity);
	    cartService.save(entity);
	    String message = "";
	    if (cart.getIsEdit()==true) {
	        message = "cart đã được cập nhật thành công";
	    } else {
	        message = "cart đã được thêm thành công";
	    }
	    model.addAttribute("message", message);
	    return new ModelAndView("forward:/admin/view-cart", model);
	}
	@GetMapping("customize-cart/edit/{idCart}")
	public ModelAndView edit(ModelMap model, @PathVariable("idcart") int idcart) {
	    Optional<CartEntity> opt = cartService.findById(idcart);
	    CartModel cart = new CartModel();
	    if(opt.isPresent()) {
	    	CartEntity entity = opt.get();
	    	BeanUtils.copyProperties(entity, cart);
	    	cart.setIsEdit(true);
	    	model.addAttribute("cart", cart);
	    	return new ModelAndView("admin/cart/customize-cart", model);
	    }
	    model.addAttribute("message", "cart không tồn tại");
		return new ModelAndView("forward:/admin/view-cart", model);
	}
	@GetMapping("delete/{idCart}")
	public ModelAndView delete(ModelMap model, @PathVariable("idCart") int idCart) {
	    cartService.deleteById(idCart);
	    model.addAttribute("message", "Book đã xóa thành công");
		return new ModelAndView("forward:/admin/view-cart", model);
	}
}
