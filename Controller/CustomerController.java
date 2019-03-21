package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.synth.SynthStyleFactory;

import Model.Customer;
import Model.Location;
import Model.MainModel;

public class CustomerController implements ActionListener {
	private JTextField customerName;
	private JTextField locationName;
	private JTextField locationCode;
	private JTextField initialBalance;
	private MainModel model;

	public CustomerController(MainModel model, JTextField customerName, JTextField locationName,
			JTextField locationCode, JTextField initialBalance) {
		this.model = model;
		this.customerName = customerName;
		this.locationName = locationName;
		this.locationCode = locationCode;
		this.initialBalance = initialBalance;
	}

	public void actionPerformed(ActionEvent e) {
		if (customerName.getText().equals("") || customerName.getText() == null) {
			JOptionPane.showMessageDialog(null, "Customer name can not be empty.");
		} else if (locationName.getText().equals("") || locationName.getText() == null) {
			JOptionPane.showMessageDialog(null, "Location name can not be empty.");
		} else {
			double balance = 0;
			int zipCode = 0;
			boolean isLCode = true;
			boolean isInitBalance = true;
			try {
				zipCode = Integer.parseInt(locationCode.getText());
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null, "Enter int location code.");
				isLCode = false;
			}
			try {
				balance = Double.parseDouble(initialBalance.getText());
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null, "Enter double balance.");
				isInitBalance = false;
			}
			if (isLCode && isInitBalance) {
				Customer customer = new Customer(customerName.getText(), new Location(locationName.getText(), zipCode));
				customer.setBalance(balance);
				model.getCustomers().add(customer);
				JOptionPane.showMessageDialog(null, "Customer added.");
			}

		}

	}
}
