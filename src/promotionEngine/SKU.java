package promotionEngine;

public class SKU {
	// Stock Keeping Unit class.
	private String id;
	private double price;
	private int quantity = 1;
	
	public SKU() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return "ID: " + id + " Price: " + price + " Quantity: " + quantity;
	}

}
