/**
 * The Warrior class represents a job class in the game with specific attributes.
 */
public class Warrior extends JobClass {
    /**
     * Constructs a Warrior object with predefined attribute values.
     */
    public Warrior() {
        super(8, 11, 16, 10, 11, 10, 8, "jobpics/warrior.png");
    }

    /**
     * Retrieves the name of the job class.
     * 
     * @return The name of the job class.
     */
    @Override
    public String getJobName() {
        return "Warrior";
    }
}
