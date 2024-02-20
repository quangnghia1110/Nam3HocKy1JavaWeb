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
import hcmute.entity.PayMethodEntity;
import hcmute.model.BranchModel;
import hcmute.model.PayMethodModel;
import hcmute.service.IPayMethodService;

@Controller
@RequestMapping("admin/paymethod")
public class PaymethodAdminController {

	@Autowired
	private IPayMethodService payMethodService;

	@GetMapping("")
	public String IndexViewMethod(ModelMap model) {
		List<PayMethodEntity> paymethods = payMethodService.findAll();
		model.addAttribute("paymethods", paymethods);
		return "admin/view/view-paymethod";
	}
	@GetMapping("add")
	public String add(ModelMap model) {
		PayMethodModel paymethod = new PayMethodModel();
		paymethod.setIsEdit(false);
		model.addAttribute("paymethod", paymethod);
		return "admin/customize/customize-paymethod";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("payMethod") PayMethodModel payMethod,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/customize/customize-paymethod");
		}
		if (payMethod != null) {
			PayMethodEntity entity = new PayMethodEntity();
			if (payMethod.getIdPayMethod() != null) {
				entity.setIdPayMethod(payMethod.getIdPayMethod());
			}
			if (payMethod.getName() != null) {
				entity.setName(payMethod.getName());
			}

			payMethodService.save(entity);
			String message = payMethod.getIsEdit() ? "paymethod đã được cập nhật thành công"
					: "paymethod đã được thêm thành công";
			model.addAttribute("message", message);
		} else {
			model.addAttribute("message", "Không thể lưu paymethod với dữ liệu null");
		}

		return new ModelAndView("redirect:/admin/paymethod", model);
	}

	@GetMapping("edit/{idPayMethod}")
	public ModelAndView edit(ModelMap model, @PathVariable("idPayMethod") String idPayMethod) {
		Optional<PayMethodEntity> opt = payMethodService.findById(idPayMethod);
		PayMethodModel paymethod = new PayMethodModel();
		if (opt.isPresent()) {
			PayMethodEntity entity = opt.get();
			BeanUtils.copyProperties(entity, paymethod);
			paymethod.setIsEdit(true);
			model.addAttribute("paymethod", paymethod);
			return new ModelAndView("admin/customize/customize-paymethod", model);
		}

		model.addAttribute("message", "Branch không tồn tại");
		return new ModelAndView("forward:/admin/paymethod", model);
	}

}
