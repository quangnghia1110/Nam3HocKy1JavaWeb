package hcmute.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hcmute.embeddedId.CartDetailId;
import hcmute.embeddedId.OrderDetailId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_detail")
public class OrderDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailId idOrderDetail;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "curr_price")
	private int currPrice;
	
	@ManyToOne
	@JoinColumn(name = "id_order", insertable = false, updatable = false)
	private OrderEntity orderByOrderDetail;

	@ManyToOne
	@JoinColumn(name = "id_milk_tea", insertable = false, updatable = false)
	private MilkTeaEntity milkTeaByOrderDetail;

	public OrderDetailEntity(OrderDetailId idOrderDetail, int quantity, int currPrice, OrderEntity orderByOrderDetail,
			MilkTeaEntity milkTeaByOrderDetail) {
		super();
		this.idOrderDetail = idOrderDetail;
		this.quantity = quantity;
		this.currPrice = currPrice;
		this.orderByOrderDetail = orderByOrderDetail;
		this.milkTeaByOrderDetail = milkTeaByOrderDetail;
	}

	public OrderDetailEntity() {
		super();
	}

	public OrderDetailId getIdOrderDetail() {
		return idOrderDetail;
	}

	public void setIdOrderDetail(OrderDetailId idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCurrPrice() {
		return currPrice;
	}

	public void setCurrPrice(int currPrice) {
		this.currPrice = currPrice;
	}

	public OrderEntity getOrderByOrderDetail() {
		return orderByOrderDetail;
	}

	public void setOrderByOrderDetail(OrderEntity orderByOrderDetail) {
		this.orderByOrderDetail = orderByOrderDetail;
	}

	public MilkTeaEntity getMilkTeaByOrderDetail() {
		return milkTeaByOrderDetail;
	}

	public void setMilkTeaByOrderDetail(MilkTeaEntity milkTeaByOrderDetail) {
		this.milkTeaByOrderDetail = milkTeaByOrderDetail;
	}
}
