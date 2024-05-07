import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

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
        this.airHockeyBackground = new ImageIcon("AirHockeyTable.jpg").getImage();
        // Initialize window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(title);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        createBufferStrategy(2);
    }
    public void paint(Graphics g) {
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;
        Graphics g2 = null;
        try {
            g2 = bf.getDrawGraphics();
            myPaint(g2);
        }
        finally {
            g2.dispose();
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();
    }
    public void myPaint(Graphics g){
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
        // Draw Goals
        game.getLeftGoal().draw(g);
        game.getRightGoal().draw(g);
        // draw contact point for paddle one
        if(game.getPaddleOne().isContact(game.getBall().getX(), game.getBall().getY(), game.getBall().getRadius())){
            g.setColor(Color.YELLOW);
            System.out.println(game.getContactX(game.getPaddleOne()));
            System.out.println(game.getContactY(game.getPaddleOne()));
            g.fillOval((int) (game.getContactX(game.getPaddleOne()) - 2.5), (int) (game.getContactY(game.getPaddleOne()) - 2.5), 5, 5);
        }
        // Draw contact point for paddle two
        if(game.getPaddleTwo().isContact(game.getBall().getX(), game.getBall().getY(), game.getBall().getRadius())){
            g.setColor(Color.YELLOW);
            g.fillOval((int) (game.getContactX(game.getPaddleTwo()) - 2.5), (int) (game.getContactY(game.getPaddleTwo()) - 2.5), 5, 5);
        }
    }
    // Getter and Setters
    public Image getAirHockeyBackground(){
        return airHockeyBackground;
    }
    public void setAirHockeyBackground(Image g){
        airHockeyBackground = g;
    }
}
