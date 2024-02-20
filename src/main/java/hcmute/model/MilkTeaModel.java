package hcmute.model;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import hcmute.entity.BranchMilkTea;
import hcmute.entity.CartDetailEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilkTeaModel {
	private int idMilkTea;
	private String name;
	private int cost;
	private String description;
	private int orderQuantity;
	private String image;
	private MultipartFile imageFile;

	// use for product detail
	private String milkTeaType;
	private String size;
	private int milkTeaTypeId;
	private int branchId;

	private MilkTeaTypeModel milkTeaTypeByMilkTea;
	private Set<CartDetailEntity> cartDetails;;
	private Set<BranchMilkTea> branchMilkTeas;
	private Boolean isEdit = false;
}
