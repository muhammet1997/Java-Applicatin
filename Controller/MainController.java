package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.MainModel;
import View.*;

public class MainController implements ActionListener {
	private MainModel model;

	public MainController(MainModel model) {
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		 JButton button=(JButton)e.getSource();

			if (button.getText().equals("Create Order")) {
				new OrderScreen(model);
			}
			else if (button.getText().equals("New Farmer")) {
				new FarmerScreen(model);
			}
			else if (button.getText().equals("New Customer")) {
				new CustomerScreen(model);
			}
			else if (button.getText().equals("Information")) {
				new InfoScreen(model);
			}

	}

}