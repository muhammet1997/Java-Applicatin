package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import Model.MainModel;
//farmer ve customer isim listesi aþaðý kaymýyor, sadece isim mi yoksa diðer bilgiler de
//olacak mý çözmemiz lazým

public class InfoScreen {
	public InfoScreen(MainModel model) {
		generateInfoScreen(model);		
	}
	
	private void generateInfoScreen(MainModel model) {
		JFrame frame = new JFrame("Information");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JPanel mainPanel=new JPanel();
		JPanel upperPanel=new JPanel();
		JPanel lowerPanel=new JPanel();
		mainPanel.setLayout(new GridLayout(2,0));
		upperPanel.setLayout(new BorderLayout());
		lowerPanel.setLayout(new BorderLayout());
		
		JList<String> customerList = new JList<String>();
		customerList.setLayoutOrientation(JList.VERTICAL);
		customerList.setModel(getCustomerNamelist(model));
		
		JList<String> farmerList = new JList<String>();
		farmerList.setLayoutOrientation(JList.VERTICAL);
		farmerList.setModel(getFarmerNamelist(model));
		
		String balance="Balance of Farmbank is: "+model.getBalanceOfBank();
		JLabel balanceOfBank=new JLabel(balance);
		JLabel customers=new JLabel("Registered Customers Are:");
		JLabel farmers=new JLabel("Registered Farmers Are:");
		
		lowerPanel.add(customerList);
		lowerPanel.add(customers,BorderLayout.NORTH);
		upperPanel.add(farmerList);
		upperPanel.add(farmers,BorderLayout.NORTH);
		mainPanel.add(upperPanel);
		mainPanel.add(lowerPanel);
		frame.add(balanceOfBank,BorderLayout.SOUTH);
		frame.add(mainPanel);
		
		frame.setVisible(true);
	}
	
	private DefaultListModel<String> getCustomerNamelist(MainModel model) {
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(int i=0;i<model.getCustomers().size();i++) {
			String customerInfo="Customer name: "+model.getCustomers().get(i).getName()+", Balance: "+model.getCustomers().get(i).getBalance()
					+" TL, Location Name: "+model.getCustomers().get(i).getLocation().getName()+", Location Zip Code: "+model.getCustomers().get(i).getLocation().getZipCode();
			listModel.addElement(customerInfo);
		}
		return listModel;
	}
	
	private DefaultListModel<String> getFarmerNamelist(MainModel model) {
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(int i=0;i<model.getFarmers().size();i++) {
			String farmerInfo="Farmer name: "+model.getFarmers().get(i).getName()+", Balance: "+model.getFarmers().get(i).getBalance()+" TL";
			listModel.addElement(farmerInfo);
		}
		return listModel;
	}
}
