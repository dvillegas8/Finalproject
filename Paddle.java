import java.awt.*;

public class Paddle{
    // Location of the paddle
    private int x;
    private int y;
    // how much the paddle is going to be moving
    private int dx;
    private int dy;
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
    public void setY(int Y){
        this.y = y;
    }
    public int getDX(){
        return dx;
    }
    public void setDX(int dx){
        this.dx = dx;
    }
    public int getDY(){
        return dy;
    }
    public void setDY(int dy){
        this.dy = dy;
    }
}
