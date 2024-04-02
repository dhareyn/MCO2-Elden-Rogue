import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ShopView {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private Map<String, JList<String>> weaponLists; // Map to store weapon lists by category
    private DefaultListModel<String> listModel;
    private JLabel selectedWeaponLabel;
    private JLabel runesLabel;
    private ShopModel model; // Added ShopModel reference
    private JButton backButton; // Added back button
    private JButton selectButton;

    public ShopView(ShopModel model) {
        this.model = model;
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Shop");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize components
        listModel = new DefaultListModel<>();
        weaponLists = new HashMap<>();
        runesLabel = new JLabel("Runes: " + model.getPlayer().getRunes()); // Access player through model

        // Create tabbed pane
        tabbedPane = new JTabbedPane();

        // Layout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Add tabbed pane to main panel
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(runesLabel, BorderLayout.NORTH);

        // Create buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        backButton = new JButton("Back");
        selectButton = new JButton("Select"); // Added select button
        buttonsPanel.add(selectButton); // Added select button to the buttons panel
        buttonsPanel.add(backButton);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        frame.add(mainPanel);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
    }

    public void addWeaponCategory(String category, List<String> weapons) {
        JList<String> weaponList = new JList<>(weapons.toArray(new String[0]));
        JScrollPane scrollPane = new JScrollPane(weaponList);
        weaponLists.put(category, weaponList);
        tabbedPane.addTab(category, scrollPane);
    }

    public void setSelectedWeaponDetails(String details) {
        selectedWeaponLabel.setText(details);
    }

    public void setRunes(int runes) {
        runesLabel.setText("Runes: " + runes);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void addWeaponSelectListener(ActionListener listener) {
        selectButton.addActionListener(listener);
    }

    public String getSelectedCategory() {
        int selectedIndex = tabbedPane.getSelectedIndex();
        return tabbedPane.getTitleAt(selectedIndex);
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

    public JList<String> getSelectedWeaponList(String category) {
        return weaponLists.get(category);
    }
}
