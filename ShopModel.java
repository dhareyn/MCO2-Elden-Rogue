import java.util.ArrayList;
import java.util.List;

public class ShopModel {
    private List<Weapon> weapons;
    private Player player;

    public ShopModel(Player player) {
        this.player = player;
        weapons = new ArrayList<>();
        initializeWeapons();
    }

    private void initializeWeapons() {
        // Add instances of each weapon directly using their constructors
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

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public boolean purchaseWeapon(Weapon weapon) {
        // Check if the player has enough runes to buy the weapon
        int playerRunes = player.getRunes();
        System.out.println("Player runes before purchase: " + playerRunes); // Debug output
        int weaponCost = weapon.getRuneCost();

        if (playerRunes >= weaponCost) {
            // Deduct the cost from the player's total runes
            player.setRunes(playerRunes - weaponCost);
            System.out.println("Weapon purchased. Player runes after purchase: " + player.getRunes()); // Debug output
            return true; // Purchase successful
        } else {
            return false; // Insufficient runes
        }
    }
    
    // Method to categorize weapons based on their names
    private String determineCategory(Weapon weapon) {
        String weaponName = weapon.getName().toLowerCase(); // Convert weapon name to lowercase for case-insensitive comparison

        if (weaponName.contains("sword")) {
            if (weaponName.contains("inseparable sword") || weaponName.contains("claymore") || weaponName.contains("greatsword") || weaponName.contains("blade")) {
                return "Greatswords"; // Treat certain swords as greatswords
            } else if (weaponName.contains("short") || weaponName.contains("rapier") || weaponName.contains("coded") || weaponName.contains("night")){
                return "Swords"; // Other swords
            }
        } else if (weaponName.contains("uchigatana") || weaponName.contains("moonveil") || weaponName.contains("blood") || weaponName.contains("hand")) {
            return "Katanas";
        } else if (weaponName.contains("whip") || weaponName.contains("urumi")) {
            return "Whips";
        } else if (weaponName.contains("staff") || weaponName.contains("scepter")) {
            return "Staffs";
        } else if (weaponName.contains("seal")) {
            return "Seals";
        }

        // If the weapon doesn't match any category, return null
        return "Sword";
    }


    // Method to get categorized weapons
    public List<Weapon> getCategorizedWeapons(String category) {
        List<Weapon> categorizedWeapons = new ArrayList<>();
        for (Weapon weapon : weapons) {
            if (determineCategory(weapon).equals(category)) {
                categorizedWeapons.add(weapon);
            }
        }
        return categorizedWeapons;
    }

    public Player getPlayer() {
        return player;
    }
    public Weapon getWeaponByName(String name) {
        for (Weapon weapon : weapons) {
            if (weapon.getName().equals(name)) {
                return weapon; // Return the weapon if its name matches
            }
        }
        return null; // Return null if no weapon with the given name is found
    }
}
