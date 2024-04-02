import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class InventoryView {
    private JFrame frame;
    private JList<String> weaponList;
    private DefaultListModel<String> listModel;
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

        listModel = new DefaultListModel<>();
        weaponList = new JList<>(listModel);
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
        listModel.clear();
        for (int i = 0; i < inventory.size(); i++) {
            Weapon weapon = inventory.get(i);
            String itemName = "[" + i + "] " + weapon.getName();
            if (model.getPlayer().getEquippedWeapon() != null && model.getPlayer().getEquippedWeapon().equals(weapon)) {
                itemName += " (Equipped)"; 
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
