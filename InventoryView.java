import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class InventoryView {
    private JFrame frame;
    private JList<String> weaponList; // JList for displaying weapons
    private DefaultListModel<String> listModel; // Model for the JList
    private JButton selectButton;
    private JButton backButton;
    private ActionListener selectListener;
    private ActionListener backListener;
    private InventoryModel model;

    public InventoryView(InventoryModel model) {
        this.model = model;
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>(); // Initialize the list model
        weaponList = new JList<>(listModel); // Initialize the JList with the model
        JScrollPane scrollPane = new JScrollPane(weaponList);
        frame.add(scrollPane, BorderLayout.CENTER);

        selectButton = new JButton("SELECT WEAPON");
        backButton = new JButton("BACK");
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(selectButton);
        buttonPanel.add(backButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
    }

    public void setInventory(List<Weapon> inventory) {
        listModel.clear(); // Clear the existing items in the list model
        for (int i = 0; i < inventory.size(); i++) {
            Weapon weapon = inventory.get(i);
            String itemName = "[" + i + "] " + weapon.getName(); // Add the weapon name
            if (model.getPlayer().getEquippedWeapon() != null && model.getPlayer().getEquippedWeapon().equals(weapon)) {
                itemName += " (Equipped)"; // Add "E" if the item is equipped
            }
            listModel.addElement(itemName);
        }
        frame.setVisible(true);
    }

    public void addSelectListener(ActionListener listener) {
        selectListener = listener;
        selectButton.addActionListener(listener);
    }

    public void addBackListener(ActionListener listener) {
        backListener = listener;
        backButton.addActionListener(listener);
    }

    public void highlightEquippedWeapon(int index) {
        weaponList.setSelectedIndex(index); // Select the equipped weapon in the JList
    }

    public JFrame getFrame() {
        return frame;
    }

    public String getSelectedWeapon() {
        int selectedIndex = weaponList.getSelectedIndex();
        if (selectedIndex != -1) {
            return listModel.getElementAt(selectedIndex);
        }
        return null;
    }
}
