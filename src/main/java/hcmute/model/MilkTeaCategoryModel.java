package hcmute.model;
import java.util.Set;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilkTeaCategoryModel{
	private int idCategory;
	private String name;	
	private Set<MilkTeaTypeModel> milkTeaTypes;
	private Boolean isEdit = false;
}
