package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import hcmute.embeddedId.CartDetailId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "city")
public class CityEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_city", columnDefinition = "varchar(100)")
	private String idCity;
	
	@Column(name = "name", columnDefinition = "nvarchar(50)")
	private String name;
	
	@OneToMany(mappedBy = "cityByBranch")
	private Set<BranchEntity> branches;
}
