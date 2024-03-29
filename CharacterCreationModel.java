public class CharacterCreationModel {
    private String playerName;
    private JobClass selectedJobClass;

    public CharacterCreationModel() {
        // Initialize any default values or settings here
    }

    // Getter and setter methods for playerName and selectedJobClass

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public JobClass getSelectedJobClass() {
        return selectedJobClass;
    }

    public void setSelectedJobClass(JobClass selectedJobClass) {
        this.selectedJobClass = selectedJobClass;
    }

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
