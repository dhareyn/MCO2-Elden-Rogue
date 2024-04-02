import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryController {
    private InventoryModel model;
    private InventoryView view;

    public InventoryController(InventoryModel model, InventoryView view) {
        this.model = model;
        this.view = view;

        // Add action listeners
        view.addSelectListener(new SelectListener());
        view.addBackListener(new BackListener());

        // Update view with initial inventory
        updateView();
    }

    private void updateView() {
        view.setInventory(model.getInventory());
    }

    class SelectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedWeapon = view.getSelectedWeapon();
            if (selectedWeapon != null) {
                // Parse the selected index from the string
                int index = Integer.parseInt(selectedWeapon.substring(1, selectedWeapon.indexOf(']')));

                // Get the selected weapon from the inventory
                Weapon weapon = model.getInventory().get(index);
                if (weapon != null) {
                    // Display the weapon's image and stats
                    ImageIcon icon = new ImageIcon(weapon.getImagePath());
                    JLabel imageLabel = new JLabel(icon);
                    JTextArea statsArea = new JTextArea(weapon.getDescription());
                    statsArea.setEditable(false);

                    JPanel panel = new JPanel(new BorderLayout());
                    panel.add(imageLabel, BorderLayout.WEST);
                    panel.add(new JScrollPane(statsArea), BorderLayout.CENTER);

                    // Ask if the player wants to equip the weapon
                    int choice = JOptionPane.showConfirmDialog(view.getFrame(), panel,
                            "Equip " + weapon.getName() + "?", JOptionPane.YES_NO_OPTION);

                    if (choice == JOptionPane.YES_OPTION) {
                        // Equip the weapon
                        boolean success = model.equipWeapon(index);
                        if (success) {
                            // Display message if the weapon is equipped successfully
                            updateView();
                            JOptionPane.showMessageDialog(view.getFrame(), "Weapon equipped successfully.");
                        } else {
                            // Display message if not enough dexterity to equip the weapon
                            JOptionPane.showMessageDialog(view.getFrame(), "Not enough dexterity to equip this weapon.");
                        }
                    }
                }
            }
        }
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getFrame().dispose();
            openGameLobby();
        }
    }

    private void openGameLobby() {
        GameLobbyModel lobbyModel = new GameLobbyModel(model.getPlayer());
        GameLobbyView lobbyView = new GameLobbyView(lobbyModel);
        GameLobbyController lobbyController = new GameLobbyController(lobbyView, lobbyModel);
    }
}
