package hcmute.controller.user;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.databind.ObjectMapper;

import hcmute.entity.BranchEntity;
import hcmute.entity.CartEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.model.MilkTeaModel;
import hcmute.model.OrderProduct;
import hcmute.model.OrderProduct.OrderItem;
import hcmute.service.IBranchMilkTeaService;
import hcmute.service.IBranchService;
import hcmute.service.ICartDetailService;
import hcmute.service.ICartService;
import hcmute.service.IMilkTeaService;
import hcmute.service.impl.CookieServiceImpl;

@Controller
@RequestMapping("product_detail")
public class ProductsDetailController {
	@Autowired
	IMilkTeaService milkTeaService;
	@Autowired
	ICartDetailService cartDetailService;
	@Autowired
	IBranchService branchService;
	@Autowired
	IBranchMilkTeaService branchMilkTeaService;
	@Autowired
	CookieServiceImpl cookieServiceImpl;
	@Autowired
	ICartService cartService;

	@GetMapping("/{id}")
	public ModelAndView detail(ModelMap model, @PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		Optional<MilkTeaEntity> optMilkTea = milkTeaService.findByIdMilkTea(id);
		MilkTeaModel milkTeaModel = new MilkTeaModel();

		if (optMilkTea.isPresent()) {
			MilkTeaEntity entity = optMilkTea.get();

			// copy from entity to model
			BeanUtils.copyProperties(entity, milkTeaModel);
			int typeId = entity.getMilkTeaTypeByMilkTea().getIdType();

			// set attributes for model
			milkTeaModel.setMilkTeaType(entity.getMilkTeaTypeByMilkTea().getName());
			milkTeaModel.setMilkTeaTypeId(typeId);

			List<MilkTeaEntity> relevantProducts = milkTeaService.findRelevantProducts(typeId, id);

			// get flash attributes from previous request
			String cartMessage = (String) redirectAttributes.getFlashAttributes().get("cartMessage");

			if (cartMessage != null) {
				model.addAttribute("cartMessage", cartMessage);
			}

			model.addAttribute("milkTea", milkTeaModel);
			model.addAttribute("relevantProducts", relevantProducts);

			return new ModelAndView("user/product_detail", model);
		}

		model.addAttribute("message", "Sản phẩm này không tồn tại");
		return new ModelAndView("user/error", model);
	}
	
	@GetMapping("/check")
	public String check(ModelMap model, @RequestParam("data") String data) {
		String dataEncoded = data;
		byte[] decodedBytes = Base64.getDecoder().decode(data);
		data = new String(decodedBytes, StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();
		List<BranchEntity> listBranches = branchService.findAll();
		List<Integer> listBranchesEligible = new ArrayList<Integer>();
		int idMilkTea = 0;
		try {
			OrderProduct orderProduct = objectMapper.readValue(data, OrderProduct.class);
			Boolean isSuccess = false;
			for (BranchEntity branch : listBranches) {
				Boolean isChecked = true;
				for (OrderItem item : orderProduct.getList()) {
					idMilkTea = Integer.parseInt(item.getIdMilkTea());
					Optional<MilkTeaEntity> entity = milkTeaService.findByIdMilkTea(idMilkTea);
					if (entity.isPresent()) {
						int idBranch = branch.getIdBranch();
						Optional<Integer> remainQuantityOptional = branchMilkTeaService
								.findRemainQuantityByBranchIdAndMilkTeaId(idBranch, idMilkTea, item.getSize());
						if (remainQuantityOptional.isPresent()) {
							if (remainQuantityOptional.get() < Integer.parseInt(item.getQuantity())) {
								isChecked = false;
								break;
							}
						} else {
							isChecked = false;
							break;
						}
					}
				}
				if (isChecked) {
					listBranchesEligible.add(branch.getIdBranch());
					isSuccess = true;
				}
			}
			if (isSuccess) {
				String json = objectMapper.writeValueAsString(listBranchesEligible);
				byte[] bytes = json.getBytes();
				String base64Encoded = Base64.getEncoder().encodeToString(bytes);
				return "redirect:/payment?data=" + dataEncoded + "&listBranch=" + base64Encoded;
			} else {
				model.addAttribute("message",
						"Xin lỗi quý khách! Hiện tại sản phẩm này đã hết hàng trên toàn bộ chi nhánh!");
				model.addAttribute("status", "fail");
				Optional<MilkTeaEntity> optMilkTea = milkTeaService.findByIdMilkTea(idMilkTea);
				MilkTeaModel milkTeaModel = new MilkTeaModel();

				if (optMilkTea.isPresent()) {
					MilkTeaEntity entity = optMilkTea.get();

					// copy from entity to model
					BeanUtils.copyProperties(entity, milkTeaModel);
					int typeId = entity.getMilkTeaTypeByMilkTea().getIdType();

					// set attributes for model
					milkTeaModel.setMilkTeaType(entity.getMilkTeaTypeByMilkTea().getName());
					milkTeaModel.setMilkTeaTypeId(typeId);

					List<MilkTeaEntity> relevantProducts = milkTeaService.findRelevantProducts(typeId, idMilkTea);

					model.addAttribute("milkTea", milkTeaModel);
					model.addAttribute("relevantProducts", relevantProducts);
				}
				return "user/product_detail";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private int getCartId(int idUser) {
		Optional<CartEntity> cartOpt = cartService.findCartsByUserId(idUser);
		CartEntity cart = cartOpt.get();
		return cart.getIdCart();
	}

	@GetMapping("/addtocart")
	public RedirectView addToCart(RedirectAttributes redirectAttributes, @RequestParam("id") int id,
			@RequestParam("size") String size) {

		try {
			int idUser = Integer.parseInt(cookieServiceImpl.getValue("USER_ID"));
			int idCart = getCartId(idUser);
			cartDetailService.addProductToCart(idCart, id, size);
			redirectAttributes.addFlashAttribute("cartMessage", "success");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("cartMessage", "fail");
		}

		// redirect
		return new RedirectView("/product_detail/" + id);
	}
}
