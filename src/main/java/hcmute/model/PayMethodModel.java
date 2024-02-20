package hcmute.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayMethodModel{
	private String idPayMethod;
	private String name;
	private OrderModel orders;
	private Boolean isEdit = false;
}
