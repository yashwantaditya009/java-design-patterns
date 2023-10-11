import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SimpleGame extends JPanel implements ActionListener, KeyListener {
    private int x = 100;
    private int y = 100;

    public SimpleGame() {
        Timer timer = new Timer(10, this); // Set the timer to fire every 10 milliseconds
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Game logic and updates go here
        // For example, you can move the object or check for collisions
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Drawing code: draw game elements based on current state (x, y, etc.)
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key typed events (if needed)
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle key pressed events (e.g., move player)
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            x -= 5;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            x += 5;
        } else if (keyCode == KeyEvent.VK_UP) {
            y -= 5;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            y += 5;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key released events (if needed)
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Game Example");
        SimpleGame game = new SimpleGame();
        frame.add(game);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
