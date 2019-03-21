package Model;

public class Product {


    private String desctiption;
    private String genericProduct;
    private double price;
    private String unit;
    private double amount;

    public Product(String genericProduct ,String desctiption, double price, String unit) {
        this.genericProduct = genericProduct;
        this.desctiption = desctiption;
        this.price = price;
        this.unit = unit;
    }

	public String getDesctiption() {
		return desctiption;
	}

	public String getGenericProduct() {
		return genericProduct;
	}

	public double getPrice() {
		return price;
	}

	public String getUnit() {
		return unit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double calculateTotalPrice() {
		return amount*price;
	}
}
