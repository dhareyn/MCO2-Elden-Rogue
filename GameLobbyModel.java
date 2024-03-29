public class GameLobbyModel {
    private Player player;

    public GameLobbyModel(Player player) {
        this.player = player;
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getPlayerJobName() {
        return player.getJobClass().getJobName();
    }

    public int getPlayerLevel() {
        return player.getLevel();
    }

    public int getPlayerHealth() {
        return player.getHealth();
    }

    public int getPlayerEndurance() {
        return player.getEndurance();
    }

    public int getPlayerDexterity() {
        return player.getDexterity();
    }

    public int getPlayerStrength() {
        return player.getStrength();
    }

    public int getPlayerIntelligence() {
        return player.getIntelligence();
    }

    public int getPlayerFaith() {
        return player.getFaith();
    }

    public int getPlayerRunes() {
        return player.getRunes();
    }

    public Player getPlayer() {
        return player;
    }
    
    public String getEquippedWeaponName() {
        Weapon equippedWeapon = player.getEquippedWeapon();
        if (equippedWeapon != null) {
            return equippedWeapon.getName();
        } else {
            return "None";
        }
    }

    public String getEquippedWeaponStats() {
        Weapon equippedWeapon = player.getEquippedWeapon();
        if (equippedWeapon != null) {
            // You need to define how you want to display the weapon stats here
            return "Stats [HP: " + equippedWeapon.getHealth() + ", DEX: " + equippedWeapon.getDexterity() +
                    ", INT: " + equippedWeapon.getIntelligence() + ", END: " + equippedWeapon.getEndurance() +
                    ", STR: " + equippedWeapon.getStrength() + ", FTH: " + equippedWeapon.getFaith() + "]";
        } else {
            return "No equipped weapon";
        }
    }
}
