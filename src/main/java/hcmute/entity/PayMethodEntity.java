package hcmute.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pay_method")
public class PayMethodEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_pay_method",columnDefinition = "varchar(100)")
	private String idPayMethod;
	
	@Column(name = "name",columnDefinition = "nvarchar(100)")
	private String name;
	
	@OneToMany(mappedBy = "payMethodByOrder")
	private Set<OrderEntity> orders;
}
