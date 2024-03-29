import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopController {
    private final ShopModel model;
    private final ShopView view;
    private final Player player;

    public ShopController(ShopModel model, ShopView view, Player player) {
        this.model = model;
        this.view = view;
        this.player = player;

        // Add action listeners
        view.setWeapons(model.getWeapons());
        view.setRunes(player.getRunes());
        view.addPurchaseListener(new WeaponPurchaseListener());
        view.addBackButtonListener(new BackToLobbyListener());
        view.display(); // Display the shop view
    }

    // ActionListener for weapon purchase
    class WeaponPurchaseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = view.getWeaponList().getSelectedIndex();
            if (selectedIndex != -1) {
                Weapon selectedWeapon = model.getWeapons().get(selectedIndex);
                boolean purchaseSuccessful = model.purchaseWeapon(selectedWeapon);
                if (purchaseSuccessful) {
                    int newRunes = player.getRunes();
                    view.setRunes(newRunes);
                    JOptionPane.showMessageDialog(view.getFrame(), "You have purchased " + selectedWeapon.getName());
                    player.addToInventory(selectedWeapon);
                } else {
                    JOptionPane.showMessageDialog(view.getFrame(), "Insufficient runes to purchase " + selectedWeapon.getName());
                }
            }
        }
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

    private void openGameLobby() {
        // Create GameLobbyModel, GameLobbyView, and GameLobbyController instances
        GameLobbyModel lobbyModel = new GameLobbyModel(player);
        GameLobbyView lobbyView = new GameLobbyView(lobbyModel);
        GameLobbyController lobbyController = new GameLobbyController(lobbyView, lobbyModel);
    }
}