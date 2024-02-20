package hcmute.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import hcmute.entity.BranchEntity;
import hcmute.entity.PayMethodEntity;
import hcmute.entity.UserEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel{
	private int idOrder;
	private int totalProduct;
	private int totalPrice;
	private int finalPrice;
	private LocalDateTime orderDay;
	private int orderState;
	private LocalDateTime shipDay;
	private String note;
	private String address;
	private String phoneNumber;
	private int fee;
	private PayMethodEntity payMethodByOrder;
	private UserEntity customerByOrder;
	private BranchEntity branchByOrder;
	private Boolean isEdit;
}
