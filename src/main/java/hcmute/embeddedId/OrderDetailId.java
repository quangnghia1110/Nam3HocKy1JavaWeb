package hcmute.embeddedId;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import hcmute.model.OrderData;
import hcmute.model.OrderData.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_order")
	private int idOrder;
	
	@Column(name = "id_milk_tea")
	private int idMilkTea;
	
	@Column(name = "size", columnDefinition = "nvarchar(50)")
	private String size;

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdMilkTea() {
		return idMilkTea;
	}

	public void setIdMilkTea(int idMilkTea) {
		this.idMilkTea = idMilkTea;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMilkTea, idOrder, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailId other = (OrderDetailId) obj;
		return idMilkTea == other.idMilkTea && idOrder == other.idOrder && Objects.equals(size, other.size);
	}
}
