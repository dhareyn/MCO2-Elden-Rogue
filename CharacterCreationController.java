import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                JobClass jobClass = null;
                if ("Vagabond".equals(selectedClass)) {
                    jobClass = new Vagabond(); // Example - replace with appropriate class instantiation
                } else if ("Samurai".equals(selectedClass)) {
                    jobClass = new Samurai(); // Example - replace with appropriate class instantiation
                } else if ("Warrior".equals(selectedClass)) {
                    jobClass = new Warrior();
                } else if ("Hero".equals(selectedClass)) {
                    jobClass = new Hero();
                } else if ("Astrologer".equals(selectedClass)) {
                    jobClass = new Astrologer();
                } else if ("Prophet".equals(selectedClass)) {
                    jobClass = new Prophet();
                }

                // Create Player object
                Player player = new Player(name, jobClass);

                // Display confirmation dialog
                int choice = JOptionPane.showConfirmDialog(view.getMainFrame(),
                        "Are you sure you want to create character with NAME: " + name + " and CLASS: " + selectedClass + "?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION);

                // If user confirms, proceed with character creation
                if (choice == JOptionPane.YES_OPTION) {
                    // Close the character creation view
                    view.close();

                    // Proceed to game lobby
                    GameLobbyModel gameLobbyModel = new GameLobbyModel(player); // Pass player to the model
                    GameLobbyView gameLobbyView = new GameLobbyView(gameLobbyModel); // Create view with model
                    GameLobbyController gameLobbyController = new GameLobbyController(gameLobbyView, gameLobbyModel); // Create controller with view and model
                    gameLobbyView.setController(gameLobbyController); // Set controller for the view
                    gameLobbyView.showLobby(); // Corrected method call
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