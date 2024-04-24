import javax.swing.*;
import java.awt.*;

public class AirHockeyViewer extends JFrame {
    public static final int WINDOW_WIDTH = 900;
    public static final int WINDOW_HEIGHT = 500;
    public static final int TITLE_BAR_HEIGHT = 39;
    private AirHockey game;
    final private String title = "AirHockey";
    private Image airHockeyBackground;
    public AirHockeyViewer(AirHockey g){
        // Initialize Instance Variables
        game = g;
        this.airHockeyBackground = new ImageIcon("AirHockeyHBackground.jpg").getImage();
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
        // Draw background
        g.drawImage(airHockeyBackground, 0, 0, this);
        // Draw ball
        game.getBall().draw(g);
        game.getPaddleOne().draw(g);
    }
    public Image getAirHockeyBackground(){
        return airHockeyBackground;
    }
    public void setAirHockeyBackground(Image g){
        airHockeyBackground = g;
    }
}
