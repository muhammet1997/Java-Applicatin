package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Customer;
import Model.Farmer;
import Model.Location;
import Model.MainModel;
import Model.Product;

public class OrderController implements ActionListener {
	private String selectedCustomer;
	private String selectedFarmer;
	private String selectedProduct;
	private JComboBox<String> list;
	private JComboBox<String> affectedList;
	private JLabel text;
	private JLabel text2;
	private JTextField amount;
	private JTextArea basket;
	private JPanel firstPanel;
	private JPanel secondPanel;
	private JFrame frame;
	private MainModel model;

	public OrderController(JComboBox<String> list, JComboBox<String> affectedList, JLabel text, JPanel firstPanel,
			JPanel secondPanel, MainModel model) {
		this.list = list;
		this.affectedList = affectedList;
		this.text = text;
		this.firstPanel = firstPanel;
		this.secondPanel = secondPanel;
		this.model = model;
	}

	public OrderController(JComboBox<String> farmers, JComboBox<String> products, JTextField amount, JTextArea basket,
			JPanel panel13, JPanel panel14, MainModel model) {
		this.list = farmers;
		this.affectedList = products;
		this.amount = amount;
		this.basket = basket;
		this.firstPanel = panel13;
		this.secondPanel = panel14;
		this.model = model;
	}

	public OrderController(JComboBox<String> customers, JComboBox<String> farmers, JLabel balanceOfCustomer,
			JLabel balanceOfFarmer, JFrame frame, MainModel model) {
		this.list = customers;
		this.affectedList = farmers;
		this.text = balanceOfCustomer;
		this.text2 = balanceOfFarmer;
		this.frame = frame;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.getText().equals("Done")) {
			selectedCustomer = list.getSelectedItem().toString();
			affectedList.removeAllItems();
			for (String farmerName : getFarmerNames(model)) {
				affectedList.addItem(farmerName);
			}
			text.setText("Your Balance: " + getSelectedCustomer().getBalance() + " TL");
			firstPanel.setVisible(true);
			secondPanel.setVisible(true);
		} else if (button.getText().equals(" Done")) {
			selectedFarmer = list.getSelectedItem().toString();
			affectedList.removeAllItems();
			for (String productName : getProductNames(model)) {
				affectedList.addItem(productName);
			}
			text.setText("Farmers Balance: " + getSelectedFarmer().getBalance() + " TL");
			firstPanel.setVisible(true);
			secondPanel.setVisible(true);
		} else if (button.getText().equals(" Done ")) {
			selectedFarmer = list.getSelectedItem().toString();
			selectedProduct = affectedList.getSelectedItem().toString();
			text.setText(getSelectedProduct().getDesctiption() + " #Unit price:" + getSelectedProduct().getPrice()
					+ " TL/" + getSelectedProduct().getUnit());
			firstPanel.setVisible(true);
			secondPanel.setVisible(true);
		} else if (button.getText().equals("Add to Basket")) {
			double amountValue = 0;
			boolean isAMountValueOk = true;
			try {
				amountValue = Double.parseDouble(amount.getText());
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null, "Enter double amount value.");
				isAMountValueOk = false;
			}
			if (isAMountValueOk) {
				selectedFarmer = list.getSelectedItem().toString();
				selectedProduct = affectedList.getSelectedItem().toString();
				Product item = new Product(getSelectedProduct().getGenericProduct(), "",
						getSelectedProduct().getPrice(), getSelectedProduct().getUnit());
				item.setAmount(amountValue);
				model.getGoods().add(item);
				model.addItemToBasket(", " + getSelectedProduct().getGenericProduct() + " " + amount.getText() + " "
						+ getSelectedProduct().getUnit());
				this.basket.setText(model.getBasket());
				firstPanel.setVisible(true);
				secondPanel.setVisible(true);
			}
		} else if (button.getText().equals("ORDER")) {
			selectedCustomer = list.getSelectedItem().toString();
			selectedFarmer = affectedList.getSelectedItem().toString();
			for (Product item : model.getGoods()) {
				model.addToTotalPrice(item.calculateTotalPrice());
			}
			getSelectedCustomer().subtractFromBalance(model.getTotalPrice());
			getSelectedFarmer().addToBalance(model.getTotalPrice() * 0.98);
			model.addToBalanceOfBank(model.getTotalPrice() * 0.02);
			text.setText("Your Balance: " + getSelectedCustomer().getBalance() + " TL");
			text2.setText("Farmers Balance: " + getSelectedFarmer().getBalance() + " TL");
			JOptionPane.showMessageDialog(null, "Your order is placed!");
			frame.dispose();
		}
	}

	private Customer getSelectedCustomer() {
		for (Customer customer : model.getCustomers()) {
			if (customer.getName().equals(selectedCustomer)) {
				return customer;
			}
		}
		return null;
	}

	private String[] getFarmerNames(MainModel model) {
		String[] names = new String[model.getFarmers().size()];
		int count = 0;
		for (Farmer farmer : model.getFarmers()) {
			for (Location locOfFarmer : farmer.getLocationList()) {
				if (locationComparator(locOfFarmer, getSelectedCustomer().getLocation())) {
					names[count] = farmer.getName();
					count++;
				}
			}
		}
		return trimStringArray(names);
	}

	private String[] trimStringArray(String[] str) {
		String[] newstr;
		int count = 0;
		for (String string : str) {
			if (string == null) {
				count++;
			}
		}
		newstr = new String[str.length - count];
		for (int i = 0; i < str.length - count; i++) {
			newstr[i] = str[i];
		}
		return newstr;
	}

	private boolean locationComparator(Location loc1, Location loc2) {
		if (loc1.getName().equals(loc2.getName()) && loc1.getZipCode() == loc2.getZipCode()) {
			return true;
		} else
			return false;
	}

	private Farmer getSelectedFarmer() {
		for (Farmer farmer : model.getFarmers()) {
			if (farmer.getName().equals(selectedFarmer)) {
				return farmer;
			}
		}
		return null;
	}

	private String[] getProductNames(MainModel model) {
		String[] names = new String[getSelectedFarmer().getProductList().size()];
		int count = 0;
		for (Product product : getSelectedFarmer().getProductList()) {
			names[count] = product.getGenericProduct();
			count++;
		}
		return names;
	}

	private Product getSelectedProduct() {
		for (Product product : getSelectedFarmer().getProductList()) {
			if (product.getGenericProduct().equals(selectedProduct)) {
				return product;
			}
		}
		return null;
	}
}
