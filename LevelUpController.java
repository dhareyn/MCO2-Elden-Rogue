import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelUpController {
    private LevelUpModel model;
    private LevelUpView view;
    private Player player;

    public LevelUpController(LevelUpModel model, LevelUpView view, Player player) {
        this.model = model;
        this.view = view;
        this.player = player;

        // Add action listeners to view components
        view.addHealthButtonListener(new HealthButtonListener());
        view.addEnduranceButtonListener(new EnduranceButtonListener());
        view.addDexterityButtonListener(new DexterityButtonListener());
        view.addStrengthButtonListener(new StrengthButtonListener());
        view.addIntelligenceButtonListener(new IntelligenceButtonListener());
        view.addFaithButtonListener(new FaithButtonListener());
        view.addBackButtonListener(new BackButtonListener());
    }

    class HealthButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.levelUp("health");
            int health = player.getJobClass().getHP();
            int level = player.getLevel();
            view.updateHealthLabel(health); // Update health label
            view.updateLevelLabel(level);
        }
    }

    class EnduranceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.levelUp("endurance");
            int endurance = player.getJobClass().getEndurance();
            int level = player.getLevel();
            view.updateEnduranceLabel(endurance); // Update endurance label
            view.updateLevelLabel(level);
        }
    }

    class DexterityButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.levelUp("dexterity");
            int dexterity = player.getJobClass().getDexterity();
            int level = player.getLevel();
            view.updateDexterityLabel(dexterity); // Update dexterity label
            view.updateLevelLabel(level);
        }
    }

    class StrengthButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.levelUp("strength");
            int strength = player.getJobClass().getStrength();
            int level = player.getLevel();
            view.updateStrengthLabel(strength); // Update strength label
            view.updateLevelLabel(level);
        }
    }

    class IntelligenceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.levelUp("intelligence");
            int intelligence = player.getJobClass().getIntelligence();
            int level = player.getLevel();
            view.updateIntelligenceLabel(intelligence); // Update intelligence label
            view.updateLevelLabel(level);
        }
    }

    class FaithButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.levelUp("faith");
            int faith = player.getJobClass().getFaith();
            int level = player.getLevel();
            view.updateFaithLabel(faith); // Update faith label
            view.updateLevelLabel(level);
        }
    }

    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Close the level-up window
            view.closeWindow();

            // Open a new game lobby view
            GameLobbyModel gameLobbyModel = new GameLobbyModel(player);
            GameLobbyView gameLobbyView = new GameLobbyView(gameLobbyModel);
            gameLobbyView.showLobby();
        }
    }
}
