import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class FastTravelController {
    private FastTravelModel model;
    private FastTravelView view;

    public FastTravelController(FastTravelModel model, FastTravelView view) {
        this.model = model;
        this.view = view;

        view.addTravelButtonListener(new TravelButtonListener());
        view.addBackButtonListener(new BackButtonListener()); // Add ActionListener for the back button
    }

    class TravelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = view.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedOption = (String) view.getOptionsComboBox().getItemAt(selectedIndex);
                System.out.println("Fast traveling to " + selectedOption);

                // Check the selected option and perform the appropriate action
                switch (selectedOption) {
                    case "Stormveil Castle (Floor 1)": {
                        openArea1Screen(model.getPlayer());
                        break;
                    }
                    case "Raya Lucaria Academy (Floor 1)": {
                        openArea2Screen(model.getPlayer());
                        break;
                    }
                    // Add cases for other options if needed
                }
            } else {
                System.out.println("No option selected.");
            }
        }
    }

    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.closeWindow(); // Close the current window

            // Open a new game lobby view
            GameLobbyModel gameLobbyModel = new GameLobbyModel(model.getPlayer());
            GameLobbyView gameLobbyView = new GameLobbyView(gameLobbyModel);
            GameLobbyController gameLobbyController = new GameLobbyController(gameLobbyView, gameLobbyModel);
        }
    }

    private void openArea1Screen(Player player) {
        Area1Model area1Model = new Area1Model(player);
        Area1View area1View = new Area1View(area1Model);
        Area1Controller area1Controller = new Area1Controller(area1Model, area1View);

        JFrame frame = new JFrame("Area 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(area1View); // Add the Area1View panel to the JFrame
        frame.pack(); // Adjust the frame size to fit the panel
        frame.setVisible(true); // Make the frame visible    }
    }
    private void openArea2Screen(Player player) {
        Area2Model area2Model = new Area2Model(player);
        Area2View area2View = new Area2View(area2Model);
        Area2Controller area2Controller = new Area2Controller(area2Model, area2View);

        JFrame frame = new JFrame("Area 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(area2View); // Add the Area1View panel to the JFrame
        frame.pack(); // Adjust the frame size to fit the panel
        frame.setVisible(true); // Make the frame visible    }
    }
}
