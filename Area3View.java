import javax.swing.*;
import java.awt.*;

// View class
public class Area3View extends JPanel {
    private Area3Model model;
    

    public Area3View(Area3Model model) {
        this.model = model;
        setPreferredSize(new Dimension(700, 500)); // Adjusted size to accommodate the largest floor
        setBackground(Color.BLACK); // Set background color to black
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int floor = model.getCurrentFloor();
        switch (floor) {
            case 1:
                drawFloor1(g);
                break;
            case 2:
                drawFloor2(g);
                break;
            case 3:
                drawFloor3(g);
                break;
            default:
                break;
        }
    }

    private void drawFloor1(Graphics g) {
        int rows = 9;
        int cols = 3;
        int cellSize = 50;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 4 && j == 1) { // Check if it's the spawn tile positions
                    g.setColor(Color.YELLOW); // Set color to represent the spawn tile
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize); // Fill rectangle to represent the spawn tile
                    g.setColor(Color.BLACK); // Reset color to black for border
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize); // Draw rectangle border
                    g.drawString("?", j * cellSize + cellSize / 2, i * cellSize + cellSize / 2); // Draw label "?" at the center of the spawn tile
                } else if (i == 0 && j == 1) { // Check if it's the door tile position
                    g.setColor(Color.RED); // Set color to represent the door
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize); // Fill rectangle to represent the door
                    g.setColor(Color.BLACK); // Reset color to black for border
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize); // Draw rectangle border
                    g.drawString("D", j * cellSize + cellSize / 2, i * cellSize + cellSize / 2);

                } 
                else if (i == 8 && j == 1) { // Check if it's the door tile position
                    g.setColor(Color.GREEN); // Set color to represent the door
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize); // Fill rectangle to represent the door
                    g.setColor(Color.BLACK); // Reset color to black for border
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize); // Draw rectangle border
                    g.drawString("F", j * cellSize + cellSize / 2, i * cellSize + cellSize / 2);

                } 
                
                else {
                    g.setColor(Color.GRAY); // Set color to gray for other tiles
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize); // Fill rectangle with gray
                    g.setColor(Color.BLACK); // Reset color to black for border
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize); // Draw rectangle border
                }
            }
        }
        int x = model.getX();
        int y = model.getY();
        int diameter = 50;
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diameter, diameter); // Player circle
    }

    private void drawFloor2(Graphics g) {
        int rows = 7;
        int cols = 7;
        int cellSize = 50;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ( (i == 3 && j == 3) ) { // Check if it's the spawn tile positions
                    g.setColor(Color.YELLOW); // Set color to represent the spawn tile
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize); // Fill rectangle to represent the spawn tile
                    g.setColor(Color.BLACK); // Reset color to black for border
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize); // Draw rectangle border
                    g.drawString("B", j * cellSize + cellSize / 2, i * cellSize + cellSize / 2); // Draw label "?" at the center of the spawn tile
                }

                else if ((i == 6 && j == 3) || (i == 0 && j == 3)) { // Check if it's the door tile position
                    g.setColor(Color.RED); // Set color to represent the door
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize); // Fill rectangle to represent the door
                    g.setColor(Color.BLACK); // Reset color to black for border
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize); // Draw rectangle border
                    g.drawString("D", j * cellSize + cellSize / 2, i * cellSize + cellSize / 2);

                } 
                else {
                    g.setColor(Color.GRAY); // Set color to gray for other tiles
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize); // Fill rectangle with gray
                    g.setColor(Color.BLACK); // Reset color to black for border
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize); // Draw rectangle border
                }
            }
        }
        int x = model.getX();
        int y = model.getY();
        int diameter = 50;
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diameter, diameter); // Player circle
    }

    private void drawFloor3(Graphics g) {
        int rows = 9;
        int cols = 3;
        int cellSize = 50;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i == 8 && j == 1 ) { // Check if it's the door tile position
                    g.setColor(Color.RED); // Set color to represent the door
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize); // Fill rectangle to represent the door
                    g.setColor(Color.BLACK); // Reset color to black for border
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize); // Draw rectangle border
                    g.drawString("D", j * cellSize + cellSize / 2, i * cellSize + cellSize / 2);

                } 

                else if ((i == 1 && j == 0) || (i == 3&& j == 0) ||(i == 5 && j == 0) || (i == 7 && j == 0) || (i == 1 && j ==2) || (i == 3 && j == 2) ||(i == 5 && j == 2) || (i == 7 && j == 2))  { // Check if it's the door tile position
                    g.setColor(Color.ORANGE); // Set color to represent the door
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize); // Fill rectangle to represent the door
                    g.setColor(Color.BLACK); // Reset color to black for border
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize); // Draw rectangle border
                    g.drawString("?", j * cellSize + cellSize / 2, i * cellSize + cellSize / 2);

                } 
                else if (i == 0 && j == 1) { // Check if it's the door tile position
                    g.setColor(Color.GREEN); // Set color to represent the door
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize); // Fill rectangle to represent the door
                    g.setColor(Color.BLACK); // Reset color to black for border
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize); // Draw rectangle border
                    g.drawString("C", j * cellSize + cellSize / 2, i * cellSize + cellSize / 2);

                } 
                else {
                    g.setColor(Color.GRAY); // Set color to gray for other tiles
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize); // Fill rectangle with gray
                    g.setColor(Color.BLACK); // Reset color to black for border
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize); // Draw rectangle border
                }
            }
        }
        int x = model.getX();
        int y = model.getY();
        int diameter = 50;
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diameter, diameter); // Player circle
    }
}
