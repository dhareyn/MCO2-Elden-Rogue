import java.util.ArrayList;
import java.util.List;

public class FastTravelModel {
    private List<String> destinations;
    private Player player;

    public FastTravelModel(Player player) {
        this.player = player;
        // Initialize the list of destinations with only Stormveil Castle
        destinations = new ArrayList<>();
        destinations.add("Stormveil Castle (Floor 1)");
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public Player getPlayer() {
        return player;
    }

    // Implement updateLocation method to update the model based on the selected destination
    public void updateLocation(String destination) {
        // Assuming the destination is always Stormveil Castle for this simplified example
        if (destination.equals("Stormveil Castle (Floor 1)")) {
            // Update model for traveling to Stormveil Castle (Floor 1)
            // Implement any necessary logic here
            System.out.println("Traveling to Stormveil Castle...");
        } else {
            // Handle unknown destinations
            System.out.println("Unknown destination selected.");
        }
    }
}
