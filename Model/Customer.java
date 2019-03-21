package Model;

public class Customer {

    private String name;
    private Location location;
    private double balance;

    public Customer(String name, Location location) {
        this.name = name;
        this.location = location;
    }

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}
	public void subtractFromBalance(double balance) {
		this.balance -= balance;
	}
	
    
}
