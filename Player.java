import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private JobClass jobClass;
    private int runes; // Adding runes field
    private List<Weapon> inventory;
    private Weapon equippedWeapon; // Change 'weapon' to 'Weapon'
    private int equippedWeaponIndex = -1;

    /**
     * Constructor for creating a new Player object.
     * @param name The name of the player.
     * @param jobClass The job class of the player.
     */
    public Player(String name, JobClass jobClass) {
        this.name = name;
        this.jobClass = jobClass;
        // Initialize runes to 0
        this.runes = 100000;
        this.inventory = new ArrayList<>();
        this.equippedWeapon = null; // Initialize equipped weapon as null initially
    }

    // Methods for managing inventory

    public void addToInventory(Weapon weapon) {
        inventory.add(weapon);
    }

    public void removeFromInventory(Weapon weapon) {
        inventory.remove(weapon);
    }

    public List<Weapon> getInventory() {
        return inventory;
    }

    // Method to equip a weapon from the inventory
    public void equipWeapon(Weapon weapon) {
        if (inventory.contains(weapon)) {
            equippedWeapon = weapon;
            equippedWeaponIndex = inventory.indexOf(weapon);
        } else {
            System.out.println("The weapon is not in the player's inventory.");
        }
    }

    // Methods for managing runes

    public void deductRunes(int amount) {
        runes -= amount;
    }


    /**
     * Gets the number of runes the player has.
     * @return The number of runes.
     */
    public int getRunes() {
        return runes;
    }

    /**
     * Sets the number of runes the player has.
     * @param runes The number of runes to set.
     */
    public void setRunes(int runes) {
        this.runes = runes;
    }

    // Getters and setters for level
    public void setLevel(int level) {
        this.jobClass.setLevel(level);
    }
    
    public void setEquippedWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }


    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public int getEquippedWeaponIndex() {
        return equippedWeaponIndex;
    }

    // Getters for job stats
    public int getLevel() {
        return jobClass.getLevel();
    }

    public int getHealth() {
        return jobClass.getHP();
    }

    public int getEndurance() {
        return jobClass.getEndurance();
    }

    public int getDexterity() {
        return jobClass.getDexterity();
    }

    public int getStrength() {
        return jobClass.getStrength();
    }

    public int getIntelligence() {
        return jobClass.getIntelligence();
    }

    public int getFaith() {
        return jobClass.getFaith();
    }

    // Getters for name and job class
    public String getName() {
        return name;
    }

    public JobClass getJobClass() {
        return jobClass;
    }
}
