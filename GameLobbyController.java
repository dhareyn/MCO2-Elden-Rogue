import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameLobbyController implements ActionListener {
    private final GameLobbyView view;
    private final GameLobbyModel model;

    public GameLobbyController(GameLobbyView view, GameLobbyModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();

        switch (buttonText) {
            case "Fast Travel":
                // Handle fast travel option
                break;
            case "Level Up":
                view.getFrame().dispose();
                openLevelUpScreen(model.getPlayer());
                break;
            case "Inventory":
                view.getFrame().dispose();
                openInventoryScreen(model.getPlayer());
                break;
            case "Shop":
                view.getFrame().dispose();
                openShopScreen(model.getPlayer());
                break;
            case "Exit Game":
                System.exit(0);
                break;
            default:
                break;
        }
    }


    // Method to open the level-up screen
    private void openLevelUpScreen(Player player) {
        System.out.println("CLICKED!");
        LevelUpModel levelUpModel = new LevelUpModel(player);
        LevelUpView levelUpView = new LevelUpView(levelUpModel);
        LevelUpController levelUpController = new LevelUpController(levelUpModel, levelUpView, player);
    }

    private void openInventoryScreen(Player player) {
        System.out.println("CLICKED!");
        InventoryModel inventoryModel = new InventoryModel(player);
        InventoryView inventoryView = new InventoryView(inventoryModel);
        InventoryController inventoryController = new InventoryController(inventoryModel, inventoryView, player);
    }

    private void openShopScreen(Player player) {
        System.out.println("CLICKED!");
        ShopModel shopModel = new ShopModel(player);
        ShopView shopView = new ShopView(player);
        ShopController shopController = new ShopController(shopModel, shopView, player);
    }



    // Method to update player runes
    public void updatePlayerRunes(int runes) {
        model.getPlayer().setRunes(runes);
        view.updatePlayerRunes(runes); // Assuming you have a method in GameLobbyView to update the runes label
    }

    // Method to re-register ActionListener with buttons
    public void registerActionListener() {
        for (JButton button : view.getButtons()) {
            button.addActionListener(this);
        }
    }
}
