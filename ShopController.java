import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Controls the interactions between the ShopModel and ShopView.
 */
public class ShopController {
    private final ShopModel model;
    private final ShopView view;

    /**
     * Constructs a ShopController with the specified model and view.
     * @param model The ShopModel instance.
     * @param view The ShopView instance.
     */
    public ShopController(ShopModel model, ShopView view) {
        this.model = model;
        this.view = view;

        view.addBackButtonListener(new BackToLobbyListener());
        view.addWeaponSelectListener(new SelectWeaponListener());

        view.setRunes(model.getPlayer().getRunes());
        setWeaponsInTabs();

        view.display();
    }

    private void setWeaponsInTabs() {
        Map<String, List<Weapon>> categorizedWeapons = model.getCategorizedWeapons();
        for (Map.Entry<String, List<Weapon>> entry : categorizedWeapons.entrySet()) {
            view.addWeaponCategory(entry.getKey(), getWeaponNames(entry.getValue()));
        }
    }

    private List<String> getWeaponNames(List<Weapon> weapons) {
        List<String> weaponNames = new ArrayList<>();
        for (Weapon weapon : weapons) {
            weaponNames.add(weapon.getName());
        }
        return weaponNames;
    }

    /**
     * ActionListener for back to lobby button.
     */
    class BackToLobbyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.close();
            openGameLobby();
        }
    }

    /**
     * ActionListener for the "Select" button.
     */
    class SelectWeaponListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedCategory = view.getSelectedCategory();
            JList<String> weaponList = view.getSelectedWeaponList(selectedCategory);
            int selectedIndex = weaponList.getSelectedIndex();
            if (selectedIndex != -1) {
                List<Weapon> weapons = model.getCategorizedWeapons().get(selectedCategory);
                Weapon selectedWeapon = weapons.get(selectedIndex);
                String imagePath = selectedWeapon.getImagePath();
                int option = JOptionPane.showConfirmDialog(
                        view.getFrame(),
                        selectedWeapon.getDescription() + "\nDo you want to purchase this weapon?",
                        "Weapon Details",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(imagePath));
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
        GameLobbyModel lobbyModel = new GameLobbyModel(model.getPlayer());
        GameLobbyView lobbyView = new GameLobbyView(lobbyModel);
        GameLobbyController lobbyController = new GameLobbyController(lobbyView, lobbyModel);
    }
}
