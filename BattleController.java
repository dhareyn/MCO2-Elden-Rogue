public class BattleController {
    private BattleModel model;
    private BattleView view;

    public BattleController(BattleModel model, BattleView view) {
        this.model = model;
        this.view = view;
    }

    public void initiateBattle(Player player, int area, boolean boss) {
        int playerHealth = model.calculatePlayerHealth(player);
        int enemyIndex = model.getEnemyList().enemyNumber(area, boss); // Accessing enemyList using the getter method
        int enemyHealth = model.setEnemyHealth(enemyIndex);

        StringBuilder battleResult = new StringBuilder();

        boolean playerTurn = true;

        while (playerHealth > 0 && enemyHealth > 0) {
            if (playerTurn) {
                int choice = view.displayBattleOptions();
                int damageDealt = model.calculatePlayerDamage(player, enemyIndex, choice);
                enemyHealth -= damageDealt;
                battleResult.append("Player dealt ").append(damageDealt).append(" damage to the enemy.\n");
            } else {
                int enemyDamage = model.calculateEnemyDamage(enemyIndex, boss);
                playerHealth -= enemyDamage;
                battleResult.append("Enemy dealt ").append(enemyDamage).append(" damage to the player.\n");
            }

            playerTurn = !playerTurn;
            view.displayTurnResult(battleResult.toString(), playerHealth, enemyHealth);

            if (playerHealth <= 0) {
                battleResult.append("YOU DIED\n");
                break;
            } else if (enemyHealth <= 0) {
                battleResult.append("ENEMY FELLED\n");
                int runes = model.calculateRunes(enemyIndex, boss);
                battleResult.append("Player earned ").append(runes).append(" runes.\n");
                player.addRunes(runes);
                break;
            }
        }

        view.displayBattleResult(battleResult.toString());
    }
}
