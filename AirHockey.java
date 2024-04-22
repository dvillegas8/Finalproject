import java.awt.*;

public class AirHockey {
    private int oneScore;
    private int twoScore;
    private Paddle one;
    private Paddle two;
    private Ball ball;
    private AirHockeyViewer window;
    public AirHockey(){
        // Initialize instance variables
        oneScore = 0;
        twoScore = 0;
        one = new Paddle(0, 0, 0, 0, 0, 0);
        two = new Paddle(0, 0, 0, 0, 0, 0);
        ball = new Ball(400, 200, 5, 5, 10, Color.BLACK);
        window = new AirHockeyViewer(this, ball);
    }
    public void game(){
        window.repaint();
    }
    public static void main(String[] args) {
        AirHockey game = new AirHockey();
        game.game();
    }
}
