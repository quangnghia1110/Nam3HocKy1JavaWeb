package hcmute.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hcmute.model.AuthProvider;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING) 
    private AuthProvider provider;
    private Boolean enabled;
    private String verify_code;
    private String reset_pwd_token;
    
    @Column(name = "surname",columnDefinition = "nvarchar(50)")
	private String surname;
	
	@Column(name = "name",columnDefinition = "nvarchar(50)")
	private String name;
	
	@Column(name = "birthday")
	private LocalDate birthday;
	
	@Column(name = "phone_number",columnDefinition = "varchar(50)")
	private String phoneNumber;
	
	@Column(name = "image_url", columnDefinition = "varchar(255)")
	private String imageUrl;
	
	@Column(name = "gender")
	private int gender;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRoleEntity> authorities;
    
    @ManyToOne
	@JoinColumn(name = "id_branch")
	private BranchEntity branchByUser;
    
    @OneToOne(mappedBy = "customerByCart")
	private CartEntity cart;
	
	@OneToMany(mappedBy = "customerByOrder")
	private Set<OrderEntity> orders;
}
