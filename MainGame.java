public class MainGame {
	public static void main(String[] args) {
		TitleScreenModel model = new TitleScreenModel();
		TitleScreenView view = new TitleScreenView();
		TitleScreenController controller = new TitleScreenController(model, view);

		view.display();
	}
}
