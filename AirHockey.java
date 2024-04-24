import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AirHockey implements ActionListener, KeyListener {
    private int oneScore;
    private int twoScore;
    private Paddle one;
    private Paddle two;
    private Ball ball;
    private static final int SLEEP_TIME = 100;
    private AirHockeyViewer window;
    public AirHockey(){
        // Initialize instance variables
        oneScore = 0;
        twoScore = 0;
        one = new Paddle(225, 250, 5, 5, 20, Color.RED);
        two = new Paddle(675, 250, 5, 5, 20, Color.BLUE);
        ball = new Ball(400, 200, 15, 15, 10, Color.BLACK);
        window = new AirHockeyViewer(this);
    }
    // Method for movement of the paddles
    public void keyTyped(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            // Move right for paddle one
            case KeyEvent.VK_D:
                    one.setX(one.getX() + one.getDX());
            // Move left for paddle one
            case KeyEvent.VK_A:
                    one.setX(one.getX() - one.getDX());
            // Move up for paddle one
            case KeyEvent.VK_W:
                    one.setY(one.getY() - one.getDY());
            // Move down for paddle one
            case KeyEvent.VK_S:
                    one.setY(one.getY() + one.getDY());
        }
    }
    // Runs this method of 100 milliseconds to check if the ball needs to bounce
    public void actionPerformed(ActionEvent e) {
        ball.move();
        ball.bounce();
        window.repaint();
    }
    public void game(){
        window.repaint();
    }
    public static void main(String[] args) {
        AirHockey game = new AirHockey();
        Timer clock = new Timer(SLEEP_TIME, game);
        clock.start();
        game.game();
    }
    public Ball getBall(){
        return ball;
    }
    public void setBall(Ball ball){
        this.ball = ball;
    }
    public Paddle getPaddleOne(){
        return one;
    }
    public void setPaddleOne(Paddle one){
        this.one = one;
    }
}
