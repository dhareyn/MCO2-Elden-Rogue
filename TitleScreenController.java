import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Controls the behavior of the title screen view.
 */
public class TitleScreenController {
    private TitleScreenModel model;
    private TitleScreenView view;

    /**
     * Constructs a new TitleScreenController with the specified model and view.
     *
     * @param model the title screen model
     * @param view  the title screen view
     */
    public TitleScreenController(TitleScreenModel model, TitleScreenView view) {
        this.model = model;
        this.view = view;
        view.addStartButtonListener(new StartButtonListener());
        view.addExitButtonListener(new ExitButtonListener());
    }

    /**
     * ActionListener for the start button.
     */
    class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(view.getMainFrame(), "Welcome to Elden Rogue!");
            view.close();
            CharacterCreationModel creationModel = new CharacterCreationModel();
            CharacterCreationView creationView = new CharacterCreationView();
            CharacterCreationController creationController = new CharacterCreationController(creationModel, creationView);
            creationView.display();
        }
    }

    /**
     * ActionListener for the exit button.
     */
    class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.close();
        }
    }
}
