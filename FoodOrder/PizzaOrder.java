import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaOrder extends JFrame implements ActionListener {

    private JTextArea requestField;
    private JLabel sizeLabel, requestLabel;
    private JPanel centerPanel, southPanel, northPanel, sizePanel;
    private JRadioButton smallOption, mediumOption, largeOption;
    private ButtonGroup sizeGroup;
    private JButton orderButton, clearButton, stockingButton;
    private JComboBox<String> toppingBox;

    public PizzaOrder() {
        super("Pizza Order");

        setLayout(new BorderLayout());

        // North panel: Topping selection
        northPanel = new JPanel();
        String[] toppingList = {"-- Select Topping --", "Pepperoni", "Sausage", "Veggie"};
        toppingBox = new JComboBox<>(toppingList);
        northPanel.add(toppingBox);
        add(northPanel, BorderLayout.NORTH);

        // Center panel: Size selection and Special Request
        centerPanel = new JPanel(new GridLayout(2, 1));

        sizePanel = new JPanel();
        sizeLabel = new JLabel("Size: ");
        smallOption = new JRadioButton("Small");
        mediumOption = new JRadioButton("Medium");
        largeOption = new JRadioButton("Large");
        sizeGroup = new ButtonGroup();
        sizeGroup.add(smallOption);
        sizeGroup.add(mediumOption);
        sizeGroup.add(largeOption);

        sizePanel.add(sizeLabel);
        sizePanel.add(smallOption);
        sizePanel.add(mediumOption);
        sizePanel.add(largeOption);

        requestLabel = new JLabel("Special Request: ");
        requestField = new JTextArea(3, 15);

        JPanel requestPanel = new JPanel();
        requestPanel.add(requestLabel);
        requestPanel.add(requestField);

        centerPanel.add(sizePanel);
        centerPanel.add(requestPanel);

        add(centerPanel, BorderLayout.CENTER);

        // South panel: Buttons
        southPanel = new JPanel();
        orderButton = new JButton("Order");
        clearButton = new JButton("Clear");
        stockingButton = new JButton("Stocking Pizza Dough");

        orderButton.addActionListener(this);
        clearButton.addActionListener(this);
        stockingButton.addActionListener(this);

        southPanel.add(orderButton);
        southPanel.add(clearButton);
        southPanel.add(stockingButton);

        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
        setSize(400, 200); // Adjusted to fit the layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == orderButton) {
            String request = requestField.getText();
            String topping = toppingBox.getSelectedItem().toString();
            String size = getSelectedSize();

            String output = "You ordered:\nTopping: " + topping +
                            "\nSize: " + size +
                            "\nSpecial Request: " + request;
            JOptionPane.showMessageDialog(this, output);

        } else if (event.getSource() == clearButton) {
            requestField.setText("");
            sizeGroup.clearSelection();
            toppingBox.setSelectedIndex(0);

        } else if (event.getSource() == stockingButton) {
            JOptionPane.showMessageDialog(this, "Stocking Pizza Dough!");
            
        }
    }

    private String getSelectedSize() {
        if (smallOption.isSelected()) return "Small";
        if (mediumOption.isSelected()) return "Medium";
        if (largeOption.isSelected()) return "Large";

        return "No size selected";
    }

    public static void main(String[] args) {
        PizzaOrder app = new PizzaOrder();
    }
}