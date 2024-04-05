/**
 * Main class to start the game.
 */
public class MainGame {
    /**
     * Main method to initialize the title screen model, view, and controller, and display the title screen.
     */
    public static void main(String[] args) {
        TitleScreenModel model = new TitleScreenModel();
        TitleScreenView view = new TitleScreenView();
        TitleScreenController controller = new TitleScreenController(model, view);

        view.display();
    }
}
