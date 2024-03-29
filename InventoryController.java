import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryController {
    private InventoryModel model;
    private InventoryView view;
    private Player player;

    public InventoryController(InventoryModel model, InventoryView view, Player player) {
        this.model = model;
        this.view = view;
        this.player = player;

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

                // Check if the selected item is already equipped
                if (model.getPlayer().getEquippedWeapon() != null && index == model.getInventory().indexOf(model.getPlayer().getEquippedWeapon())) {
                    // Display message if the item is already equipped
                    JOptionPane.showMessageDialog(view.getFrame(), "Item is already equipped.");
                    return;
                }

                // Equip the selected item
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

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getFrame().dispose();
            // Perform any necessary cleanup or return to the previous screen
            openGameLobby();
        }
    }

    private void openGameLobby() {
        // Create GameLobbyModel, GameLobbyView, and GameLobbyController instances
        GameLobbyModel lobbyModel = new GameLobbyModel(player);
        GameLobbyView lobbyView = new GameLobbyView(lobbyModel);
        GameLobbyController lobbyController = new GameLobbyController(lobbyView, lobbyModel);
    }
}
