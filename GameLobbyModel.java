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

    public int getWeaponHealth() {
        Weapon equippedWeapon = player.getEquippedWeapon();
        if (equippedWeapon != null) {
            return equippedWeapon.getHealth();
        } else {
            return 0;
        }
    }

    public int getWeaponDexterity() {
        Weapon equippedWeapon = player.getEquippedWeapon();
        if (equippedWeapon != null) {
            return equippedWeapon.getDexterity();
        } else {
            return 0;
        }
    }

    public int getWeaponIntelligence() {
        Weapon equippedWeapon = player.getEquippedWeapon();
        if (equippedWeapon != null) {
            return equippedWeapon.getIntelligence();
        } else {
            return 0;
        }
    }

    public int getWeaponEndurance() {
        Weapon equippedWeapon = player.getEquippedWeapon();
        if (equippedWeapon != null) {
            return equippedWeapon.getEndurance();
        } else {
            return 0;
        }
    }

    public int getWeaponStrength() {
        Weapon equippedWeapon = player.getEquippedWeapon();
        if (equippedWeapon != null) {
            return equippedWeapon.getStrength();
        } else {
            return 0;
        }
    }

    public int getWeaponFaith() {
        Weapon equippedWeapon = player.getEquippedWeapon();
        if (equippedWeapon != null) {
            return equippedWeapon.getFaith();
        } else {
            return 0;
        }
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
}
