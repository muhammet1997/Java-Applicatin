package Model;

public class Location {

    private String name;
    private int zipCode;

    public Location(String name, int zipCode) {
        this.name = name;
        this.zipCode = zipCode;
    }

	public String getName() {
		return name;
	}

	public int getZipCode() {
		return zipCode;
	}

}
