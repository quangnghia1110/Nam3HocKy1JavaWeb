package hcmute.controller.user;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import hcmute.entity.MilkTeaEntity;
import hcmute.entity.UserEntity;
import hcmute.model.MilkTeaModel;
import hcmute.service.ICartDetailService;
import hcmute.service.IMilkTeaService;
import hcmute.service.IStorageService;
import hcmute.service.IUserService;
import hcmute.service.impl.SessionServiceImpl;

@Controller
@SessionAttributes("user")
public class HomeController {
	@Autowired
	IMilkTeaService milkTeaService;
	@Autowired
	IUserService userService;
	@Autowired
    ICartDetailService cartDetailService;
	@Autowired
	SessionServiceImpl sessionService;
	@Autowired
	private IStorageService storageService;
	@GetMapping("home")
	public String LoadData(ModelMap model, HttpSession session) {
		List<MilkTeaEntity> list1 = milkTeaService.findFiveProductOutstanding();
		model.addAttribute("list1", list1);
		List<MilkTeaEntity> list2 = milkTeaService.findFiveProduct();
		model.addAttribute("list2", list2);
		return "user/home";
	}

	//Thêm sản phẩm vào mục yêu thíhc
    @GetMapping("home/addtofavorite")
	public RedirectView addToCart(RedirectAttributes redirectAttributes, @RequestParam("id") int id) {
		try {
		    cartDetailService.addProductToFavorite(1, id);
		    redirectAttributes.addFlashAttribute("cartMessage", "success");
		} catch (Exception e) {
			 redirectAttributes.addFlashAttribute("cartMessage", "fail");
		}
	    return new RedirectView("/home/" + id);
	}
    
    //Sau khi thêm xong thì gửi message ra
    @GetMapping("home/{id}")
	public ModelAndView detail(ModelMap model, @PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		Optional<MilkTeaEntity> optMilkTea = milkTeaService.findByIdMilkTea(id);
		MilkTeaModel milkTeaModel = new MilkTeaModel();

		if (optMilkTea.isPresent()) {
			MilkTeaEntity entity = optMilkTea.get();
			BeanUtils.copyProperties(entity, milkTeaModel);
			int typeId = entity.getMilkTeaTypeByMilkTea().getIdType();
			milkTeaModel.setMilkTeaType(entity.getMilkTeaTypeByMilkTea().getName());
			milkTeaModel.setMilkTeaTypeId(typeId);
	        String cartMessage = (String) redirectAttributes.getFlashAttributes().get("cartMessage");
			if (cartMessage != null) {
				model.addAttribute("cartMessage", cartMessage);
			}
			model.addAttribute("milkTea", milkTeaModel);
			List<MilkTeaEntity> list1 = milkTeaService.findFiveProductOutstanding();
			model.addAttribute("list1", list1);
			List<MilkTeaEntity> list2 = milkTeaService.findFiveProduct();
			model.addAttribute("list2", list2);
			return new ModelAndView("user/home", model);
		}
		
		model.addAttribute("message", "Sản phẩm này không tồn tại");
		return new ModelAndView("user/error", model);
	}
    
    @GetMapping("home/image/{filename:.+}")
	public ResponseEntity<Resource> serverFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
}
