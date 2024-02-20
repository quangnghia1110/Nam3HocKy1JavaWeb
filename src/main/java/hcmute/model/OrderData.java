package hcmute.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderData {
	 private String address;
	    private String phoneNumber;
	    private String note;
	    private int totalPrice;
	    private int totalProduct;
	    private int finalPrice;
	    private String orderDay;
	    private String shipDay;
	    private String idPayMethod;
	    private List<OrderItem> list;
	    private int orderState;
	    private int idBranch;
	    private int fee;

	    @Data
	    @NoArgsConstructor
	    @AllArgsConstructor
	    public static class OrderItem {
	        private int idMilkTea;
	        private String size;
	        private int quantity;
	        private int price;
	    }
}
