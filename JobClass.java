/**
 * The JobClass class represents an abstract job class in the game.
 * Each job class has specific stats and methods for stat manipulation.
 */
public abstract class JobClass {
    private int level;
    private int hp;
    private int dexterity;
    private int intelligence;
    private int endurance;
    private int strength;
    private int faith;

    /**
     * Constructs a JobClass object with specified stats.
     *
     * @param level        The level of the character.
     * @param hp           The health points of the character.
     * @param dexterity    The dexterity of the character.
     * @param intelligence The intelligence of the character.
     * @param endurance    The endurance of the character.
     * @param strength     The strength of the character.
     * @param faith        The faith of the character.
     */
    public JobClass(int level, int hp, int dexterity, int intelligence, int endurance, int strength, int faith) {
        this.level = level;
        this.hp = hp;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.endurance = endurance;
        this.strength = strength;
        this.faith = faith;
    }

    /**
     * Retrieves the level of the character.
     *
     * @return The level of the character.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Retrieves the health points of the character.
     *
     * @return The health points of the character.
     */
    public int getHP() {
        return hp;
    }

    /**
     * Retrieves the dexterity of the character.
     *
     * @return The dexterity of the character.
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Retrieves the intelligence of the character.
     *
     * @return The intelligence of the character.
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Retrieves the endurance of the character.
     *
     * @return The endurance of the character.
     */
    public int getEndurance() {
        return endurance;
    }

    /**
     * Retrieves the strength of the character.
     *
     * @return The strength of the character.
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Retrieves the faith of the character.
     *
     * @return The faith of the character.
     */
    public int getFaith() {
        return faith;
    }

    /**
     * Sets the level of the character.
     *
     * @param level The level to set.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Retrieves the name of the job class.
     *
     * @return The name of the job class.
     */
    public abstract String getJobName();

    /**
     * Increases the health points of the character by 1.
     */
    public void increaseHealth() {
        hp++;
    }

    /**
     * Increases the endurance of the character by 1.
     */
    public void increaseEndurance() {
        endurance++;
    }

    /**
     * Increases the dexterity of the character by 1.
     */
    public void increaseDexterity() {
        dexterity++;
    }

    /**
     * Increases the strength of the character by 1.
     */
    public void increaseStrength() {
        strength++;
    }

    /**
     * Increases the intelligence of the character by 1.
     */
    public void increaseIntelligence() {
        intelligence++;
    }

    /**
     * Increases the faith of the character by 1.
     */
    public void increaseFaith() {
        faith++;
    }
}
