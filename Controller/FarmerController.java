package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Farmer;
import Model.Location;
import Model.MainModel;
import Model.Product;

public class FarmerController implements ActionListener {
	private MainModel model;
	private JTextField farmerName;
	private JTextField locationName;
	private JTextField locationZipCode;
	private JTextField productDescription;
	private JTextField productPrice;
	private JComboBox<String> genericProduct;
	private JComboBox<String> units;

	public FarmerController(MainModel model, JTextField farmerName, JTextField locationName, JTextField locationZipCode,
			JTextField productDescription, JTextField productPrice, JComboBox<String> genericProduct,
			JComboBox<String> units) {
		this.model = model;
		this.farmerName = farmerName;
		this.locationName = locationName;
		this.locationZipCode = locationZipCode;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.genericProduct = genericProduct;
		this.units = units;
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		// locations
		if (button.getText().equals("add Location")) {
			int zipCode = 0;
			if (locationName.getText().equals("") || locationName.getText() == null) {
				JOptionPane.showMessageDialog(null, "Location name can not be empty.");
			}
			boolean isLcodeOk = true;
			try {
				zipCode = Integer.parseInt(locationZipCode.getText());
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null, "Enter int location code.");

				isLcodeOk = false;
			}
			if (isLcodeOk) {
				model.getFarmerLocations().add(new Location(locationName.getText(), zipCode));
				JOptionPane.showMessageDialog(null, "Location added.");
			}
		}
		// products
		else if (button.getText().equals("add Product")) {
			if (productDescription.getText().equals("") || productDescription.getText() == null) {
				JOptionPane.showMessageDialog(null, "Product name can not be empty.");
			}
			boolean isProductPriceOk = true;
			double pPrice = 0;
			try {
				pPrice = Double.parseDouble(productPrice.getText());
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null, "Enter double price.");
				isProductPriceOk = false;
			}
			if (isProductPriceOk) {
				model.getProducts().add(new Product(genericProduct.getSelectedItem().toString(),
						productDescription.getText(), pPrice, units.getSelectedItem().toString()));
				JOptionPane.showMessageDialog(null, "Product added.");
			}
		} else if (button.getText().equals("add the Farmer")) {
			if (farmerName.getText().equals("") || farmerName.getText() == null) {
				JOptionPane.showMessageDialog(null, "Farmer name can not be empty.");
			} else {
				if (model.getFarmerLocations().size() != 0 && model.getProducts().size() != 0) {
					Farmer farmer = new Farmer(farmerName.getText());
					farmer.setLocationList(model.getFarmerLocations());
					farmer.setProductList(model.getProducts());
					model.getFarmers().add(farmer);
					model.getFarmerLocations().clear();
					model.getProducts().clear();
					JOptionPane.showMessageDialog(null, "Farmer added.");
				} else {
					JOptionPane.showMessageDialog(null, "Locations or products are empty.");
				}
			}
		}

	}
}
