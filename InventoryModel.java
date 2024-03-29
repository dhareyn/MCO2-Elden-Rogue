import java.util.List;

public class InventoryModel {
    private Player player;

    public InventoryModel(Player player) {
        this.player = player;
    }

    public List<Weapon> getInventory() {
        return player.getInventory();
    }

    public boolean equipWeapon(int index) {
        List<Weapon> inventory = player.getInventory();
        if (index >= 0 && index < inventory.size()) {
            Weapon weaponToEquip = inventory.get(index);
            // Check if the player's dexterity is sufficient to equip the weapon
            if (player.getDexterity() >= weaponToEquip.getDexterityRequirement()) {
                player.setEquippedWeapon(weaponToEquip);
                return true;
            } else {
                // Player doesn't have enough dexterity to equip the weapon
                return false;
            }
        }
        return false;
    }

    public Player getPlayer() {
        return player;
    }

    public Weapon getWeaponByName(String name) {
        List<Weapon> inventory = player.getInventory();
        for (Weapon weapon : inventory) {
            if (weapon.getName().equals(name)) {
                return weapon;
            }
        }
        return null; // Return null if weapon with the specified name is not found
    }
}
