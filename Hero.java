/**
 * The Hero class represents a specific job class in the game.
 * Heroes are powerful and well-rounded characters with balanced stats.
 */
public class Hero extends JobClass {
    
    /**
     * Constructs a Hero object with predefined stats.
     * The stats are represented in the following order: [HP, MP, Attack, Defense, Agility, Intelligence, Luck]
     */
    public Hero() {
        super(7, 14, 9, 7, 12, 16, 8, "jobpics/hero.png");
    }

    /**
     * Retrieves the name of the job class.
     *
     * @return The name of the job class.
     */
    @Override
    public String getJobName() {
        return "Hero";
    }
}
