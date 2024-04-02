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

    // Constructor
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

    // Getter for Image Path
    public String getImagePath() {
        return imagePath;
    }

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
