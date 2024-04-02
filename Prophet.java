/**
 * The Prophet class represents a job class specializing in prophecy in the game.
 * It extends the JobClass abstract class and provides specific stats for the Prophet class.
 */
public class Prophet extends JobClass {
    /**
     * Constructor for creating a new Prophet object.
     */
    public Prophet() {
        super(7, 10, 10, 7, 8, 11, 16, "jobpics/prophet.png");
    }

    /**
     * Gets the name of the job class.
     * @return The name of the job class.
     */
    @Override
    public String getJobName() {
        return "Prophet";
    }
}
