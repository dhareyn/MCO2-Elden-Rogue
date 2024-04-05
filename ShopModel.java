import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The ShopModel class represents the model of the shop.
 * It manages the available weapons and handles purchasing actions.
 */
public class ShopModel {
    private List<Weapon> weapons;
    private Player player;

    /**
     * Constructs a ShopModel object with the specified player.
     * @param player The player associated with this shop model.
     */
    public ShopModel(Player player) {
        this.player = player;
        weapons = new ArrayList<>();
        initializeWeapons();
    }

    // Initializes the list of available weapons
    private void initializeWeapons() {
        // Adding instances of each weapon directly using their constructors
        // Swords
        weapons.add(new ShortSword());
        weapons.add(new RogiersRapier());
        weapons.add(new CodedSword());
        weapons.add(new SwordOfNightAndFlame());

        // Katanas
        weapons.add(new Uchigatana());
        weapons.add(new Moonveil());
        weapons.add(new RiversOfBlood());
        weapons.add(new HandOfMalenia());

        // Whips
        weapons.add(new Whip());
        weapons.add(new Urumi());
        weapons.add(new ThornedWhip());
        weapons.add(new HoslowsPetalWhip());

        // Greatswords
        weapons.add(new Claymore());
        weapons.add(new StarscourageGreatsword());
        weapons.add(new InseparableSword());
        weapons.add(new MalikethsBlackBlade());

        // Staffs
        weapons.add(new AstrologersStaff());
        weapons.add(new AlbinauricStaff());
        weapons.add(new StaffOfTheGuilty());
        weapons.add(new CarianRegalScepter());

        // Seals
        weapons.add(new FingerSeal());
        weapons.add(new GodslayersSeal());
        weapons.add(new GoldenOrderSeal());
        weapons.add(new DragonCommunionSeal());
    }

    /**
     * Retrieves the list of available weapons.
     * @return The list of available weapons.
     */
    public List<Weapon> getWeapons() {
        return weapons;
    }

    /**
     * Handles the purchase of a weapon by deducting the required runes from the player's total.
     * @param weapon The weapon to be purchased.
     * @return True if the purchase is successful, false otherwise.
     */
    public boolean purchaseWeapon(Weapon weapon) {
        int playerRunes = player.getRunes();
        int weaponCost = weapon.getRuneCost();

        if (playerRunes >= weaponCost) {
            player.setRunes(playerRunes - weaponCost);
            return true; // Purchase successful
        } else {
            return false; // Insufficient runes
        }
    }

    // Determines the category of a weapon based on its name
    private String determineCategory(Weapon weapon) {
        String weaponName = weapon.getName().toLowerCase();

        if (weaponName.contains("inseparable sword") || weaponName.contains("claymore") || weaponName.contains("greatsword") || weaponName.contains("blade")) {
            return "Greatswords";
        } else if (weaponName.contains("short") || weaponName.contains("rapier") || weaponName.contains("coded") || weaponName.contains("night")) {
            return "Swords";
        } else if (weaponName.contains("uchigatana") || weaponName.contains("moonveil") || weaponName.contains("blood") || weaponName.contains("hand")) {
            return "Katanas";
        } else if (weaponName.contains("whip") || weaponName.contains("urumi")) {
            return "Whips";
        } else if (weaponName.contains("staff") || weaponName.contains("scepter")) {
            return "Staffs";
        } else if (weaponName.contains("seal")) {
            return "Seals";
        }

        return "Swords"; // Default category
    }

    // Retrieves categorized weapons
    public Map<String, List<Weapon>> getCategorizedWeapons() {
        Map<String, List<Weapon>> categorizedWeapons = new HashMap<>();
        for (Weapon weapon : weapons) {
            String category = determineCategory(weapon);
            categorizedWeapons.computeIfAbsent(category, k -> new ArrayList<>()).add(weapon);
        }
        return categorizedWeapons;
    }

    /**
     * Retrieves the associated player of the shop model.
     * @return The associated player.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Retrieves a weapon by its name.
     * @param name The name of the weapon to retrieve.
     * @return The weapon with the specified name, or null if not found.
     */
    public Weapon getWeaponByName(String name) {
        for (Weapon weapon : weapons) {
            if (weapon.getName().equals(name)) {
                return weapon;
            }
        }
        return null;
    }
}
