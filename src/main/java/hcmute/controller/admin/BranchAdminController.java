package hcmute.controller.admin;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.http.HttpHeaders;
import hcmute.entity.BranchEntity;
import hcmute.model.BranchModel;
import hcmute.service.IBranchService;
import hcmute.service.IStorageService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("admin/branch")
public class BranchAdminController {

	@Autowired
	private IBranchService branchService;

	@Autowired
	private IStorageService storageService;

	@GetMapping("")
	public String indexViewBranch(ModelMap model) {
		List<BranchEntity> branches = branchService.findAll();
		model.addAttribute("branches", branches); // Updated attribute name to "branches"
		return "admin/view/view-branch";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		BranchModel branch = new BranchModel();
		branch.setIsEdit(false);
		model.addAttribute("branch", branch);
		return "admin/customize/customize-branch";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("branch") BranchModel branch,
			BindingResult result) {
		if (branch != null) {
			BranchEntity entity = new BranchEntity();
			if (branch.getIdBranch() != null) {
				entity.setIdBranch(branch.getIdBranch());
			}
			if (branch.getName() != null) {
				entity.setName(branch.getName());
			}
			if (branch.getAddressDetail() != null) {
				entity.setAddressDetail(branch.getAddressDetail());
			}
			if (branch.getOpentime() != null) {
				entity.setOpentime(branch.getOpentime());
			}
			if (branch.getImage() != null) {
				entity.setImage(branch.getImage());
			}
			if (branch.getDescription() != null) {
				entity.setDescription(branch.getDescription());
			}
			if (branch.getIdCity() != null) {
				entity.setIdCity(branch.getIdCity());
			}
			if (branch.getImageFile() !=null && !branch.getImageFile().isEmpty()) {
				UUID uuid = UUID.randomUUID();
				String uuString = uuid.toString();
				entity.setImage(storageService.getStorageFilename(branch.getImageFile(), uuString));
				storageService.store(branch.getImageFile(), entity.getImage());
			}
			branchService.save(entity);
			String message = branch.getIsEdit() ? "Branch đã được cập nhật thành công"
					: "Branch đã được thêm thành công";
			model.addAttribute("message", message);
		}else {
			model.addAttribute("message", "Không thể lưu Branch với dữ liệu null");
		}

		return new ModelAndView("redirect:/admin/branch", model);
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
		Optional<BranchEntity> opt = branchService.findById(idBranch);
		BranchModel branch = new BranchModel();
		if (opt.isPresent()) {
			BranchEntity entity = opt.get();
			BeanUtils.copyProperties(entity, branch);
			branch.setIsEdit(true);
			model.addAttribute("branch", branch);
			return new ModelAndView("admin/customize/customize-branch", model);
		}

		model.addAttribute("message", "Branch không tồn tại");
		return new ModelAndView("forward:/admin/branch", model);
	}

	@GetMapping("delete/{idBranch}")
	public ModelAndView delete(ModelMap model, @PathVariable("idBranch") int idBranch) {
		branchService.deleteById(idBranch);
		model.addAttribute("message", "Branch đã xóa thành công");
		return new ModelAndView("forward:/admin/branch", model);
	}
}
