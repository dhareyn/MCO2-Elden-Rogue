import javax.swing.JOptionPane;

public class LevelUpModel {
    private Player player;

    public LevelUpModel(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void levelUp(String stat) {
        int runeCost = calculateRuneCost();
        if (player.getRunes() >= runeCost) {
            switch (stat) {
                case "health":
                    if (player.getJobClass().getHP() < 50) {
                        player.getJobClass().increaseHealth();
                    } else {
                        JOptionPane.showMessageDialog(null, "Health is already at maximum level (50).");
                        return;
                    }
                    break;
                case "endurance":
                    if (player.getJobClass().getEndurance() < 50) {
                        player.getJobClass().increaseEndurance();
                    } else {
                        JOptionPane.showMessageDialog(null, "Endurance is already at maximum level (50).");
                        return;
                    }
                    break;
                case "dexterity":
                    if (player.getJobClass().getDexterity() < 50) {
                        player.getJobClass().increaseDexterity();
                    } else {
                        JOptionPane.showMessageDialog(null, "Dexterity is already at maximum level (50).");
                        return;
                    }
                    break;
                case "strength":
                    if (player.getJobClass().getStrength() < 50) {
                        player.getJobClass().increaseStrength();
                    } else {
                        JOptionPane.showMessageDialog(null, "Strength is already at maximum level (50).");
                        return;
                    }
                    break;
                case "intelligence":
                    if (player.getJobClass().getIntelligence() < 50) {
                        player.getJobClass().increaseIntelligence();
                    } else {
                        JOptionPane.showMessageDialog(null, "Intelligence is already at maximum level (50).");
                        return;
                    }
                    break;
                case "faith":
                    if (player.getJobClass().getFaith() < 50) {
                        player.getJobClass().increaseFaith();
                    } else {
                        JOptionPane.showMessageDialog(null, "Faith is already at maximum level (50).");
                        return;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid stat.");
                    return;
            }
            player.setLevel(player.getLevel() + 1);
            player.setRunes(player.getRunes() - runeCost);
            JOptionPane.showMessageDialog(null, stat.substring(0, 1).toUpperCase() + stat.substring(1) + " increased by 1.");
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient runes.");
        }
    }

    private int calculateRuneCost() {
        int playerLevel = player.getJobClass().getLevel();
        return (playerLevel * 100) / 2;
    }
}
