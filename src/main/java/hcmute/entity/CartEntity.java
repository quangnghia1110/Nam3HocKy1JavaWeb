package hcmute.entity;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "cart")
public class CartEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cart")
	private int idCart;
	
	@Column(name = "total_product")
	private int totalProduct;
	
	@Column(name = "total_price")
	private int totalPrice;
	
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private UserEntity customerByCart;
	
	@OneToMany(mappedBy = "cartByCartDetail")
	private Set<CartDetailEntity> cartDetails;
}
