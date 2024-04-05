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
            view.getFrame().dispose();
            openFastTravelScreen();
           
           
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

    private void openFastTravelScreen() {
        FastTravelModel fastTravelModel = new FastTravelModel();
        FastTravelView fastTravelView = new FastTravelView();
        FastTravelController fastTravelController = new FastTravelController(fastTravelModel, fastTravelView);
        fastTravelView.setVisible(true); // Show the fast travel view
    }

    // Method to open the level-up screen
    private void openLevelUpScreen(Player player) {
        LevelUpModel levelUpModel = new LevelUpModel(player);
        LevelUpView levelUpView = new LevelUpView(levelUpModel);
        LevelUpController levelUpController = new LevelUpController(levelUpModel, levelUpView);
    }

    private void openInventoryScreen(Player player) {
        InventoryModel inventoryModel = new InventoryModel(player);
        InventoryView inventoryView = new InventoryView(inventoryModel);
        InventoryController inventoryController = new InventoryController(inventoryModel, inventoryView);
    }

    private void openShopScreen(Player player) {
        ShopModel shopModel = new ShopModel(player);
        ShopView shopView = new ShopView(shopModel);
        ShopController shopController = new ShopController(shopModel, shopView);
    }


    
    public void updatePlayerRunes(int runes) {
        model.getPlayer().setRunes(runes);
        view.updatePlayerRunes(runes);
    }

    public void registerActionListener() {
        for (JButton button : view.getButtons()) {
            button.addActionListener(this);
        }
    }
}
