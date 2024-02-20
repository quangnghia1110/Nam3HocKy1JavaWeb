package hcmute.model;

import hcmute.embeddedId.OrderDetailId;
import hcmute.entity.MilkTeaEntity;
import hcmute.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel{
	private OrderDetailId idOrderDetail;
	private int quantity;
	private int currPrice;
	private int size;
	private OrderModel orderByOrderDetail;
	private MilkTeaModel milkTeaByOrderDetail;
}
