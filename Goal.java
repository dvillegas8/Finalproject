import java.awt.*;

public class Goal {
    // Instance variable
    private int x;
    private int y;
    private int width;
    private int length;
    private Color color;
    // Constructor
    public Goal(int x, int y, int width, int length, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.color = color;
    }
    // Draw the goal onto the screen
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, length);
    }
    // Getters and Setters
    public int getWidth(){
        return width;
    }
    public int getLength(){
        return length;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
