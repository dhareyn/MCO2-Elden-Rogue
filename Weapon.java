/**
 * Represents a weapon in the game.
 */
public class Weapon {
    private String name;
    private int runesCost;
    private int requiredDexterity;
    private int weaponHealth;
    private int weaponDexterity;
    private int weaponIntelligence;
    private int weaponEndurance;
    private int weaponStrength;
    private int weaponFaith;
    private String imagePath; // Path to the image file

    /**
     * Constructs a new Weapon object.
     *
     * @param name              the name of the weapon
     * @param runesCost         the cost of the weapon in runes
     * @param requiredDexterity the required dexterity to use the weapon
     * @param weaponHealth      the health points provided by the weapon
     * @param weaponDexterity   the dexterity points provided by the weapon
     * @param weaponIntelligence the intelligence points provided by the weapon
     * @param weaponEndurance   the endurance points provided by the weapon
     * @param weaponStrength    the strength points provided by the weapon
     * @param weaponFaith       the faith points provided by the weapon
     * @param imagePath         the path to the image file of the weapon
     */
    public Weapon(String name, int runesCost, int requiredDexterity,
                  int weaponHealth, int weaponDexterity, int weaponIntelligence,
                  int weaponEndurance, int weaponStrength, int weaponFaith, String imagePath) {
        this.name = name;
        this.runesCost = runesCost;
        this.requiredDexterity = requiredDexterity;
        this.weaponHealth = weaponHealth;
        this.weaponDexterity = weaponDexterity;
        this.weaponIntelligence = weaponIntelligence;
        this.weaponEndurance = weaponEndurance;
        this.weaponStrength = weaponStrength;
        this.weaponFaith = weaponFaith;
        this.imagePath = imagePath;
    }

    /**
     * Retrieves the cost of the weapon in runes.
     *
     * @return the cost of the weapon
     */
    public int getRuneCost() {
        return runesCost;
    }

    /**
     * Retrieves the required dexterity to use the weapon.
     *
     * @return the required dexterity
     */
    public int getDexterityRequirement() {
        return requiredDexterity;
    }

    /**
     * Retrieves the health points provided by the weapon.
     *
     * @return the health points
     */
    public int getHealth() {
        return weaponHealth;
    }

    /**
     * Retrieves the dexterity points provided by the weapon.
     *
     * @return the dexterity points
     */
    public int getDexterity() {
        return weaponDexterity;
    }

    /**
     * Retrieves the intelligence points provided by the weapon.
     *
     * @return the intelligence points
     */
    public int getIntelligence() {
        return weaponIntelligence;
    }

    /**
     * Retrieves the endurance points provided by the weapon.
     *
     * @return the endurance points
     */
    public int getEndurance() {
        return weaponEndurance;
    }

    /**
     * Retrieves the strength points provided by the weapon.
     *
     * @return the strength points
     */
    public int getStrength() {
        return weaponStrength;
    }

    /**
     * Retrieves the faith points provided by the weapon.
     *
     * @return the faith points
     */
    public int getFaith() {
        return weaponFaith;
    }

    /**
     * Retrieves the name of the weapon.
     *
     * @return the name of the weapon
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the path to the image file of the weapon.
     *
     * @return the path to the image file
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Generates a description of the weapon including its attributes.
     *
     * @return a string description of the weapon
     */
    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append("Name: ").append(name).append("\n");
        description.append("Rune Cost: ").append(runesCost).append("\n");
        description.append("Required Dexterity: ").append(requiredDexterity).append("\n");
        description.append("Health: ").append(weaponHealth).append("\n");
        description.append("Dexterity: ").append(weaponDexterity).append("\n");
        description.append("Intelligence: ").append(weaponIntelligence).append("\n");
        description.append("Endurance: ").append(weaponEndurance).append("\n");
        description.append("Strength: ").append(weaponStrength).append("\n");
        description.append("Faith: ").append(weaponFaith).append("\n");
        return description.toString();
    }
}
