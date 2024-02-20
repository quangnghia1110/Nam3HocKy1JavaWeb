package hcmute.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilkTeaTypeModel{
	private int idType;
	private String name;
	private MilkTeaCategoryModel milkTeaCategoryByMilkTeaType;
	private MilkTeaModel milkTeas;
	private int idCategory;
	private Boolean isEdit = false;
	
}
