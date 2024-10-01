import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GasStation extends JFrame implements ActionListener {
    private JTextField gasField; // For user input
    private JCheckBox washCheckBox;
    private JButton payButton, receiptButton, clearButton;
    private ImageIcon gasIcon, washIcon;
    private JLabel gasLabel, washLabel, dollarSignLabel;
    private JPanel centerPanel, southPanel, gasPanel;

    public GasStation() {
        super("Gas Station Cashier");

        setLayout(new BorderLayout());

        // Center panel for images and options
        centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        // Gas icon and text field
        gasIcon = new ImageIcon("/Users/snehajoshi/Desktop/Fall 2024/IT 230 Java/Building GUIs gas.gif");
        gasLabel = new JLabel(gasIcon);
        
      
        gasField = new JTextField(10);
        
        // Create a panel for the dollar sign and text field
        gasPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dollarSignLabel = new JLabel("$");
        gasPanel.add(dollarSignLabel);
        gasPanel.add(gasField);

        // Wash icon and checkbox
        washIcon = new ImageIcon("/Users/snehajoshi/Desktop/Fall 2024/IT 230 Java/Carwash GUI.gif");
        washLabel = new JLabel(washIcon);
        washCheckBox = new JCheckBox("$10.00");

        centerPanel.add(gasLabel);
        centerPanel.add(gasPanel); // Add the panel with the dollar sign
        centerPanel.add(washCheckBox);
        centerPanel.add(washLabel);

        add(centerPanel, BorderLayout.CENTER);

        // South panel for buttons
        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        payButton = new JButton("Pay");
        receiptButton = new JButton("Print Receipt");
        clearButton = new JButton("Clear");

        payButton.addActionListener(this);
        receiptButton.addActionListener(this);
        clearButton.addActionListener(this);

        southPanel.add(payButton);
        southPanel.add(receiptButton);
        southPanel.add(clearButton);

        add(southPanel, BorderLayout.SOUTH);

        setSize(400, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payButton) {    
            JOptionPane.showMessageDialog(this, "Payment processed.");
        } else if (e.getSource() == receiptButton) {
            JOptionPane.showMessageDialog(this, "Receipt printed.");
        } else if (e.getSource() == clearButton) {
            gasField.setText("");
            washCheckBox.setSelected(false);
            JOptionPane.showMessageDialog(this, "Fields cleared.");
        }
    }

    public static void main(String[] args) {
    	GasStation app = new GasStation();
        
    }
}
