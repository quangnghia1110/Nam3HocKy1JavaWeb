package hcmute.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hcmute.entity.BranchEntity;
import hcmute.entity.CartEntity;
import hcmute.entity.OrderEntity;
import hcmute.entity.UserRoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private int id;
    private String username;
    private String password;
    private String email;
    private AuthProvider provider;
    private Boolean enabled;
    private String verify_code;
    private String reset_pwd_token;
	private String surname;
	private String name;
	private String birthday;
	private String phoneNumber;
	private String imageUrl;
	private int gender;
    private List<UserRoleEntity> authorities;
	private BranchEntity branchByUser;
	private Set<CartEntity> carts;
	private Set<OrderEntity> orders;
	private Boolean isEdit;
}
