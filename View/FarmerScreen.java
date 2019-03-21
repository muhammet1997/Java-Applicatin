package View;

import Model.MainModel;

import javax.swing.*;

import Controller.FarmerController;

public class FarmerScreen {

	public FarmerScreen(MainModel model) {
		generateFarmerScreen(model);
	}

	private void generateFarmerScreen(MainModel model) {
		JFrame frame = new JFrame("New Farmer");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JPanel farmerPanel = new JPanel();
		JPanel namePanel = new JPanel();
		JPanel locationPanel = new JPanel();
		JPanel productPanel = new JPanel();

		JTextField farmerName = new JTextField("Enter the farmers name: ");
		JTextField locationName = new JTextField("Enter the location name: ");
		JTextField locationZipCode = new JTextField("Enter zip code: ");
		JTextField productDescription = new JTextField("description");
		JTextField productPrice = new JTextField("price");

		JComboBox<String> genericProduct = new JComboBox<>(model.getProductList());
		JComboBox<String> units = new JComboBox<>(model.getUnitList());

		JButton locationButton = new JButton("add Location");
		JButton productButton = new JButton("add Product");
		JButton farmerButton = new JButton("add the Farmer");

		FarmerController handler = new FarmerController(model, farmerName, locationName, locationZipCode,productDescription, productPrice, genericProduct, units);
		locationButton.addActionListener(handler);
		productButton.addActionListener(handler);
		farmerButton.addActionListener(handler);

		namePanel.add(farmerName);
		locationPanel.add(locationName);
		locationPanel.add(locationZipCode);
		locationPanel.add(locationButton);
		productPanel.add(genericProduct);
		productPanel.add(productDescription);
		productPanel.add(productPrice);
		productPanel.add(units);
		productPanel.add(productButton);
		farmerPanel.add(namePanel);
		farmerPanel.add(locationPanel);
		farmerPanel.add(productPanel);
		farmerPanel.add(farmerButton);

		frame.add(farmerPanel);
		frame.setVisible(true);
	}
}
