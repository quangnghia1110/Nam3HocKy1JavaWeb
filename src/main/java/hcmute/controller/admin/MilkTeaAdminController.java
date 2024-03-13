package hcmute.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import hcmute.entity.BranchEntity;
import hcmute.entity.MilkTeaCategoryEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.entity.MilkTeaTypeEntity;
import hcmute.model.BranchModel;
import hcmute.model.MilkTeaModel;
import hcmute.service.IMilkTeaService;
import hcmute.service.IMilkTeaTypeService;
import hcmute.service.IStorageService;

@Controller
@RequestMapping("admin/milk-tea")
public class MilkTeaAdminController {

	@Autowired
	private IMilkTeaService milkTeaService;

	@Autowired
	private IStorageService storageService;
	
	@Autowired
	private IMilkTeaTypeService milkTeaTypeService;

	@GetMapping("")
	public String IndexViewMilkTea(ModelMap model) {
		List<MilkTeaEntity> milkTeas = milkTeaService.findAll();
		model.addAttribute("milkTeas", milkTeas);
		return "admin/view/view-milk-tea";
	}
	@GetMapping("add")
	public String add(ModelMap model) {
		MilkTeaModel milkTea = new MilkTeaModel();
		milkTea.setIsEdit(false);
		model.addAttribute("milkTea", milkTea);
		return "admin/customize/customize-milk-tea";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("milkTea") MilkTeaModel milkTea,
	        BindingResult result, @RequestParam("imageFile") MultipartFile imageFile) {
	    if (milkTea != null) {
	    	MilkTeaEntity entity = new MilkTeaEntity();
			entity.setIdMilkTea(entity.getIdMilkTea());
	            
	            if (milkTea.getName() != null) {
	                entity.setName(milkTea.getName());
	            }
	            entity.setCost(milkTea.getCost());
	            if (milkTea.getDescription() != null) {
	                entity.setDescription(milkTea.getDescription());
	            }
	            if (milkTea.getImage() != null) {
	                entity.setImage(milkTea.getImage());
	            }
	            Optional<MilkTeaTypeEntity> opt = milkTeaTypeService.findById(milkTea.getMilkTeaTypeId());
	            if (opt.isPresent()) {
	                entity.setMilkTeaTypeByMilkTea(opt.get());
	            } else {
	                // Handle the case where MilkTeaType is not found
	                System.out.println("MilkTeaType with ID " + milkTea.getMilkTeaTypeId() + " not found!");
	                // You can choose to throw an exception, return an error message, or take other appropriate action
	            }
	            if (!milkTea.getImageFile().isEmpty()) {
	                UUID uuid = UUID.randomUUID();
	                String uuString = uuid.toString();
	                entity.setImage(storageService.getStorageFilename(milkTea.getImageFile(), uuString));
	                storageService.store(milkTea.getImageFile(), entity.getImage());
	            }
	            milkTeaService.save(entity);
	            String message = milkTea.getIsEdit() ? "MilkTea đã được cập nhật thành công"
	                    : "MilkTea đã được thêm thành công";
	            model.addAttribute("message", message);
	    } else {
	        model.addAttribute("message", "Không thể lưu MilkTea với dữ liệu null");
	    }
	    return new ModelAndView("redirect:/admin/milk-tea", model);
	}


	@GetMapping("/image/{filename:.+}")
	public ResponseEntity<Resource> serverFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	@GetMapping("edit/{idBranch}")
	public ModelAndView edit(ModelMap model, @PathVariable("idBranch") int idBranch) {
		Optional<MilkTeaEntity> opt = milkTeaService.findById(idBranch);
		MilkTeaModel milkTea = new MilkTeaModel();
		if (opt.isPresent()) {
			MilkTeaEntity entity = opt.get();
			BeanUtils.copyProperties(entity, milkTea);
			milkTea.setIsEdit(true);
			milkTea.setMilkTeaTypeId(entity.getMilkTeaTypeByMilkTea().getIdType());
			model.addAttribute("milkTea", milkTea);
			return new ModelAndView("admin/customize/customize-milk-tea", model);
		}

		model.addAttribute("message", "Branch không tồn tại");
		return new ModelAndView("forward:/admin/milk-tea", model);
	}

}
