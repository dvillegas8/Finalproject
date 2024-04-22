import javax.swing.*;
import java.awt.*;

public class AirHockeyViewer extends JFrame {
    final private int WINDOW_WIDTH = 500;
    final private int WINDOW_HEIGHT = 900;
    private AirHockey game;
    final private String title = "AirHockey";
    private Ball ball;
    public AirHockeyViewer(AirHockey g, Ball ball){
        // Initialize Instance Variables
        game = g;
        this.ball = ball;
        // Initialize window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(title);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    public void paint(Graphics g){
        // Clear the window.
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        // Draw ball
        ball.draw(g);
    }
}
