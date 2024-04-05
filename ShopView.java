import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * The ShopView class represents the view of the shop interface.
 * It provides methods to interact with the shop UI components.
 */
public class ShopView {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private Map<String, JList<String>> weaponLists;
    private DefaultListModel<String> listModel;
    private JLabel selectedWeaponLabel;
    private JLabel runesLabel;
    private ShopModel model;
    private JButton backButton;
    private JButton selectButton;

    /**
     * Constructs a ShopView object with the specified ShopModel.
     * @param model The ShopModel associated with this view.
     */
    public ShopView(ShopModel model) {
        this.model = model;
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Shop");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listModel = new DefaultListModel<>();
        weaponLists = new HashMap<>();
        runesLabel = new JLabel("Runes: " + model.getPlayer().getRunes());

        tabbedPane = new JTabbedPane();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(runesLabel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        backButton = new JButton("Back");
        selectButton = new JButton("Select");
        buttonsPanel.add(selectButton);
        buttonsPanel.add(backButton);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Adds a new weapon category to the shop view.
     * @param category The name of the weapon category.
     * @param weapons The list of weapons in the category.
     */
    public void addWeaponCategory(String category, List<String> weapons) {
        JList<String> weaponList = new JList<>(weapons.toArray(new String[0]));
        JScrollPane scrollPane = new JScrollPane(weaponList);
        weaponLists.put(category, weaponList);
        tabbedPane.addTab(category, scrollPane);
    }

    /**
     * Sets the details of the selected weapon.
     * @param details The details of the selected weapon.
     */
    public void setSelectedWeaponDetails(String details) {
        selectedWeaponLabel.setText(details);
    }

    /**
     * Sets the number of runes available.
     * @param runes The number of runes available.
     */
    public void setRunes(int runes) {
        runesLabel.setText("Runes: " + runes);
    }

    /**
     * Adds a listener to the back button.
     * @param listener The ActionListener for the back button.
     */
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    /**
     * Adds a listener to the select button.
     * @param listener The ActionListener for the select button.
     */
    public void addWeaponSelectListener(ActionListener listener) {
        selectButton.addActionListener(listener);
    }

    /**
     * Retrieves the selected weapon category.
     * @return The selected weapon category.
     */
    public String getSelectedCategory() {
        int selectedIndex = tabbedPane.getSelectedIndex();
        return tabbedPane.getTitleAt(selectedIndex);
    }

    /**
     * Displays the shop view.
     */
    public void display() {
        frame.setVisible(true);
    }

    /**
     * Closes the shop view.
     */
    public void close() {
        frame.dispose();
    }

    /**
     * Retrieves the JFrame of the shop view.
     * @return The JFrame of the shop view.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Retrieves the list of weapons in the selected category.
     * @param category The selected weapon category.
     * @return The list of weapons in the selected category.
     */
    public JList<String> getSelectedWeaponList(String category) {
        return weaponLists.get(category);
    }
}
