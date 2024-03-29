import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LevelUpView {
    private JFrame levelUpFrame;
    private LevelUpModel model;
    private JButton healthButton;
    private JButton enduranceButton;
    private JButton dexterityButton;
    private JButton strengthButton;
    private JButton intelligenceButton;
    private JButton faithButton;
    private JButton backButton;
    private JLabel levelLabel;
    private JLabel healthLabel;
    private JLabel enduranceLabel;
    private JLabel dexterityLabel;
    private JLabel strengthLabel;
    private JLabel intelligenceLabel;
    private JLabel faithLabel;

    public LevelUpView(LevelUpModel model) {
        this.model = model;
        levelUpFrame = new JFrame("Level Up");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10)); // 0 rows, 2 columns, gap of 10 between components
        panel.setBackground(Color.BLACK);

        // Set Times New Roman font for all text components
        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 16);

        // Create buttons
        healthButton = new JButton("Level Up Health");
        enduranceButton = new JButton("Level Up Endurance");
        dexterityButton = new JButton("Level Up Dexterity");
        strengthButton = new JButton("Level Up Strength");
        intelligenceButton = new JButton("Level Up Intelligence");
        faithButton = new JButton("Level Up Faith");
        backButton = new JButton("Back");

        // Create labels for stats
        healthLabel = new JLabel("Health: " + model.getPlayer().getJobClass().getHP());
        enduranceLabel = new JLabel("Endurance: " + model.getPlayer().getJobClass().getEndurance());
        dexterityLabel = new JLabel("Dexterity: " + model.getPlayer().getJobClass().getDexterity());
        strengthLabel = new JLabel("Strength: " + model.getPlayer().getJobClass().getStrength());
        intelligenceLabel = new JLabel("Intelligence: " + model.getPlayer().getJobClass().getIntelligence());
        faithLabel = new JLabel("Faith: " + model.getPlayer().getJobClass().getFaith());
        levelLabel = new JLabel("Level: " + model.getPlayer().getLevel());

        // Set font and foreground color for labels
        healthLabel.setFont(timesNewRoman);
        healthLabel.setForeground(Color.WHITE);
        enduranceLabel.setFont(timesNewRoman);
        enduranceLabel.setForeground(Color.WHITE);
        dexterityLabel.setFont(timesNewRoman);
        dexterityLabel.setForeground(Color.WHITE);
        strengthLabel.setFont(timesNewRoman);
        strengthLabel.setForeground(Color.WHITE);
        intelligenceLabel.setFont(timesNewRoman);
        intelligenceLabel.setForeground(Color.WHITE);
        faithLabel.setFont(timesNewRoman);
        faithLabel.setForeground(Color.WHITE);
        levelLabel.setFont(timesNewRoman);
        levelLabel.setForeground(Color.WHITE);

        // Set preferred size for buttons
        Dimension buttonSize = new Dimension(200, 30);
        healthButton.setPreferredSize(buttonSize);
        enduranceButton.setPreferredSize(buttonSize);
        dexterityButton.setPreferredSize(buttonSize);
        strengthButton.setPreferredSize(buttonSize);
        intelligenceButton.setPreferredSize(buttonSize);
        faithButton.setPreferredSize(buttonSize);
        backButton.setPreferredSize(buttonSize);

        // Add buttons and labels to the panel
        panel.add(healthButton);
        panel.add(healthLabel);
        panel.add(enduranceButton);
        panel.add(enduranceLabel);
        panel.add(dexterityButton);
        panel.add(dexterityLabel);
        panel.add(strengthButton);
        panel.add(strengthLabel);
        panel.add(intelligenceButton);
        panel.add(intelligenceLabel);
        panel.add(faithButton);
        panel.add(faithLabel);
        panel.add(levelLabel);
        panel.add(backButton);

        // Set font and foreground color for buttons
        healthButton.setFont(timesNewRoman);
        healthButton.setForeground(Color.BLACK);
        enduranceButton.setFont(timesNewRoman);
        enduranceButton.setForeground(Color.BLACK);
        dexterityButton.setFont(timesNewRoman);
        dexterityButton.setForeground(Color.BLACK);
        strengthButton.setFont(timesNewRoman);
        strengthButton.setForeground(Color.BLACK);
        intelligenceButton.setFont(timesNewRoman);
        intelligenceButton.setForeground(Color.BLACK);
        faithButton.setFont(timesNewRoman);
        faithButton.setForeground(Color.BLACK);
        backButton.setFont(timesNewRoman);
        backButton.setForeground(Color.BLACK);

        // Add panel to content pane of frame
        levelUpFrame.add(panel);
        levelUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Disposes only the level up window
        levelUpFrame.pack(); // Automatically sizes the frame to fit its contents
        levelUpFrame.setLocationRelativeTo(null);
        levelUpFrame.setVisible(true);
    }

    public void addHealthButtonListener(ActionListener listener) {
        healthButton.addActionListener(listener);
    }

    public void addEnduranceButtonListener(ActionListener listener) {
        enduranceButton.addActionListener(listener);
    }

    public void addDexterityButtonListener(ActionListener listener) {
        dexterityButton.addActionListener(listener);
    }

    public void addStrengthButtonListener(ActionListener listener) {
        strengthButton.addActionListener(listener);
    }

    public void addIntelligenceButtonListener(ActionListener listener) {
        intelligenceButton.addActionListener(listener);
    }

    public void addFaithButtonListener(ActionListener listener) {
        faithButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void updateLevelLabel(int level) {
        levelLabel.setText("Level: " + level);
    }
    public void updateHealthLabel(int health) {
        healthLabel.setText("Health: " + health);
    }

    public void updateEnduranceLabel(int endurance) {
        enduranceLabel.setText("Endurance: " + endurance);
    }

    public void updateDexterityLabel(int dexterity) {
        dexterityLabel.setText("Dexterity: " + dexterity);
    }

    public void updateStrengthLabel(int strength) {
        strengthLabel.setText("Strength: " + strength);
    }

    public void updateIntelligenceLabel(int intelligence) {
        intelligenceLabel.setText("Intelligence: " + intelligence);
    }

    public void updateFaithLabel(int faith) {
        faithLabel.setText("Faith: " + faith);
    }
    
    public void closeWindow() {
        levelUpFrame.dispose();
    }
}
