import javax.swing.JOptionPane;

public class BattleView {
    public int displayBattleOptions() {
        String[] options = {"Physical Damage", "Sorcery Damage", "Incantation Damage"};
        int choice = JOptionPane.showOptionDialog(null, "Select your action:", "Battle Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return choice;
    }

    public void displayTurnResult(String battleResult, int playerHealth, int enemyHealth) {
        JOptionPane.showMessageDialog(null, battleResult + "\nPlayer Health: " + playerHealth + "\nEnemy Health: " + enemyHealth,
                "Turn Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayBattleResult(String battleResult) {
        JOptionPane.showMessageDialog(null, battleResult, "Battle Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
