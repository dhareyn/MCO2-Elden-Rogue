/**
 * The Vagabond class represents a job class in the game with specific attributes.
 */
public class Vagabond extends JobClass {
    /**
     * Constructs a Vagabond object with predefined attribute values.
     */
    public Vagabond() {
        super(9, 15, 13, 9, 11, 14, 9, "jobpics/vagabond.png");
    }

    /**
     * Retrieves the name of the job class.
     * 
     * @return The name of the job class.
     */
    @Override
    public String getJobName() {
        return "Vagabond";
    }
}
