import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;
import java.awt.Point;



public class Area3Model {
    private int x;
    private int y;
    private int currentFloor = 1; // Start at floor 1
    private int[] floorGridRows = {9, 7, 9}; // Number of rows for each floor
    private int[] floorGridCols = {3, 7, 3}; // Number of columns for each floor
    private int cellSize = 50; // Size of each grid cell
    private Set<Point> disabledTiles = new HashSet<>(); // Track disabled tiles
  

    public Area3Model() {
        // Set the initial position for floor 1
        x = 50; // Starting position for floor 1, column 2 (index 1) * cellSize
        y = 400; // Starting position for floor 1, row 7 (index 6) * cellSize
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        int newRow = y - cellSize; // Move up one grid cell
        if (!isValidMove(x, newRow)) {
            throw new IllegalArgumentException("Cannot move up. Out of bounds.");
        }
        y = newRow;
        checkFloorChange();
    }

    public void moveDown() {
        int newRow = y + cellSize; // Move down one grid cell
        if (!isValidMove(x, newRow)) {
            throw new IllegalArgumentException("Cannot move down. Out of bounds.");
        }
        y = newRow;
        checkFloorChange();
    }

    public void moveLeft() {
        int newCol = x - cellSize; // Move left one grid cell
        if (!isValidMove(newCol, y)) {
            throw new IllegalArgumentException("Cannot move left. Out of bounds.");
        }
        x = newCol;
        checkFloorChange();
    }

    public void moveRight() {
        int newCol = x + cellSize; // Move right one grid cell
        if (!isValidMove(newCol, y)) {
            throw new IllegalArgumentException("Cannot move right. Out of bounds.");
        }
        x = newCol;
        checkFloorChange(); // Check for floor change when moving right
    }

    private boolean isValidMove(int newX, int newY) {
        int floor = getCurrentFloor();
        int maxRow = floorGridRows[floor - 1];
        int maxCol = floorGridCols[floor - 1];
    
        // Exclude specific tiles from being considered within bounds
        if (floor == 2 && ((newX == 0 && newY == 0) || (newX == 0 && newY == 300) || (newX == 300 && newY == 0) || (newX == 300 && newY == 300))) {
            return false;
        }
    
        return newX >= 0 && newY >= 0 && newX < maxCol * cellSize && newY < maxRow * cellSize;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }

    private void checkFloorChange() {
        int playerX = getX();
        int playerY = getY();
    
        if (currentFloor == 1 ) {
            // Check if player steps on any of the specified tiles on floor 1
            if (playerX == 50 && playerY == 200) {
                checkTile(playerX, playerY);
            }
            
            
            // Check if player reaches the door tile position to transition to floor 2
            if (playerX == 50 && playerY == 0) {
                setCurrentFloor(2); // Change to floor 2
                // Set the starting position for floor 2
                x = 150; // Starting position for floor 2, column 1 * cellSize
                y = 300; // Starting position for floor 2, row 7 * cellSize
            }
        }

       
        // Check if player is at column 4, row 7 on floor 2 to transition to floor 3
    else if (currentFloor == 2) {
        if (playerX == 150 && playerY == 0) {
            setCurrentFloor(3); // Change to floor 2
            // Set the starting position for floor 2
            x = 50; // Starting position for floor 2, column 1 * cellSize
            y = 400; // Starting position for floor 2, row 7 * cellSize
        }
        }
    

    else if (currentFloor == 3) {
        if ( (playerX== 0 && playerY == 50) || (playerX== 0 && playerY == 150) || (playerX == 0 && playerY == 250) || (playerX == 0 && playerY == 350) || (playerX== 100 && playerY== 150)||(playerX== 100 && playerY== 250) || (playerX == 100 && playerY== 350) ||(playerX == 100 && playerY== 50) ){
    
        checkTile(playerX, playerY);
        }
    }
    }
    private boolean isSpawnTile(int x, int y) {
        return ((x == 0 && y == 50) || (x == 0 && y == 150) || (x == 0 && y == 250) || (x == 0 && y== 350)||(x== 100 && y == 250) || (x == 100 && y == 350) ||(x == 100 && y == 50) || (x == 100 && y == 150)|| (x == 50 && y == 200) ) ;
    }

    private boolean isDisabledTile(Point point) {
        return disabledTiles.contains(point);
    }

    private void disableTile(Point point) {
        disabledTiles.add(point);
    }

    private void checkTile(int x, int y) {
        if (isSpawnTile(x, y) && !isDisabledTile(new Point(x, y))) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(100);
            if (randomNumber < 75) {
                JOptionPane.showMessageDialog(null, "No treasure found!", "Treasure", JOptionPane.INFORMATION_MESSAGE);
            } else {
                int treasureValue = rand.nextInt(101) + 50;
                JOptionPane.showMessageDialog(null, "Treasure spawned: " + treasureValue, "Treasure", JOptionPane.INFORMATION_MESSAGE);
            }
            disableTile(new Point(x, y)); // Disable the tile after triggering
        }
    }

    private void initiateBattle() {
        // Simulate a battle (similar to previous implementations)
        JOptionPane.showMessageDialog(null, "Enemy encountered! Prepare for battle!", "Battle", JOptionPane.INFORMATION_MESSAGE);
        int playerHP = 100; // Player's initial HP
        int enemyHP = 50; // Enemy's initial HP
        boolean playerTurn = true; // Player starts first
        while (playerHP > 0 && enemyHP > 0) {
            if (playerTurn) {
                // Player's turn
                String action = JOptionPane.showInputDialog(null, "Your turn! Choose action (attack, defend):", "Action", JOptionPane.QUESTION_MESSAGE);
                if (action != null && action.equalsIgnoreCase("attack")) {
                    int damage = new Random().nextInt(10) + 1; // Random damage between 1 and 10
                    enemyHP -= damage;
                    JOptionPane.showMessageDialog(null, "You attacked the enemy for " + damage + " damage!", "Battle", JOptionPane.INFORMATION_MESSAGE);
                } else if (action != null && action.equalsIgnoreCase("defend")) {
                    // Player defends, reducing enemy's next attack damage
                    JOptionPane.showMessageDialog(null, "You defended!", "Battle", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid action!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Enemy's turn
                int damage = new Random().nextInt(10) + 1; // Random damage between 1 and 10
                playerHP -= damage;
                JOptionPane.showMessageDialog(null, "Enemy attacked you for " + damage + " damage!", "Battle", JOptionPane.INFORMATION_MESSAGE);
            }
            playerTurn = !playerTurn; // Switch turn
        }
        // Battle outcome
        if (playerHP <= 0) {
            JOptionPane.showMessageDialog(null, "Defeated! Game Over!", "Battle Result", JOptionPane.ERROR_MESSAGE);
            // Implement game over logic or return to main menu
        } else {
            JOptionPane.showMessageDialog(null, "Victory! You defeated the enemy!", "Battle Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
}


