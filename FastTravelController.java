import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FastTravelController {
    private FastTravelModel model;
    private FastTravelView view;

    public FastTravelController(FastTravelModel model, FastTravelView view) {
        this.model = model;
        this.view = view;

        view.addTravelButtonListener(new TravelButtonListener());
    }

    class TravelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedOption = view.getSelectedOption();
            System.out.println("Fast traveling to " + selectedOption);
            
            // Check the selected option and perform the appropriate action
            switch (selectedOption) {
                case "Stormveil Castle (Floor 1)":
                    openArea1Screen();
                    break;
                
            }
        }
    }

    private void openArea1Screen() {
        Area1Model area1Model = new Area1Model();
        Area1View area1View = new Area1View(area1Model);
        Area1Controller area1Controller = new Area1Controller(area1Model, area1View);
        area1View.setVisible(true);

        JFrame frame = new JFrame("Area 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(area1View); // Add the Area1View panel to the JFrame
        frame.pack(); // Adjust the frame size to fit the panel
        frame.setVisible(true);
    }
}
