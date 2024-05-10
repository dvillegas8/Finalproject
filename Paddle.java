import java.awt.*;

public class Paddle{
    // Location of the paddle
    private int x;
    private int y;
    // how much the paddle is going to be moving
    private double dx;
    private double dy;
    // dimensions of the paddle
    private int radius;
    private Color color;
    public Paddle(int x, int y, int dx, int dy, int radius, Color color){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.color = color;
    }
    // Movement methods for paddles, checks if it goes outside the window first
    public void moveUp() {
        if (y - radius >= AirHockeyViewer.TITLE_BAR_HEIGHT) {
            y -= dy;
        }
    }
    public void moveDown(){
        if (y + (2 * radius) <= AirHockeyViewer.WINDOW_HEIGHT) {
            y += dy;
        }
    }
    public void moveRight(){
        if(x + (2 * radius) <= AirHockeyViewer.WINDOW_WIDTH){
            x += dx;
        }
    }
    public void moveLeft(){
        if(x - (2 * radius) >= 0){
            x -= dx;
        }
    }
    // Returns true if the paddle comes into contact with the ball
    public boolean isContact(int x, int y, int radius){
        double dx = (x - this.x) * (x - this.x);
        double dy = (y - this.y) * (y - this.y);
        return Math.sqrt(dx + dy) <= this.radius + radius;
    }
    public void draw(Graphics g){
        // Draw paddle
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
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
    public int getDX(){
        return (int)(dx + 0.5);
    }
    public void setDX(double dx){
        this.dx = dx;
    }
    public int getDY(){
        return (int) (dy + 0.5);
    }
    public void setDY(int dy){
        this.dy = dy;
    }
    public int getRadius(){
        return radius;
    }
}
