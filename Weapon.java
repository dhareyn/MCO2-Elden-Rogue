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

    // Constructor
    public Weapon(String name, int runesCost, int requiredDexterity,
                  int weaponHealth, int weaponDexterity, int weaponIntelligence,
                  int weaponEndurance, int weaponStrength, int weaponFaith) {
        this.name = name;
        this.runesCost = runesCost;
        this.requiredDexterity = requiredDexterity;
        this.weaponHealth = weaponHealth;
        this.weaponDexterity = weaponDexterity;
        this.weaponIntelligence = weaponIntelligence;
        this.weaponEndurance = weaponEndurance;
        this.weaponStrength = weaponStrength;
        this.weaponFaith = weaponFaith;
    }

    // Getter for Rune Cost
    public int getRuneCost() {
        return runesCost;
    }

    // Getter for Required Dexterity
    public int getDexterityRequirement() {
        return requiredDexterity;
    }

    // Getter for Weapon Health
    public int getHealth() {
        return weaponHealth;
    }

    // Getter for Weapon Dexterity
    public int getDexterity() {
        return weaponDexterity;
    }

    // Getter for Weapon Intelligence
    public int getIntelligence() {
        return weaponIntelligence;
    }

    // Getter for Weapon Endurance
    public int getEndurance() {
        return weaponEndurance;
    }

    // Getter for Weapon Strength
    public int getStrength() {
        return weaponStrength;
    }

    // Getter for Weapon Faith
    public int getFaith() {
        return weaponFaith;
    }

    // Getter for Name
    public String getName() {
        return name;
    }
}
