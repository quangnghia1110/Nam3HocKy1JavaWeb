package hcmute.model;

import java.util.List;

public class OrderProduct {

	private List<OrderItem> list;
	private String totalProduct;
	private int totalPrice;
	
	public OrderProduct() {
	}

	public OrderProduct(List<OrderItem> list, String totalProduct, int totalPrice) {
		this.list = list;
		this.totalProduct = totalProduct;
		this.totalPrice = totalPrice;
	}

	public List<OrderItem> getList() {
		return list;
	}

	public void setList(List<OrderItem> list) {
		this.list = list;
	}

	public String getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(String totalProduct) {
		this.totalProduct = totalProduct;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public static class OrderItem {
		private String idMilkTea;
		private String quantity;
		private int price;
		private String size;
		

		public OrderItem() {
		}

		public OrderItem(String idMilkTea, String quantity, int price, String size) {
			this.idMilkTea = idMilkTea;
			this.quantity = quantity;
			this.price = price;
			this.size = size;
		}

		public String getIdMilkTea() {
			return idMilkTea;
		}

		public void setIdMilkTea(String idMilkTea) {
			this.idMilkTea = idMilkTea;
		}

		public String getQuantity() {
			return quantity;
		}

		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

	}

}

