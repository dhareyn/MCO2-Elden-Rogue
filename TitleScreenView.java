import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TitleScreenView {
	private JFrame frame;
	private JLabel titleLabel;
	private JButton startButton;
	private JButton exitButton;

	public TitleScreenView() {
		frame = new JFrame("Elden Rogue");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Set layout to BoxLayout with Y_AXIS orientation

		// Set up title label
		titleLabel = new JLabel("ELDEN ROGUE");
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		titleLabel.setForeground(Color.YELLOW);
		titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT); // Center title horizontally
		panel.add(titleLabel);

		// Add vertical space between title and buttons
		panel.add(Box.createRigidArea(new Dimension(0, 50)));

		// Set up start button
		startButton = new JButton("Start");
		startButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		startButton.setAlignmentX(JButton.CENTER_ALIGNMENT); // Center button horizontally
		startButton.setMaximumSize(new Dimension(200, 30));
		panel.add(startButton);

		// Add vertical space between buttons
		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		// Set up exit button
		exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		exitButton.setAlignmentX(JButton.CENTER_ALIGNMENT); // Center button horizontally
		exitButton.setMaximumSize(new Dimension(200, 30));
		panel.add(exitButton);

		panel.setBackground(Color.BLACK);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
	}

	public void display() {
		frame.setVisible(true);
	}

	public void addStartButtonListener(ActionListener listener) {
		startButton.addActionListener(listener);
	}

	public void addExitButtonListener(ActionListener listener) {
		exitButton.addActionListener(listener);
	}

	// Method to retrieve the main frame
	public JFrame getMainFrame() {
		return frame;
	}

	// Method to display the character creation view
	public void displayCharacterCreation() {
		// Implement logic to display the character creation view
	}

	// Method to close the window
	public void close() {
		frame.dispose();
	}
}
