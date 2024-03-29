import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class TitleScreenController {
    private TitleScreenModel model;
    private TitleScreenView view;

    public TitleScreenController(TitleScreenModel model, TitleScreenView view) {
        this.model = model;
        this.view = view;

        // Add listeners and initialize the view
        view.addStartButtonListener(new StartButtonListener());
        view.addExitButtonListener(new ExitButtonListener());
    }

    class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle start button click
            JOptionPane.showMessageDialog(view.getMainFrame(), "Welcome to Elden Rogue!");
            view.close();

            // Create new CharacterCreationModel, CharacterCreationView, and CharacterCreationController
            CharacterCreationModel creationModel = new CharacterCreationModel();
            CharacterCreationView creationView = new CharacterCreationView();
            CharacterCreationController creationController = new CharacterCreationController(creationModel, creationView);

            creationView.display();
        }
    }

    class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle exit button click
            view.close();
        }
    }
}
