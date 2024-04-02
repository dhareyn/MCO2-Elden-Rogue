import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelUpController {
    private LevelUpModel model;
    private LevelUpView view;

    public LevelUpController(LevelUpModel model, LevelUpView view) {
        this.model = model;
        this.view = view;

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
            int health = model.getPlayer().getJobClass().getHP();
            int level = model.getPlayer().getLevel();
            view.updateHealthLabel(health); // Update health label
            view.updateLevelLabel(level);
        }
    }

    class EnduranceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.levelUp("endurance");
            int endurance = model.getPlayer().getJobClass().getEndurance();
            int level = model.getPlayer().getLevel();
            view.updateEnduranceLabel(endurance); // Update endurance label
            view.updateLevelLabel(level);
        }
    }

    class DexterityButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.levelUp("dexterity");
            int dexterity = model.getPlayer().getJobClass().getDexterity();
            int level = model.getPlayer().getLevel();
            view.updateDexterityLabel(dexterity); // Update dexterity label
            view.updateLevelLabel(level);
        }
    }

    class StrengthButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.levelUp("strength");
            int strength = model.getPlayer().getJobClass().getStrength();
            int level = model.getPlayer().getLevel();
            view.updateStrengthLabel(strength); // Update strength label
            view.updateLevelLabel(level);
        }
    }

    class IntelligenceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.levelUp("intelligence");
            int intelligence = model.getPlayer().getJobClass().getIntelligence();
            int level = model.getPlayer().getLevel();
            view.updateIntelligenceLabel(intelligence); // Update intelligence label
            view.updateLevelLabel(level);
        }
    }

    class FaithButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.levelUp("faith");
            int faith = model.getPlayer().getJobClass().getFaith();
            int level = model.getPlayer().getLevel();
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
            GameLobbyModel gameLobbyModel = new GameLobbyModel(model.getPlayer());
            GameLobbyView gameLobbyView = new GameLobbyView(gameLobbyModel);
            GameLobbyController gameLobbyController = new GameLobbyController(gameLobbyView, gameLobbyModel);
        }
    }
}
