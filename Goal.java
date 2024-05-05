import java.awt.*;

public class Goal {
    private int x;
    private int y;
    private int width;
    private int length;
    private Color color;
    public Goal(int x, int y, int width, int length, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.color = color;
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, length);
    }
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
