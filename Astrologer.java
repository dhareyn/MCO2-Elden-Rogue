/**
 * The Astrologer class represents a job class of an astrologer in a role-playing game.
 * It extends the JobClass abstract class.
 */
public class Astrologer extends JobClass {

    /**
     * Constructs a new Astrologer object with predefined stats.
     */
    public Astrologer() {
        super(6, 9, 12, 16, 9, 8, 7, "jobpics/astrologer.png");
    }

    /**
     * Gets the name of the job class.
     *
     * @return The name of the job class, which is "Astrologer".
     */
    @Override
    public String getJobName() {
        return "Astrologer";
    }
}
