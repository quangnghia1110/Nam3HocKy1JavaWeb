package hcmute.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartModel{
	private int idCart;
	private int totalProduct;
	private int totalPrice;
	private UserModel customerByCart;
	private Set<CartDetailModel> cartDetails;
	private Boolean isEdit = false;
}
