import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ShopView {
    private JFrame frame;
    public JList<String> weaponList; // Change access modifier
    private DefaultListModel<String> listModel;
    private JButton purchaseButton;
    private JLabel runesLabel;
    private JButton backButton; // Add backButton
    private Player player;

    public ShopView(Player player) {
        this.player = player;
        initializeUI(player);
    }

    private void initializeUI(Player player) {
        frame = new JFrame("Shop");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize components
        listModel = new DefaultListModel<>();
        weaponList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(weaponList);
        purchaseButton = new JButton("Purchase");
        runesLabel = new JLabel("Runes: " + player.getRunes());
        backButton = new JButton("Back to Lobby"); // Create Back button

        // Layout
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(purchaseButton, BorderLayout.SOUTH);
        panel.add(runesLabel, BorderLayout.NORTH);
        panel.add(backButton, BorderLayout.WEST); // Add Back button to the WEST side

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void setWeapons(List<Weapon> weapons) {
        listModel.clear();
        for (Weapon weapon : weapons) {
            listModel.addElement(weapon.getName() + " - Cost: " + weapon.getRuneCost());
        }
    }

    public void setRunes(int runes) {
        runesLabel.setText("Runes: " + runes);
    }

    public void addPurchaseListener(ActionListener listener) {
        purchaseButton.addActionListener(listener);
    }

    // Method to add ActionListener for the Back button
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void display() {
        frame.setVisible(true);
    }

    public void close() {
        frame.dispose();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JList<String> getWeaponList() {
        return weaponList;
    }
}