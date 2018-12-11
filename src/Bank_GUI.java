import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Bank_GUI {
	private static JTextField textField_3;
	private static JTextField textField;
	public static void main(String[] args) {
		
		Payment addsum1 = new Payment(); //creating objects and calling constructor's
		Account addcard1 = new Account();
		Account getbalance1 = new Account();
		Account removecard1 = new Account();
		
		 
		
		JFrame myFrame = new JFrame("Bank"); //setting up frame
		myFrame.getContentPane().setLayout(null);
		
		JLabel lblAmount = new JLabel("amount to deposit"); //setting a label
		lblAmount.setBounds(150, 288, 107, 14);
		myFrame.getContentPane().add(lblAmount);
		
		textField_3 = new JTextField(); // setting a texbox for amounth
		textField_3.setBounds(150, 313, 86, 20);
		myFrame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		JButton btnSubmit = new JButton("deposit"); //adding button to deposit amounth textfield
		btnSubmit.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { //creating actionperform to submit deposit button
				String sum = textField_3.getText(); //making string from textbox object
				String cardNumber = textField.getText(); //making string from textbox object
				addsum1.addsum(sum, cardNumber); //calling method addsum and passing  variables to it
			}
		});
		btnSubmit.setBounds(150, 365, 107, 23);
		myFrame.getContentPane().add(btnSubmit);
		
		JButton btnCheckBalance = new JButton("Check balance");
		btnCheckBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //action event to check balance button
				String cardNumber = textField.getText(); //getting text input from textfield and making it to String
				getbalance1.getbalance(cardNumber); //callign method and passing variable to it
				
				
				}
		});
		btnCheckBalance.setBounds(10, 365, 127, 23);
		myFrame.getContentPane().add(btnCheckBalance);
		
		textField = new JTextField();
		textField.setBounds(253, 313, 86, 20);
		myFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCardNumber = new JLabel("Card number"); //settings to label
		lblCardNumber.setBounds(271, 288, 108, 14);
		myFrame.getContentPane().add(lblCardNumber);
		
		JButton btnSubmitNewCard = new JButton("submit card");
		btnSubmitNewCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //making actionperformed to submit new card button
				String cardNumber = textField.getText(); //getting input from textbox and making it to variable
				addcard1.addcard(cardNumber); //calling method and passing variable to it
				
			}
		});
		
		btnSubmitNewCard.setBounds(265, 365, 114, 23);
		myFrame.getContentPane().add(btnSubmitNewCard);
		
		JLabel lblReadCarefullyFolowing = new JLabel("READ PROJECT GITHUB WIKI FOR INSTRUCTIONS"); //adding text to label
		lblReadCarefullyFolowing.setBounds(10, 91, 369, 14);
		myFrame.getContentPane().add(lblReadCarefullyFolowing);
		
		JButton btnSubmitWithdrawal = new JButton("Delete card");
		btnSubmitWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //actionperformed to delete card button
				String cardNumber = textField.getText(); //getting input from textbox and making it to variable
				removecard1.removecard(cardNumber); //calling method and passing variable to it
				
				}
		});
		btnSubmitWithdrawal.setBounds(260, 399, 107, 23);
		myFrame.getContentPane().add(btnSubmitWithdrawal);
		
		Payment Bank_DB = new Payment();
		
		myFrame.setBounds(0,0,550,550); //frame settings
		myFrame.setLocationRelativeTo(null);  
		myFrame.setVisible(true);
	
	
}
}

