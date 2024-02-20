package hcmute.entity;

import java.io.Serializable;
import javax.persistence.*;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_role", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "id", "role_id" })
})
public class UserRoleEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer role_user_id;
	@ManyToOne
	@JoinColumn(name = "id")
	private UserEntity user;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEntity role;
	
	 public UserRoleEntity(UserEntity user, RoleEntity role) {
	        this.user = user;
	        this.role = role;
	    }
}
