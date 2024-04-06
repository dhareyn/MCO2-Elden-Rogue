import java.util.Random;

public class BattleModel {
    private EnemyList enemyList = new EnemyList();
    private Random random = new Random();

    public EnemyList getEnemyList() {
        return enemyList;
    }
    public int calculatePlayerHealth(Player player) {
        int playerBaseHealth = player.getHealth();
        Weapon equippedWeapon = player.getEquippedWeapon();
        int weaponHealthBonus = (equippedWeapon != null) ? equippedWeapon.getHealth() : 0;
        return 100 * ((playerBaseHealth + weaponHealthBonus) / 2);
    }
    public int calculatePlayerDamage(Player player, int enemyIndex, int choice) {
        switch (choice) {
            case 0: // Physical Damage
                return calculatePhysicalDamage(player, enemyIndex);
            case 1: // Sorcery Damage
                return calculateSorceryDamage(player, enemyIndex);
            case 2: // Incantation Damage
                return calculateIncantationDamage(player, enemyIndex);
            default:
                return 0;
        }
    }

    public int calculatePhysicalDamage(Player player, int enemyIndex) {
        Weapon equippedWeapon = player.getEquippedWeapon();
        int playerStrength = player.getStrength();
        int weaponStrengthBonus = (equippedWeapon != null) ? equippedWeapon.getStrength() : 0;
        return (int) ((playerStrength + weaponStrengthBonus) * (1 - enemyList.getEnemy(enemyIndex).getPhysicalDefense()));
    }

    public int calculateSorceryDamage(Player player, int enemyIndex) {
        Weapon equippedWeapon = player.getEquippedWeapon();
        int playerIntelligence = player.getIntelligence();
        int weaponIntelligenceBonus = (equippedWeapon != null) ? equippedWeapon.getIntelligence() : 0;
        return (int) ((playerIntelligence + weaponIntelligenceBonus) * (1 - enemyList.getEnemy(enemyIndex).getSorceryDefense()));
    }

    public int calculateIncantationDamage(Player player, int enemyIndex) {
        Weapon equippedWeapon = player.getEquippedWeapon();
        int playerFaith = player.getFaith();
        int weaponFaithBonus = (equippedWeapon != null) ? equippedWeapon.getFaith() : 0;
        return (int) ((playerFaith + weaponFaithBonus) * (1 - enemyList.getEnemy(enemyIndex).getIncantationDefense()));
    }

    public int calculateEnemyDamage(int enemyIndex, boolean boss) {
        Enemy enemy = enemyList.getEnemy(enemyIndex);
        double damage;
        if (boss) {
            damage = (enemy.getHighAttack() + enemy.getLowAttack()) / 2; // Placeholder for boss damage calculation
        } else {
            damage = random.nextInt((enemy.getHighAttack() - enemy.getLowAttack()) + 1) + enemy.getLowAttack();
        }
        return (int) damage;
    }

    public int setEnemyHealth(int enemyIndex) {
        Enemy enemy = enemyList.getEnemy(enemyIndex);
        int lowHealth = enemy.getLowHealth();
        int highHealth = enemy.getHighHealth();
        return random.nextInt(highHealth - lowHealth + 1) + lowHealth;
    }

    public int calculateRunes(int enemyIndex, boolean boss) {
        int enemyHealth = boss ? enemyList.getEnemy(enemyIndex).getHighHealth() : enemyList.getEnemy(enemyIndex).getLowHealth();
        return boss ? enemyHealth * 5 : enemyHealth * 2;
    }
}
