import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class GUIExample extends JFrame implements ActionListener {
	
	private JTextField fullNameField;
	private JLabel fullNameLabel, genderLabel, commentLabel, hobbyLabel, femaleLabel, maleLabel;
	private JPanel northPanel, southPanel, centerPanel, eastPanel, westPanel, westPanel2;
	private JButton submitButton, cancelButton;
	private JRadioButton femaleOption, maleOption;
	private ButtonGroup genderGroup;
	private JTextArea commentArea;
	private JComboBox stateBox;
	private JCheckBox movieBox, musicBox;
	private ImageIcon femaleIcon;
	private ImageIcon maleIcon;
	
	public GUIExample() {
		//JFrame mainFrame = new JFrame("My First GUI");
		//setTitle("My First GUI");
		super("My First GUI");
		fullNameLabel = new JLabel("Enter Full Name:");
		fullNameLabel.setForeground(Color.white);
		fullNameField = new JTextField(5);
		northPanel = new JPanel();
		northPanel.setBackground(Color.blue);
		northPanel.add(fullNameLabel);
		northPanel.add(fullNameField);
		add(northPanel, BorderLayout.NORTH);
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		southPanel = new JPanel();
		southPanel.add(submitButton);
		southPanel.add(cancelButton);
		add(southPanel, BorderLayout.SOUTH);
		
		centerPanel = new JPanel();
		femaleOption = new JRadioButton("Female");
		femaleIcon = new ImageIcon("/Users/snehajoshi/Desktop/Fall 2024/IT 230 Java/Female (1).gif");
		femaleLabel = new JLabel(femaleIcon);
		maleOption = new JRadioButton("Male");
		maleIcon = new ImageIcon("/Users/snehajoshi/Desktop/Fall 2024/IT 230 Java/Male.gif");
		maleLabel = new JLabel(maleIcon);
		genderGroup = new ButtonGroup();
		genderGroup.add(femaleOption);
		genderGroup.add(maleOption);
		genderLabel = new JLabel("Select Gender:");
		centerPanel.add(genderLabel);
		centerPanel.add(femaleOption);
		centerPanel.add(femaleLabel);
		centerPanel.add(maleOption);
		centerPanel.add(maleLabel);
		add(centerPanel, BorderLayout.CENTER);
		
		eastPanel = new JPanel();
		eastPanel.setLayout(new BorderLayout());
		commentLabel = new JLabel("Comment:");
		commentArea = new JTextArea(10, 5);
		eastPanel.add(commentLabel, BorderLayout.NORTH);
		eastPanel.add(commentArea, BorderLayout.CENTER);
		add(eastPanel, BorderLayout.EAST);
		
		westPanel = new JPanel(new GridLayout(4, 1));
		String stateList [] = {"--Select State--", "DC", "MD", "VA"};
		JComboBox<?> jComboBox = new JComboBox(stateList);
		stateBox = jComboBox;
		movieBox = new JCheckBox("Movie");
		musicBox = new JCheckBox("Music");
		hobbyLabel = new JLabel("Hobby:");
		westPanel.add(stateBox);
		westPanel.add(hobbyLabel);
		westPanel.add(movieBox);
		westPanel.add(musicBox);
		westPanel2 = new JPanel();
		westPanel2.add(westPanel);
		add(westPanel2, BorderLayout.WEST);
		
		setVisible(true);
		setSize(620, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == submitButton) {
			String fullName = fullNameField.getText();
			String comment = commentArea.getText();
			String state = stateBox.getSelectedItem().toString();
			
			String movie = "No";
			String music = "No";
			if(movieBox.isSelected()) {
				movie = "Yes";
			}
			
			if(musicBox.isShowing()) {
				music = "Yes";
			}
			if (femaleOption.isSelected()) {
			}
			else if(maleOption.isSelected()) {
			}
			//System.out.println("movie box is checked:" + movie);
			String output = "You entered:\nFull Name: " + fullName + "\nComment: " + comment + "\nState: " + state +
					"\nHobby:\n     Movie: " + movie + "\n     Music: " + music;  
			//System.out.println(fullName);
			JOptionPane.showMessageDialog(null, output);
		}
		else if(event.getSource() == cancelButton) {
			fullNameField.setText("");
			commentArea.setText("");
			stateBox.setSelectedIndex(0);
			musicBox.setSelected(false);
			movieBox.setSelected(false);
			genderGroup.clearSelection();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUIExample app = new GUIExample();
		//app.lauchGUI();
	}

}
