
package hcmute.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "user_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private int idOrder;

	@Column(name = "total_product")
	private int totalProduct;

	@Column(name = "total_price")
	private int totalPrice;
	
	@Column(name = "final_price")
	private int finalPrice;

	@Column(name = "order_day", columnDefinition = "datetime2")
	private LocalDateTime orderDay;

	@Column(name = "order_state")
	private int orderState;

	@Column(name = "ship_day", columnDefinition = "datetime2")
	private LocalDateTime shipDay;
	
	@Column(name = "fee")
	private int fee;
	
	@Column(name = "note", columnDefinition = "nvarchar(1000)")
	private String note;
	
	@Column(name = "address", columnDefinition = "nvarchar(1000)")
	private String address;
	
	@Column(name = "phoneNumber",columnDefinition = "varchar(50)")
	private String phoneNumber;
	
	
	@ManyToOne
	@JoinColumn(name = "id_pay_method")
	private PayMethodEntity payMethodByOrder;

	@ManyToOne
	@JoinColumn(name = "id_branch")
	private BranchEntity branchByOrder;
  
	@ManyToOne
	@JoinColumn(name = "id")
	private UserEntity customerByOrder;

	@OneToMany(mappedBy = "orderByOrderDetail")
	private Set<OrderDetailEntity> orderDetails;

	public OrderEntity(Integer idOrder, int totalProduct, int totalPrice, int finalPrice, LocalDateTime orderDay,
			int orderState, LocalDateTime shipDay, String note, String address, String phoneNumber,
			PayMethodEntity payMethodByOrder, UserEntity customerByOrder, Set<OrderDetailEntity> orderDetails, BranchEntity branchByOrder) {
		super();
		this.idOrder = idOrder;
		this.totalProduct = totalProduct;
		this.totalPrice = totalPrice;
		this.finalPrice = finalPrice;
		this.orderDay = orderDay;
		this.orderState = orderState;
		this.shipDay = shipDay;
		this.note = note;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.payMethodByOrder = payMethodByOrder;
		this.customerByOrder = customerByOrder;
		this.orderDetails = orderDetails;
		this.branchByOrder = branchByOrder;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public BranchEntity getBranchByOrder() {
		return branchByOrder;
	}

	public void setBranchByOrder(BranchEntity branchByOrder) {
		this.branchByOrder = branchByOrder;
	}

	public OrderEntity() {
		super();
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public int getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(int totalProduct) {
		this.totalProduct = totalProduct;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	public LocalDateTime getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(LocalDateTime localDateTime) {
		this.orderDay = localDateTime;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public LocalDateTime getShipDay() {
		return shipDay;
	}

	public void setShipDay(LocalDateTime shipDay) {
		this.shipDay = shipDay;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PayMethodEntity getPayMethodByOrder() {
		return payMethodByOrder;
	}

	public void setPayMethodByOrder(PayMethodEntity payMethodByOrder) {
		this.payMethodByOrder = payMethodByOrder;
	}

	public UserEntity getCustomerByOrder() {
		return customerByOrder;
	}

	public void setCustomerByOrder(UserEntity customerByOrder) {
		this.customerByOrder = customerByOrder;
	}

	public Set<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}	
}
