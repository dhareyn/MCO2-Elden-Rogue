/**
 * Controls the character creation process by interacting with the model and view.
 */
public class CharacterCreationController {
    private CharacterCreationModel model;
    private CharacterCreationView view;

    /**
     * Constructs a new CharacterCreationController with the specified model and view.
     *
     * @param model the character creation model
     * @param view  the character creation view
     */
    public CharacterCreationController(CharacterCreationModel model, CharacterCreationView view) {
        this.model = model;
        this.view = view;
        view.addCreateButtonListener(new CreateButtonListener());
    }

    /**
     * ActionListener implementation for the create button.
     */
    class CreateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getPlayerName();
            String selectedClass = view.getSelectedClass();

            if (name != null && !name.trim().isEmpty()) {
                if (name.length() > 25) {
                    name = name.substring(0, 25);
                }
                JobClass jobClass = model.getJobClass(selectedClass);
                Player player = new Player(name, jobClass);
                ImageIcon imageIcon = new ImageIcon(jobClass.getImagePath());
                Image image = imageIcon.getImage();
                Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                JLabel imageLabel = new JLabel(scaledIcon);
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
                if (choice == JOptionPane.YES_OPTION) {
                    view.close();
                    GameLobbyModel gameLobbyModel = new GameLobbyModel(player);
                    GameLobbyView gameLobbyView = new GameLobbyView(gameLobbyModel);
                    GameLobbyController gameLobbyController = new GameLobbyController(gameLobbyView, gameLobbyModel);
                    gameLobbyView.setController(gameLobbyController);
                    gameLobbyView.showLobby();
                }
            } else {
                JOptionPane.showMessageDialog(view.getMainFrame(),
                        "Player name cannot be empty.",
                        "Invalid Player Name",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
