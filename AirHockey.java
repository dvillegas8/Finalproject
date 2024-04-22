import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AirHockey implements ActionListener {
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
        one = new Paddle(0, 0, 0, 0, 0, 0);
        two = new Paddle(0, 0, 0, 0, 0, 0);
        ball = new Ball(400, 200, 20, 20, 10, Color.BLACK);
        window = new AirHockeyViewer(this);
    }
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
}
