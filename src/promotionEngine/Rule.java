package promotionEngine;

public class Rule {
	private int id;
	private String promotionType;
	private String skuid;
	private int quantity;
	private double promotionPrice;
	
	public Rule() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	public String getSkuid() {
		return skuid;
	}

	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(double promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	@Override
	public String toString() {
		return "Rule [id=" + id + ", promotionType=" + promotionType + ", skuid=" + skuid + ", quantity=" + quantity
				+ ", promotionPrice=" + promotionPrice + "]";
	}
	
}