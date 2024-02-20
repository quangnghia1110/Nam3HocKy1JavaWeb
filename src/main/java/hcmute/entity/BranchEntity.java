package hcmute.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name = "branch")
public class BranchEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_branch")
	private int idBranch;
	
	@Column(name = "name", columnDefinition = "nvarchar(1000)")
	private String name;
	
	@Column(name = "address_detail",columnDefinition = "nvarchar(1000)")
	private String addressDetail;
	
	@Column(name = "opentime",columnDefinition = "varchar(50)")
	private String opentime;
	
	@Column(name = "image",columnDefinition = "varchar(1000)")
	private String image;
	
	@Column(name = "description",columnDefinition = "nvarchar(1000)")
	private String description;
	
	@Column(name = "id_city",columnDefinition = "varchar(100)")
	private String idCity;
	
	@ManyToOne
	@JoinColumn(name = "id_city",insertable = false, updatable = false)
	private CityEntity cityByBranch;
	
	@OneToMany(mappedBy = "branchByUser")
	private Set<UserEntity> accounts;
	
	@OneToMany(mappedBy = "branchByOrder")
	private Set<OrderEntity> orders;
	
	@OneToMany(mappedBy = "branchByBranchMilkTea")
	private Set<BranchMilkTea> branchMilkTeas;
	public int getIdBranch() {
		return idBranch;
	}

	public Set<UserEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<UserEntity> accounts) {
		this.accounts = accounts;
	}

	public Set<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderEntity> orders) {
		this.orders = orders;
	}

	public Set<BranchMilkTea> getBranchMilkTeas() {
		return branchMilkTeas;
	}

	public void setBranchMilkTeas(Set<BranchMilkTea> branchMilkTeas) {
		this.branchMilkTeas = branchMilkTeas;
	}

	public void setIdBranch(int idBranch) {
		this.idBranch = idBranch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdCity() {
		return idCity;
	}

	public void setIdCity(String idCity) {
		this.idCity = idCity;
	}

	public CityEntity getCityByBranch() {
		return cityByBranch;
	}

	public void setCityByBranch(CityEntity cityByBranch) {
		this.cityByBranch = cityByBranch;
	}

	public BranchEntity(int idBranch, String name, String addressDetail, String opentime, String image,
			String description, CityEntity cityByBranch) {
		super();
		this.idBranch = idBranch;
		this.name = name;
		this.addressDetail = addressDetail;
		this.opentime = opentime;
		this.image = image;
		this.description = description;
		this.idCity = cityByBranch.getIdCity();
		this.cityByBranch = cityByBranch;
	}

	public BranchEntity() {
		super();
	}
	
	
}
