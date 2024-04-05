/**
 * Represents the Samurai job class, extending the JobClass abstract class.
 */
public class Samurai extends JobClass {
    /**
     * Constructs a Samurai object with default attributes.
     */
    public Samurai() {
        super(9, 12, 15, 9, 13, 12, 8, "jobpics/samurai.png");
    }

    /**
     * Retrieves the name of the job.
     * @return The name of the job ("Samurai").
     */
    @Override
    public String getJobName() {
        return "Samurai";
    }
}
