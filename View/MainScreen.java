package View;

import javax.swing.*;

import Controller.MainController;
import Model.MainModel;

public class MainScreen {
	public MainScreen(MainModel model) {
		generateMainScreen(model);
	}

	private void generateMainScreen(MainModel model) {
		JFrame frame = new JFrame("FarmBank");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		JButton orderButton = new JButton("Create Order");
		JButton farmerButton = new JButton("New Farmer");
		JButton customerButton = new JButton("New Customer");
		JButton infoButton = new JButton("Information");

		
		MainController handler=new MainController(model);
		orderButton.addActionListener(handler);
		farmerButton.addActionListener(handler);
		customerButton.addActionListener(handler);
		infoButton.addActionListener(handler);

		buttonPanel.add(orderButton);
		buttonPanel.add(farmerButton);
		buttonPanel.add(customerButton);
		buttonPanel.add(infoButton);

		mainPanel.add(buttonPanel);
		frame.add(mainPanel);
		frame.setVisible(true);	
	}
}
