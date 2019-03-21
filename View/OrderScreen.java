package View;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.OrderController;
import Model.MainModel;

public class OrderScreen {
	private MainModel model;
	public OrderScreen(MainModel model) {
		this.model=model;
		genereteScreen();
	}
	
	private void genereteScreen() {
		JFrame frame=new JFrame("Create Order");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLayout(new GridLayout(4,1));
		
		JPanel panel11=new JPanel();
		frame.add(panel11);
		panel11.setLayout(new GridLayout(1,4));
		
		JPanel panelOf11v1=new JPanel();
		panel11.add(panelOf11v1);
		panelOf11v1.setLayout(new GridLayout(3,1));
		panelOf11v1.add(new JLabel("Choose yourself"));
		JComboBox<String> customers = new JComboBox<>(getCustomerNames(model));
		panelOf11v1.add(customers);
		JButton chooseCustomer=new JButton("Done");
		panelOf11v1.add(chooseCustomer);

		JPanel panelOf11v2=new JPanel();
		panel11.add(panelOf11v2);
		panelOf11v2.setLayout(new GridLayout(3,1));
		panelOf11v2.add(new JLabel("Choose your Farmer"));
		JComboBox<String> farmers=new JComboBox<>(new String[0]);
		panelOf11v2.add(farmers);
		JButton chooseFarmer=new JButton(" Done");
		panelOf11v2.add(chooseFarmer);
		panelOf11v2.setVisible(false);
		
		JPanel panelOf11v3=new JPanel();
		panel11.add(panelOf11v3);
		panelOf11v3.setLayout(new GridLayout(3,1));
		panelOf11v3.add(new JPanel());
		JLabel balanceOfCustomer=new JLabel();
		panelOf11v3.add(balanceOfCustomer);
		panelOf11v3.add(new JPanel());
		panelOf11v3.setVisible(false);
		
		JPanel panelOf11v4=new JPanel();
		panel11.add(panelOf11v4);
		panelOf11v4.setLayout(new GridLayout(3,1));
		panelOf11v4.add(new JPanel());
		JLabel balanceOfFarmer=new JLabel();
		panelOf11v4.add(balanceOfFarmer);
		panelOf11v4.add(new JPanel());
		panelOf11v4.setVisible(false);
		
		JPanel panel12=new JPanel();
		frame.add(panel12);
		panel12.setLayout(new GridLayout(1,3));
		
		JPanel panelOf12v1=new JPanel();
		panel12.add(panelOf12v1);
		panelOf12v1.setLayout(new GridLayout(3,1));
		panelOf12v1.add(new JLabel("Choose to Buy"));
		JComboBox<String> products=new JComboBox<>(new String[0]);
		panelOf12v1.add(products);
		JButton chooseProduct=new JButton(" Done ");
		panelOf12v1.add(chooseProduct);
		panelOf12v1.setVisible(false);

		JPanel panelOf12v2=new JPanel();
		panel12.add(panelOf12v2);
		panelOf12v2.setLayout(new GridLayout(3,1));
		JTextField amount=new JTextField("Enter amount");
		panelOf12v2.add(new JLabel("Amount"));
		panelOf12v2.add(amount);
		JLabel description=new JLabel();
		panelOf12v2.add(description);
		panelOf12v2.setVisible(false);
		
		JPanel panelOf12v3=new JPanel();
		panel12.add(panelOf12v3);
		panelOf12v3.setLayout(new GridLayout(3,1));
		JButton addToBasket=new JButton("Add to Basket");
		panelOf12v3.add(new JPanel());
		panelOf12v3.add(addToBasket);
		panelOf12v3.add(new JPanel());
		panelOf12v3.setVisible(false);
		
		JPanel panel13=new JPanel();
		frame.add(panel13);
		panel13.setLayout(new GridLayout(3,1));
		panel13.add(new JLabel("Your Basket"));
		JTextArea basket=new JTextArea("List of what customer buys");
		panel13.add(basket);
		panel13.add(new JPanel());
		panel13.setVisible(false);
		
		JPanel panel14=new JPanel();
		frame.add(panel14);
		panel14.setLayout(new GridLayout(1,3));
		JButton order=new JButton("ORDER");
		panel14.add(new JPanel());
		panel14.add(order);
		panel14.add(new JPanel());
		panel14.setVisible(false);
		
		OrderController customerChooserHandler=new OrderController(customers,farmers,balanceOfCustomer,panelOf11v2,panelOf11v3,model);
		chooseCustomer.addActionListener(customerChooserHandler);
		OrderController farmerChooserHandler=new OrderController(farmers,products,balanceOfFarmer,panelOf11v4,panelOf12v1,model);
		chooseFarmer.addActionListener(farmerChooserHandler);
		OrderController productChooserHandler=new OrderController(farmers,products,description,panelOf12v2,panelOf12v3,model);
		chooseProduct.addActionListener(productChooserHandler);
		OrderController basketHandler=new OrderController(farmers,products,amount,basket,panel13,panel14,model);
		addToBasket.addActionListener(basketHandler);
		OrderController orderHandler=new OrderController(customers,farmers,balanceOfCustomer,balanceOfFarmer,frame,model);
		order.addActionListener(orderHandler);
		
		frame.setVisible(true);
	}
	
	private String[] getCustomerNames(MainModel model) {
		String[] names=new String[model.getCustomers().size()];
		for(int i=0;i<model.getCustomers().size();i++) {
			names[i]=model.getCustomers().get(i).getName();	
		}
		return names;
	}
}