package Model;

import java.util.ArrayList;

public class MainModel {
	private String[] productList;
	private String[] unitList;
	private ArrayList<Farmer> farmers;
	private ArrayList<Customer> customers;
	private ArrayList<Location> farmerLocations;
	private ArrayList<Product> products;
	private ArrayList<Product> goods;
	private double balanceOfBank;
	private String basket;
	private double totalPrice;
	public MainModel() {
		productList = new String[] { "milk", "cheese", "egg", "meat", "tomato", "potato", "apple", "olive oil","artichoke" };
		unitList = new String[] { "liters", "kgs", "pieces" };
		farmers = new ArrayList<Farmer>();
		customers = new ArrayList<Customer>();
		farmerLocations = new ArrayList<Location>();
		products = new ArrayList<Product>();
		goods = new ArrayList<Product>();
		balanceOfBank=0;
		basket="You are buying";
		totalPrice=0;
	}

	public String getBasket() {
		return basket;
	}

	public void addItemToBasket(String basket) {
		this.basket += basket;
	}

	public String[] getProductList() {
		return productList;
	}

	public String[] getUnitList() {
		return unitList;
	}
	public ArrayList<Farmer> getFarmers() {
		return farmers;
	}

	public ArrayList<Location> getFarmerLocations() {
		return farmerLocations;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public double getBalanceOfBank() {
		return balanceOfBank;
	}

	public void addToBalanceOfBank(double balanceOfBank) {
		this.balanceOfBank += balanceOfBank;
	}

	public ArrayList<Product> getGoods() {
		return goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void addToTotalPrice(double totalPrice) {
		this.totalPrice += totalPrice;
	}
}
