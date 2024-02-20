package hcmute.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hcmute.entity.RoleEntity;
import hcmute.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleModel {
	private Integer role_user_id;
	private UserEntity user;
	private RoleEntity role;
	private int user_id;
	private String role_id;
	private int idBranch;
	private Boolean isEdit;
}
