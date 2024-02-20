package hcmute.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hcmute.embeddedId.CartDetailId;
import hcmute.entity.MilkTeaEntity;
import hcmute.model.MilkTeaModel;
import hcmute.service.ICartDetailService;
import hcmute.service.IMilkTeaService;

@Controller
@RequestMapping("product_favorite")
public class ProductFavoriteController {

	@Autowired
	ICartDetailService cartDetailService;

	@Autowired
	IMilkTeaService milkTeaService;

	private List<MilkTeaModel> getLists() {
		List<CartDetailId> milkTeas = cartDetailService.findMilkTeaByCartId(1);
		List<MilkTeaModel> listmilkteas = new ArrayList<MilkTeaModel>();
		for (CartDetailId result : milkTeas) {
			Optional<MilkTeaEntity> milktea = milkTeaService.findByIdMilkTea(result.getIdMilkTea());
			if (milktea.isPresent()) {
				MilkTeaEntity entity = milktea.get();
				MilkTeaModel milkTeaModel = new MilkTeaModel();
				BeanUtils.copyProperties(entity, milkTeaModel);
				listmilkteas.add(milkTeaModel);
			}
		}
		return listmilkteas;
	}

	@GetMapping("")
	public String list(ModelMap model, @RequestParam(value = "status", required = false) String status) {
		model.addAttribute("listmilkteas", this.getLists());
		model.addAttribute("status", status);
		return "user/favorite";
	}
}
