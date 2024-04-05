/**
 * Represents the model for character creation, managing player name and selected job class.
 */
public class CharacterCreationModel {
    private String playerName;
    private JobClass selectedJobClass;

    /**
     * Constructs a new CharacterCreationModel with default settings.
     */
    public CharacterCreationModel() {
        this.playerName = null;
        this.selectedJobClass = null;
    }

    /**
     * Retrieves the player's name.
     *
     * @return the player's name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets the player's name.
     *
     * @param playerName the player's name to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Retrieves the selected job class.
     *
     * @return the selected job class
     */
    public JobClass getSelectedJobClass() {
        return selectedJobClass;
    }

    /**
     * Sets the selected job class.
     *
     * @param selectedJobClass the selected job class to set
     */
    public void setSelectedJobClass(JobClass selectedJobClass) {
        this.selectedJobClass = selectedJobClass;
    }

    /**
     * Retrieves the JobClass object based on the selected class name.
     *
     * @param selectedClass the name of the selected class
     * @return the corresponding JobClass object
     */
    public JobClass getJobClass(String selectedClass) {
        switch (selectedClass) {
            case "Vagabond":
                return new Vagabond();
            case "Samurai":
                return new Samurai();
            case "Warrior":
                return new Warrior();
            case "Astrologer":
                return new Astrologer();
            case "Hero":
                return new Hero();
            case "Prophet":
                return new Prophet();
            default:
                return null;
        }
    }
}
