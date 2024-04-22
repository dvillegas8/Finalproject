import java.awt.*;

public class Ball {
    // Coordinates
    private int y;
    private int x;
    // Initial Coordinates
    final private int STARTING_X = 0;
    final private int STARTING_Y = 0;
    private int radius;
    private Color color;
    private int dy;
    private int dx;
    final private int LENGTH = 0;
    final private int WIDTH = 0;
    // Constructor
    public Ball(int y, int x, int dy, int dx, int radius, Color color){
        // Initialize variables
        this.y = y;
        this.x = x;
        this.dy = dy;
        this.dx = dx;
        this.radius = radius;
        this.color = color;
    }
    public void draw(Graphics g){
        // Draw the ball
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

}
