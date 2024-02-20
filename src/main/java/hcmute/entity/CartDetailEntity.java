package hcmute.entity;

import java.io.Serializable;

import javax.persistence.*;

import hcmute.embeddedId.CartDetailId;
import lombok.*;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_detail")
public class CartDetailEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CartDetailId idCartDetail;
	
	@ManyToOne
	@JoinColumn(name = "id_cart",insertable = false, updatable = false)
	private CartEntity cartByCartDetail;
	
	@ManyToOne
	@JoinColumn(name = "id_milk_tea",insertable = false, updatable = false)
	private MilkTeaEntity milkTeaByCartDetail;
}
