import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Image;


public class CharacterCreationController {
    private CharacterCreationModel model;
    private CharacterCreationView view;

    public CharacterCreationController(CharacterCreationModel model, CharacterCreationView view) {
        this.model = model;
        this.view = view;

        // Add listener to the create button
        view.addCreateButtonListener(new CreateButtonListener());
    }

    class CreateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get player name and selected class from the view
            String name = view.getPlayerName();
            String selectedClass = view.getSelectedClass();

            // Validate player name
            if (name != null && !name.trim().isEmpty()) {
                // Truncate player name to 25 characters if it exceeds the limit
                if (name.length() > 25) {
                    name = name.substring(0, 25);
                }

                // Get the JobClass object based on the selected class
                JobClass jobClass = model.getJobClass(selectedClass);

                // Create Player object
                Player player = new Player(name, jobClass);

                // Display confirmation dialog with image, stats, and message
                ImageIcon imageIcon = new ImageIcon(jobClass.getImagePath());
                Image image = imageIcon.getImage();
                Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                JLabel imageLabel = new JLabel(scaledIcon);

                // Constructing the stats string
                String stats = "\tSTATS\n" +
                        "Level: \t" + jobClass.getLevel() + "\n" +
                        "HP: \t" + jobClass.getHP() + "\n" +
                        "DEX: \t" + jobClass.getDexterity() + "\n" +
                        "INT: \t" + jobClass.getIntelligence() + "\n" +
                        "END: \t" + jobClass.getEndurance() + "\n" +
                        "STR: \t" + jobClass.getStrength() + "\n" +
                        "FTH: \t" + jobClass.getFaith() + "\n";

                String message = "Do you want to create character with NAME: " + name + " and CLASS: " + selectedClass + "?";
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(imageLabel, BorderLayout.WEST);
                panel.add(new JTextArea(stats), BorderLayout.CENTER);
                panel.add(new JTextArea(message), BorderLayout.SOUTH);

                int choice = JOptionPane.showConfirmDialog(view.getMainFrame(), panel, "Confirmation", JOptionPane.YES_NO_OPTION);

                // If user confirms, proceed with character creation
                if (choice == JOptionPane.YES_OPTION) {
                    // Close the character creation view
                    view.close();

                    // Proceed to game lobby
                    GameLobbyModel gameLobbyModel = new GameLobbyModel(player); // Pass player to the model
                    GameLobbyView gameLobbyView = new GameLobbyView(gameLobbyModel); // Create view with model
                    GameLobbyController gameLobbyController = new GameLobbyController(gameLobbyView, gameLobbyModel); // Create controller with view and model
                    gameLobbyView.setController(gameLobbyController);
                    gameLobbyView.showLobby();
                }
            } else {
                // Display error message for empty player name
                JOptionPane.showMessageDialog(view.getMainFrame(),
                        "Player name cannot be empty.",
                        "Invalid Player Name",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
