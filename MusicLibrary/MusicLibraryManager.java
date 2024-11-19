import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MusicLibraryManager extends JFrame implements ActionListener {
	private JTextField artistField, titleField, yearField;
	private JComboBox<String> genreComboBox;
	private JRadioButton cdRadio, vinylRadio, digitalRadio;
	private ButtonGroup formatGroup;
	private JCheckBox favoriteCheckBox, playlistCheckBox, remixCheckBox, coverCheckBox;
	private JButton submitButton, resetButton;
	private JTextArea lyricsArea, notesArea;
	
	
	public MusicLibraryManager() {
		super("Music Library Manager");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	
		
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);
		mainPanel.add(createInputPanel(), BorderLayout.CENTER);
		mainPanel.add(createFooterPanel(), BorderLayout.SOUTH);
		
		add(mainPanel);
		setVisible(true);
		
	}
	
	private JPanel createHeaderPanel() {
		JPanel headerPanel = new JPanel();
		JLabel headerLabel = new JLabel("Music Library Manager");
		headerLabel.setFont(headerLabel.getFont().deriveFont(20f));
		headerPanel.add(headerLabel);
		return headerPanel;
		
	}
	
	private JPanel createInputPanel() {
		JPanel inputPanel = new JPanel(new GridLayout(9, 1, 10, 10));
		inputPanel.add(createTextFieldPanel("Title:", titleField = new JTextField(20)));
		inputPanel.add(createTextFieldPanel("Artist:", artistField = new JTextField(20)));
		inputPanel.add(createTextFieldPanel("Year:", yearField = new JTextField(20)));
		inputPanel.add(createComboBoxPanel());
		inputPanel.add(createFormatPanel());
		inputPanel.add(createCheckBoxPanel());
		inputPanel.add(createTextAreaPanel("Lyrics: ", lyricsArea = new JTextArea(4,25)));
		inputPanel.add(createTextAreaPanel("Notes: ", notesArea = new JTextArea(4,25)));
		
		// Add album cover image
		ImageIcon imageIcon = new ImageIcon("/Users/snehajoshi/Desktop/Fall 2024/IT 230 Java/Music Library Icon.png");
		JLabel imageLabel = new JLabel(imageIcon);
		inputPanel.add(imageLabel);
		
		return inputPanel;
	}
	
	private JPanel createTextFieldPanel(String labelText, JTextField textField) {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel(labelText);
		textField.setToolTipText("Enter " + labelText.toLowerCase());
		panel.add(label, BorderLayout.WEST);
		panel.add(textField, BorderLayout.CENTER);
		return panel;
	}
	
	// Create genre selection combo box
	private JPanel createComboBoxPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Genre: ");
		genreComboBox = new JComboBox<>(new String[] {"Rock", "Pop", "Jazz", "Classical", "Hip Hop", "Electronic"});
		panel.add(label, BorderLayout.WEST);
		panel.add(genreComboBox, BorderLayout.CENTER);
		return panel;
	}
	
	// Create the music format selection radio buttons
	private JPanel createFormatPanel() {
		JPanel formatPanel = new JPanel(new GridLayout(3,1));
		JLabel formatLabel = new JLabel("Format");
		formatPanel.add(formatLabel);
		
		cdRadio = new JRadioButton("CD");
		vinylRadio = new JRadioButton("Vinyl");
		digitalRadio = new JRadioButton("Digital");
		
		formatGroup = new ButtonGroup();
		formatGroup.add(cdRadio);
		formatGroup.add(vinylRadio);
		formatGroup.add(digitalRadio);
		
		formatPanel.add(cdRadio);
		formatPanel.add(vinylRadio);
		formatPanel.add(digitalRadio);
		
		return formatPanel;
	}
	
	// Create checkbox panel for additional options
	private JPanel createCheckBoxPanel() {
		JPanel checkBoxPanel = new JPanel(new GridLayout(2,2,5,5));
		favoriteCheckBox = new JCheckBox("Favorite");
		playlistCheckBox = new JCheckBox("Add to Playlist");
		remixCheckBox = new JCheckBox("Remix");
		coverCheckBox = new JCheckBox("Cover Song");
		
		checkBoxPanel.add(favoriteCheckBox);
		checkBoxPanel.add(playlistCheckBox);
		checkBoxPanel.add(remixCheckBox);
		checkBoxPanel.add(coverCheckBox);
		
		return checkBoxPanel;
	}
	private JPanel createTextAreaPanel(String labelText, JTextArea textArea) {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel(labelText);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panel.add(label, BorderLayout.NORTH);
		panel.add(textArea, BorderLayout.CENTER);
		return panel;
	}
	
	private JPanel createFooterPanel() {
		JPanel footerPanel = new JPanel(new GridLayout(1,2));
		submitButton = new JButton("Add to Library");
		resetButton = new JButton("Reset");
		submitButton.addActionListener(this);
		resetButton.addActionListener(this);
		footerPanel.add(submitButton);
		footerPanel.add(resetButton);
		return footerPanel;
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == submitButton) {
			handleSubmit();	
		} else if (event.getSource()== resetButton) {
			handleReset();
		}
		
	}
	private void handleSubmit() {
		String title = titleField.getText();
		String artist =artistField.getText();
		String year = yearField.getText();
		String genre = genreComboBox.getSelectedItem().toString();
		
		// Get selected format
		String format = "";
		if (cdRadio.isSelected()) format = "CD";
		else if (vinylRadio.isSelected()) format = "Vinyl";
		else if (digitalRadio.isSelected()) format = "Digital";
		
		String favorite = favoriteCheckBox.isSelected() ? "Yes" : "NO";
		String addToPlaylist = playlistCheckBox.isSelected() ? "Yes" : "NO";
		String remix = remixCheckBox.isSelected() ? "Yes" : "NO";
		String cover = coverCheckBox.isSelected() ? "Yes" : "NO";
		
		String lyrics = lyricsArea.getText();
		String notes = notesArea.getText();
		
		// Create output string
		String output = "Title: " + title + 
				"\nArtist: " + artist +
				"\nYear: " + year +
				"\nGenre: " + genre +
				"\nFormat: " + format + 
				"\nFavovite: " + favorite +
				"\nAdd to Playlist: " + addToPlaylist +
				"\nRemix: " + remix + 
				"\nCover Song: " + cover + 
				"\nLyrics: " + lyrics +
				"\nNotes: " + notes;
		
		// Show the output string in a pop-up box
		JOptionPane.showMessageDialog(this, output, "Added to Library", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void handleReset() {
		titleField.setText("");
		artistField.setText("");
        yearField.setText("");
        genreComboBox.setSelectedIndex(0);
        formatGroup.clearSelection();
        favoriteCheckBox.setSelected(false);
        playlistCheckBox.setSelected(false);
        remixCheckBox.setSelected(false);
        coverCheckBox.setSelected(false);
        lyricsArea.setText("");
        notesArea.setText("");
	}
	
	public static void main(String[] args) {
        new MusicLibraryManager();
    }

}

