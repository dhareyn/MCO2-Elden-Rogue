import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ShopController {
    private final ShopModel model;
    private final ShopView view;

    public ShopController(ShopModel model, ShopView view) {
        this.model = model;
        this.view = view;

        // Add action listeners
        view.addBackButtonListener(new BackToLobbyListener());
        view.addWeaponSelectListener(new SelectWeaponListener());

        // Set initial state
        view.setRunes(model.getPlayer().getRunes());
        setWeaponsInTabs();

        view.display(); // Display the shop view
    }

    // Method to set weapons in tabs
    private void setWeaponsInTabs() {
        Map<String, List<Weapon>> categorizedWeapons = model.getCategorizedWeapons();
        for (Map.Entry<String, List<Weapon>> entry : categorizedWeapons.entrySet()) {
            view.addWeaponCategory(entry.getKey(), getWeaponNames(entry.getValue()));
        }
    }

    // Helper method to get names of weapons
    private List<String> getWeaponNames(List<Weapon> weapons) {
        List<String> weaponNames = new ArrayList<>();
        for (Weapon weapon : weapons) {
            weaponNames.add(weapon.getName());
        }
        return weaponNames;
    }

    // ActionListener for back to lobby button
    class BackToLobbyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Close the shop view
            view.close();
            // Open the game lobby view
            openGameLobby();
        }
    }

    // ActionListener for the "Select" button
    class SelectWeaponListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedCategory = view.getSelectedCategory();
            JList<String> weaponList = view.getSelectedWeaponList(selectedCategory);
            int selectedIndex = weaponList.getSelectedIndex();
            if (selectedIndex != -1) {
                List<Weapon> weapons = model.getCategorizedWeapons().get(selectedCategory);
                Weapon selectedWeapon = weapons.get(selectedIndex);
                // Retrieve the image path of the selected weapon
                String imagePath = selectedWeapon.getImagePath();
                // Show weapon description and purchase option in a JOptionPane
                int option = JOptionPane.showConfirmDialog(
                        view.getFrame(),
                        selectedWeapon.getDescription() + "\nDo you want to purchase this weapon?",
                        "Weapon Details",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(imagePath)); // Display image in option pane
                if (option == JOptionPane.YES_OPTION) {
                    boolean purchaseSuccessful = model.purchaseWeapon(selectedWeapon);
                    if (purchaseSuccessful) {
                        int newRunes = model.getPlayer().getRunes();
                        view.setRunes(newRunes);
                        JOptionPane.showMessageDialog(view.getFrame(), "You have purchased " + selectedWeapon.getName());
                        model.getPlayer().addToInventory(selectedWeapon);
                    } else {
                        JOptionPane.showMessageDialog(view.getFrame(), "Insufficient runes to purchase " + selectedWeapon.getName());
                    }
                }
            }
        }
    }

    private void openGameLobby() {
        // Create GameLobbyModel, GameLobbyView, and GameLobbyController instances
        GameLobbyModel lobbyModel = new GameLobbyModel(model.getPlayer());
        GameLobbyView lobbyView = new GameLobbyView(lobbyModel);
        GameLobbyController lobbyController = new GameLobbyController(lobbyView, lobbyModel);
    }
}
