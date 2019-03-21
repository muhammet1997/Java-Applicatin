package Model;

import java.util.ArrayList;

public class Farmer {

    private String name;
    private ArrayList<Location> locationList;
    private ArrayList<Product> productList;
    private double balance;

    public Farmer(String name) {
        this.name = name;
        locationList = new ArrayList<Location>();
        productList = new ArrayList<Product>();
    }

    public ArrayList<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(ArrayList<Location> locationList) {
        for(Location location:locationList) {
        	this.locationList.add(location);
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
    	 for(Product product:productList) {
         	this.productList.add(product);
         }
    }

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}
	
	public void addToBalance(double balance) {
		this.balance += balance;
	}
	
}
