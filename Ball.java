import java.awt.*;

public class Ball {
    // Instance variables
    private int y;
    private int x;
    final private int STARTING_X = 0;
    final private int STARTING_Y = 0;
    private int radius;
    private Color color;
    private int dy;
    private int dx;
    final private int LENGTH = 0;
    final private int WIDTH = 0;
    private AirHockeyViewer window;
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
    // Draw the ball
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
    // Move the ball
    public void move(){
        x += dx;
        y += dy;
    }
    // Makes ball bounce from the sides of the screen
    public void bounce(){
        // Bounce off the left and right side
        if((x - radius <= 0 && dx < 0 )|| (x + radius >= AirHockeyViewer.WINDOW_WIDTH && dx > 0)){
            dx *= -1;
            // Add speed when it bounces off the wall
            if(dx < 0){
                dx -= 0.3;
            }
            else{
                dx += 0.3;
            }
        }
        // bounce off the top and bottom side
        if((y - radius <= AirHockeyViewer.TITLE_BAR_HEIGHT && dy < 0) || y + radius >= AirHockeyViewer.WINDOW_HEIGHT && dy > 0){
            dy *= -1;
            // Add speed when it bounces off the wall
            if(dy < 0){
                dy -= 1;
            }
            else{
                dy += 1;
            }
        }
    }
    // Getter and Setters
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getDx(){
        return dx;
    }
    public void setDx(int dx){
        this.dx = dx;
    }
    public int getDy(){
        return dy;
    }
    public void setDy(int dy){
        this.dy = dy;
    }
    public int getRadius(){
        return radius;
    }





}
