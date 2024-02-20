package hcmute.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityModel{
	private String idCity;
	private String name;
	private BranchModel branches;
	private Boolean isEdit = false;
}
