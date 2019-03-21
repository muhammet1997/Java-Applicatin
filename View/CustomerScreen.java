package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.CustomerController;
import Model.MainModel;

public class CustomerScreen {
	public CustomerScreen(MainModel model) {
		generateCustomerScreen(model);
	}

	private void generateCustomerScreen(MainModel model) {
		JFrame frame = new JFrame("New Customer");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JPanel mainPanel = new JPanel();

		JTextField customerName = new JTextField("Customer name:");
		JTextField locationName = new JTextField("Customer location:");
		JTextField locationCode = new JTextField("Location Zip Code:");
		JTextField initialBalance = new JTextField("Initial balance:");
		JButton customerButton = new JButton("add Customer");

		CustomerController handler = new CustomerController(model, customerName, locationName, locationCode,
				initialBalance);
		customerButton.addActionListener(handler);

		mainPanel.add(customerName);
		mainPanel.add(locationName);
		mainPanel.add(locationCode);
		mainPanel.add(initialBalance);
		mainPanel.add(customerButton);

		frame.add(mainPanel);
		frame.setVisible(true);
	}
}
