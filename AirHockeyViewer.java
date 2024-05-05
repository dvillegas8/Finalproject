import javax.swing.*;
import java.awt.*;

public class AirHockeyViewer extends JFrame {
    public static final int WINDOW_WIDTH = 900;
    public static final int WINDOW_HEIGHT = 500;
    public static final int TITLE_BAR_HEIGHT = 24;
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
        // Draw both paddles
        game.getPaddleOne().draw(g);
        game.getPaddleTwo().draw(g);
        // draw contact point as circle
        if(game.getPaddleOne().isContact(game.getBall().getX(), game.getBall().getY(), game.getBall().getRadius())){
            g.setColor(Color.YELLOW);
            g.fillOval((int) (game.getContactX() - 2.5), (int) (game.getContactY() - 2.5), 5, 5);
        }
    }
    public Image getAirHockeyBackground(){
        return airHockeyBackground;
    }
    public void setAirHockeyBackground(Image g){
        airHockeyBackground = g;
    }
}
