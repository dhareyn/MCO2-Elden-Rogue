
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;
import java.awt.Point;

public class Area1Model {
    private int x;
    private int y;
    private int currentFloor = 1; // Start at floor 1
    private int[] floorGridRows = {7, 7, 7}; // Number of rows for each floor
    private int[] floorGridCols = {3, 7, 5}; // Number of columns for each floor
    private int cellSize = 50; // Size of each grid cell
    private Set<Point> disabledTiles = new HashSet<>(); // Track disabled tiles
    private Player player;

    public Area1Model(Player player) {
        this.player = player;
        // Set the initial position for floor 1
        x = 50; // Starting position for floor 1, column 2 (index 1) * cellSize
        y = 300; // Starting position for floor 1, row 7 (index 6) * cellSize
    }
    public Player getPlayer() {
        return player;
    }
    public String getPlayerName() {
        return player.getName();
    }
    public int getPlayerRunes() {
        return player.getRunes();
    }
    public int getPlayerHealth() {
        return player.getHealth();
    }

    public int getPlayerLevel() {
        return player.getLevel();
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
            if ((playerX == 25 && playerY == 0) || (playerX == 0 && playerY == 50) || (playerX == 100 && playerY == 50) || (playerX == 150 && playerY == 50) ) {
                checkTile(playerX, playerY);
            }
            // Check if player reaches the door tile position to transition to floor 2
            if (playerX == 50 && playerY == 0) 
            {
                Random rand = new Random();
                int randomNumber = rand.nextInt(100);
                if (randomNumber < 20){
                    System.out.println("Goodbye.");
                    System. exit(0);

                }
                else 
                setCurrentFloor(2); // Change to floor 2
                // Set the starting position for floor 2
                x = 150; // Starting position for floor 2, column 1 * cellSize
                y = 300; // Starting position for floor 2, row 7 * cellSize
            }
        }

        else if (currentFloor == 2) {
            // Check if player steps on any of the specified tiles on floor 2
            if ((playerX == 0 && playerY == 150)||(playerX == 150 && playerY == 150) || (playerX == 100 && playerY == 150) ||(playerX == 200 && playerY == 150) || (playerX == 300 && playerY == 150) ||(playerX == 100 && playerY == 250) || (playerX == 200 && playerY == 250) || (playerX == 150 && playerY == 50)) {
                checkTile(playerX, playerY);
            }
            // Check if player is at column 4, row 7 on floor 2 to transition to floor 3
            else if (currentFloor == 2 && playerX == 150 && playerY == 0) {
                setCurrentFloor(3); // Change to floor 3
                // Set the starting position for floor 3
                x = 100; // Starting position for floor 3, column 3 * cellSize
                y = 300; // Starting position for floor 3, row 7 * cellSize
            }
        }
        else if(currentFloor == 3) {
            if(playerX == 100 && playerY == 0) {
                System.out.println("FAST TRAVEL TILE!");
            }else if(playerX == 100 && playerY == 150 && !isDisabledTile(new Point(x, y))) {
                System.out.println("BOSS TILE!");
                BossTile(playerX, playerY);
            }
        }
    }
    private void BossTile(int x, int y) {
        EnemyList enemyList = new EnemyList();
        int enemyIndex = enemyList.enemyNumber(1, true); // Pass area 1 and a boss
        Enemy enemy = enemyList.getEnemy(enemyIndex);

        JOptionPane.showMessageDialog(null, "Boss Found: " + enemy.getName(), "Enemy", JOptionPane.INFORMATION_MESSAGE);

        BattleModel battleModel = new BattleModel();
        BattleView battleView = new BattleView();
        BattleController battleController = new BattleController(battleModel, battleView);
        battleController.initiateBattle(player, 1, true);
        disableTile(new Point(x, y));
    }

    private boolean isSpawnTile(int x, int y) {
        return (x == 25 && y == 0) || (x == 0 && y == 50) || (x == 100 && y == 50) || (x == 150 && y == 50) || (x == 0 && y== 150)||(x== 150 && y == 150) || (x == 100 && y == 150) ||(x == 200 && y == 150) || (x == 300 && y== 150) ||(x == 100 && y == 250) || (x== 200 && y== 250) || (x== 150 && y== 50) ;
    }

    private boolean isDisabledTile(Point point) {
        return disabledTiles.contains(new Point(x, y));
    }

    private void disableTile(Point point) {
        disabledTiles.add(point);
    }

    private void checkTile(int x, int y) {
        if (isSpawnTile(x, y) && !isDisabledTile(new Point(x, y))) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(100);
            if (randomNumber < 75) {
                EnemyList enemyList = new EnemyList();
                int enemyIndex = enemyList.enemyNumber(1, false); // Pass area 1 and not a boss
                Enemy enemy = enemyList.getEnemy(enemyIndex);

                JOptionPane.showMessageDialog(null, "Enemy Found: " + enemy.getName(), "Enemy", JOptionPane.INFORMATION_MESSAGE);

                BattleModel battleModel = new BattleModel();
                BattleView battleView = new BattleView();
                BattleController battleController = new BattleController(battleModel, battleView);
                battleController.initiateBattle(player, 1, false);

            } else {
                int treasureValue = rand.nextInt(101) + 50;
                JOptionPane.showMessageDialog(null, "Treasure spawned: " + treasureValue, "Treasure", JOptionPane.INFORMATION_MESSAGE);
                player.addRunes(treasureValue);
            }
            disableTile(new Point(x, y)); // Disable the tile after triggering
        }
    }
}
