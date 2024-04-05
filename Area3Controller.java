import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

// Controller class
public class Area3Controller implements KeyListener {
    private Area3Model model;
    private Area3View view;

    public Area3Controller(Area3Model model, Area3View view) {
        this.model = model;
        this.view = view;
        this.view.addKeyListener(this);
        this.view.setFocusable(true);
        this.view.requestFocusInWindow();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        try {
            switch (keyCode) {
                case KeyEvent.VK_W:
                    model.moveUp();
                    break;
                case KeyEvent.VK_S:
                    model.moveDown();
                    break;
                case KeyEvent.VK_A:
                    model.moveLeft();
                    break;
                case KeyEvent.VK_D:
                    model.moveRight();
                    break;
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
