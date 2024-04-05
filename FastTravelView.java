import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FastTravelView extends JFrame {
    private JComboBox<String> optionsComboBox;
    private JButton travelButton;

    public FastTravelView() {
        setTitle("Fast Travel Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel label = new JLabel("Select an area to fast travel:");
        optionsComboBox = new JComboBox<>();
        optionsComboBox.addItem("Stormveil Castle (Floor 1)");
        optionsComboBox.addItem("Raya Lucaria Academy (Coming Soon!)");
        optionsComboBox.addItem("The Elden Throne (Coming Soon!)");

        travelButton = new JButton("Travel");

        panel.add(label);
        panel.add(optionsComboBox);
        panel.add(travelButton);

        add(panel);
    }

    public int getSelectedIndex() {
        return optionsComboBox.getSelectedIndex();
    }
     public JComboBox<String> getOptionsComboBox() {
        return optionsComboBox;
    }
    public void addTravelButtonListener(ActionListener listener) {
        travelButton.addActionListener(listener);
    }
}
