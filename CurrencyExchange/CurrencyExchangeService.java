import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class CurrencyExchangeService extends JFrame implements ActionListener {
	
	private static final long serialVersionUD = 1L;
	private JLabel passportLabel, dollarLabel, toLabel;
	private JTextField passportNumber, dollarAmount;
	private JPanel nPanel, cPanel, sPanel;
	private JComboBox currency;
	private JButton exchange, clear, print;
	
	public CurrencyExchangeService() {
		
		super("Currency Exchange Service");
		
		passportLabel = new JLabel("Passport Number: ");
		passportNumber = new JTextField(10);
		nPanel = new JPanel();
		nPanel.add(passportLabel);
		nPanel.add(passportNumber);
		add(nPanel, BorderLayout.NORTH);
			
		dollarLabel = new JLabel("US Dollar Amount: $");
		dollarAmount = new JTextField(5);
		toLabel = new JLabel("To:");
		String option [] = {"", "British Pound", "Canadian Dollar"};
		currency = new JComboBox(option);
		cPanel = new JPanel();
		cPanel.add(dollarLabel);
		cPanel.add(dollarAmount);
		cPanel.add(toLabel);
		cPanel.add(currency);
		add(cPanel, BorderLayout.CENTER);
		
		exchange = new JButton("Exchange");
		exchange.addActionListener(this);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		print = new JButton("Print Transaction");
		print.addActionListener(this);
		sPanel = new JPanel();
		sPanel.add(exchange);
		sPanel.add(clear);
		sPanel.add(print);
		add(sPanel, BorderLayout.SOUTH);
		
		setSize(400, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()== exchange) { //if exchange button is clicked
			// System,out.println("it works!!");
			String passportNo = passportNumber.getText();
			String typeOfConversion = currency.getSelectedItem().toString();
			String usDollarStr = dollarAmount.getText().trim();
			double result = 0;
			try {
				double usDollar = Double.parseDouble(usDollarStr); //Integer.parseInt
				
				
				if (typeOfConversion.equalsIgnoreCase("British Pound"))
					result = usDollar * 0.71;
				else if(typeOfConversion.equalsIgnoreCase("Canadian Dollar"))
					result = usDollar * 1.35;
				
				String output = "Currency Exchange Information\nPasspost Number: " + passportNo +
								"\nFrom US Dollars to " + typeOfConversion + 
								"\nUS Dollar Amount: " + usDollarStr +
								"\n" + typeOfConversion + ":" + String.format("%.2f", result);
				JOptionPane.showMessageDialog(null, output);
				
			} // close try block
			catch (Exception e) {
				System.out.println("Wrong Input!");
				//System.out.println(e.toString());
				//System.out.println(e.getMessage());
				// e.printStackTrace();
				//System.exit(0); // to handle by shutting down everything
			}
			
			File receipt = new File("/Users/snehajoshi/eclipse-workspace/CurrencyExchangeService/receipt.txt");
			try {
				FileWriter writer = new FileWriter(receipt, true);
				writer.write("\nReceipt");
				writer.write("\nPassport Number: " + passportNo);
				writer.write("\nFrom US Dollars to " + typeOfConversion);
				writer.write("\nUS Dollar Amount" + usDollarStr);
				writer.write("\n"+ typeOfConversion + ":" + String.format("%.2f", result ));
				
				writer.close();
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}// end if statement for the submit button
		else if(event.getSource()== print) {
			File receipt = new File("/Users/snehajoshi/eclipse-workspace/CurrencyExchangeService/receipt.txt");
			try {
				Scanner reader = new Scanner(receipt);
				while(reader.hasNextLine()) {
				String line = reader.nextLine();
				System.out.print(line);
				}
			}
			catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			}
		}// end else-if statement for the print button
	}
public static void main(String[] args) {
	CurrencyExchangeService ces = new CurrencyExchangeService();
	
}
}
