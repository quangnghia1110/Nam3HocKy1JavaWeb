package hcmute.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchModel{
	private Integer idBranch;
	private String name;
	private String addressDetail;
	private String opentime;
	private String image;
	private MultipartFile imageFile;
	private String description;
	private String idCity;
	private Boolean isEdit = false;
}
