import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameLobbyView {
    private final JFrame lobbyFrame;
    private final JPanel panel;
    private final JPanel detailsPanel;
    private final JLabel titleLabel;
    private final JLabel nameLabel;
    private final JLabel classLabel;
    private final JLabel levelLabel;
    private final JLabel statsLabel;
    private final JLabel runesLabel;
    private final JLabel equippedWeaponLabel;
    private final JLabel equippedWeaponStatsLabel;
    private final ArrayList<JButton> buttons;

    private GameLobbyController controller;

    public GameLobbyView(GameLobbyModel model) {
        lobbyFrame = new JFrame("Game Lobby");
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK); // Set background color of the main panel

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        titleLabel = new JLabel("GAME LOBBY", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        titleLabel.setForeground(Color.YELLOW);
        panel.add(titleLabel, gbc);

        gbc.gridy++;
        detailsPanel = new JPanel(new GridLayout(0, 1));
        detailsPanel.setBackground(Color.BLACK);
        nameLabel = new JLabel("NAME: " + model.getPlayerName());
        classLabel = new JLabel("CLASS: " + model.getPlayerJobName());
        levelLabel = new JLabel("LEVEL: " + model.getPlayerLevel());
        statsLabel = new JLabel("STATS [HP: " + model.getPlayerHealth() + " DEX: " + model.getPlayerDexterity() +
                    " INT: " + model.getPlayerIntelligence() + " END: " + model.getPlayerEndurance() +
                    " STR: " + model.getPlayerStrength() + " FTH: " + model.getPlayerFaith() + "]");
        runesLabel = new JLabel("RUNES: " + model.getPlayerRunes());
        equippedWeaponLabel = new JLabel("EQUIPPED WEAPON: " + model.getEquippedWeaponName());
        equippedWeaponStatsLabel = new JLabel("WEAPON STATS: " + model.getEquippedWeaponStats());

        Font labelFont = new Font("Times New Roman", Font.PLAIN, 14);
        nameLabel.setFont(labelFont);
        classLabel.setFont(labelFont);
        levelLabel.setFont(labelFont);
        statsLabel.setFont(labelFont);
        runesLabel.setFont(labelFont);
        equippedWeaponLabel.setFont(labelFont);
        equippedWeaponStatsLabel.setFont(labelFont);

        nameLabel.setForeground(Color.WHITE);
        classLabel.setForeground(Color.WHITE);
        levelLabel.setForeground(Color.WHITE);
        statsLabel.setForeground(Color.WHITE);
        runesLabel.setForeground(Color.WHITE);
        equippedWeaponLabel.setForeground(Color.WHITE);
        equippedWeaponStatsLabel.setForeground(Color.WHITE);

        // Add components to the details panel
        detailsPanel.add(nameLabel);
        detailsPanel.add(classLabel);
        detailsPanel.add(levelLabel);
        detailsPanel.add(statsLabel);
        detailsPanel.add(runesLabel);
        detailsPanel.add(equippedWeaponLabel);
        detailsPanel.add(equippedWeaponStatsLabel);
        panel.add(detailsPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 0, 10));
        buttonPanel.setBackground(Color.BLACK); // Set background color of the button panel
        buttons = new ArrayList<>();
        buttons.add(createButton("Fast Travel"));
        buttons.add(createButton("Level Up"));
        buttons.add(createButton("Inventory"));
        buttons.add(createButton("Shop"));
        buttons.add(createButton("Exit Game"));

        for (JButton button : buttons) {
            button.setPreferredSize(new Dimension(200, 30)); // Set preferred size for each button
            buttonPanel.add(button);
        }
        panel.add(buttonPanel, gbc);

        lobbyFrame.add(panel);
        lobbyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lobbyFrame.setSize(800, 800);
        lobbyFrame.setLocationRelativeTo(null);

        // Set up the controller
        controller = new GameLobbyController(this, model);

        // Set the controller for the view
        setController(controller);

        // Register action listeners for buttons
        registerActionListeners();

        // Show the lobby
        showLobby();
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        return button;
    }

    // Method to set the controller
    public void setController(GameLobbyController controller) {
        this.controller = controller;
    }

    // Method to display the lobby
    public void showLobby() {
        lobbyFrame.setVisible(true);
    }

    // Add this method to retrieve the frame
    public JFrame getFrame() {
        return lobbyFrame;
    }

    // Add this method to update player runes
    public void updatePlayerRunes(int runes) {
        runesLabel.setText("RUNES: " + runes);
    }

    // Getter method for buttons
    public ArrayList<JButton> getButtons() {
        return buttons;
    }

    // Method to register action listeners for buttons
    public void registerActionListeners() {
        for (JButton button : buttons) {
            button.addActionListener(controller);
        }
    }
}
