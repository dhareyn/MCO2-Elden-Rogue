import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * The TitleScreenView class represents the title screen of the game.
 * It displays a background image, a title label, and start/exit buttons.
 */
public class TitleScreenView {
	private JFrame frame;
	private JButton startButton;
	private JButton exitButton;
	private JLabel titleLabel;

	private String imagePath = "jobpics/background.png";

	/**
	 * Constructs a new TitleScreenView object.
	 */
	public TitleScreenView() {
		frame = new JFrame("Elden Rogue");
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					Image backgroundImage = ImageIO.read(new File(imagePath));
					g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		panel.setLayout(null);

		// Set up title label
		titleLabel = new JLabel("ELDEN ROGUE");
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(200, 200, 400, 100);
		panel.add(titleLabel);

		// Set up start button
		startButton = new JButton("Start");
		startButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		startButton.setBounds(300, 400, 200, 30);
		panel.add(startButton);

		// Set up exit button
		exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		exitButton.setBounds(300, 450, 200, 30);
		panel.add(exitButton);

		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Displays the title screen.
	 */
	public void display() {
		frame.setVisible(true);
	}

	/**
	 * Adds an ActionListener to the start button.
	 *
	 * @param listener the ActionListener to add
	 */
	public void addStartButtonListener(ActionListener listener) {
		startButton.addActionListener(listener);
	}

	/**
	 * Adds an ActionListener to the exit button.
	 *
	 * @param listener the ActionListener to add
	 */
	public void addExitButtonListener(ActionListener listener) {
		exitButton.addActionListener(listener);
	}

	/**
	 * Retrieves the main frame of the title screen.
	 *
	 * @return the main frame
	 */
	public JFrame getMainFrame() {
		return frame;
	}

	/**
	 * Closes the title screen.
	 */
	public void close() {
		frame.dispose();
	}
}
