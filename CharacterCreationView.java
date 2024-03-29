import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CharacterCreationView {
    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel classLabel;
    private JComboBox<String> classComboBox;
    private JButton createButton;

    public CharacterCreationView() {
        frame = new JFrame("Character Creation");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("CHARACTER CREATION");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        nameLabel = new JLabel("Enter Name:");
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setMaximumSize(new Dimension(200, 30));
        nameField.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        panel.add(nameField);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        classLabel = new JLabel("Select Class:");
        classLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        classLabel.setForeground(Color.WHITE);
        classLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(classLabel);

        String[] classes = {"Vagabond", "Samurai", "Warrior", "Hero", "Astrologer", "Prophet"};
        classComboBox = new JComboBox<>(classes);
        classComboBox.setMaximumSize(new Dimension(200, 30));
        classComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        classComboBox.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        panel.add(classComboBox);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        createButton = new JButton("Create Character");
        createButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        createButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        createButton.setMaximumSize(new Dimension(200, 30));
        panel.add(createButton);

        panel.setBackground(Color.BLACK);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
    }

    public void display() {
        frame.setVisible(true);
    }

    public String getPlayerName() {
        return nameField.getText();
    }

    public String getSelectedClass() {
        return (String) classComboBox.getSelectedItem();
    }

    public void addCreateButtonListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void close() {
        frame.dispose();
    }

    public JFrame getMainFrame() {
        return frame;
    }
}
