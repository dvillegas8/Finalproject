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
    private Goal leftgoal;
    private Goal rightgoal;
    private static final int SLEEP_TIME = 100;
    private AirHockeyViewer window;
    public AirHockey(){
        // Initialize instance variables
        oneScore = 0;
        twoScore = 0;
        one = new Paddle(220, 240, 20, 20, 20, Color.RED);
        two = new Paddle(680, 240, 20, 20, 20, Color.BLUE);
        ball = new Ball(400, 200, 10, 10, 10, Color.WHITE);
        leftgoal = new Goal(0, 175, 5, 165, Color.WHITE);
        rightgoal = new Goal(AirHockeyViewer.WINDOW_WIDTH - 5, 177, 5, 165, Color.WHITE);
        window = new AirHockeyViewer(this);
        window.addKeyListener(this);
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
                one.moveRight();
                break;
            // Move left for paddle one
            case KeyEvent.VK_A:
                one.moveLeft();
                break;
            // Move up for paddle one
            case KeyEvent.VK_W:
                one.moveUp();
                break;
            // Move down for paddle one
            case KeyEvent.VK_S:
                one.moveDown();
                break;
            // Move right for paddle two
            case KeyEvent.VK_RIGHT:
                two.moveRight();
                break;
            // Move left for paddle two
            case KeyEvent.VK_LEFT:
                two.moveLeft();
                break;
            // Move up for paddle two
            case KeyEvent.VK_UP:
                two.moveUp();
                break;
            // Move down for paddle two
            case KeyEvent.VK_DOWN:
                two.moveDown();
                break;
        }
    }
    // Runs this method of 100 milliseconds to check if the ball needs to bounce
    public void actionPerformed(ActionEvent e) {
        ball.move();
        ball.bounce();
        if(one.isContact(ball.getX(), ball.getY(), ball.getRadius())){
            System.out.println("hit");
        }
        if(two.isContact(ball.getX(), ball.getY(), ball.getRadius())){
            System.out.println("hit");
        }
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
    // finds collision point x coordinate
    public float getContactX(){
        float x = (float) ((one.getRadius() * ball.getX()) + (ball.getRadius() * one.getX())) / (ball.getRadius() + one.getRadius());
        return x;
    }
    // finds collision point y coordinate
    public float getContactY(){
        float y = (float) ((one.getRadius() * ball.getY()) + (ball.getRadius() * one.getY())) / (ball.getRadius() + one.getRadius());
        return y;
    }
    public void newDX(){
        double velocity = Math.sqrt((ball.getDX() * ball.getDX()) + (ball.getDY() * ball.getDY()));
        double angle = Math.atan((double) ball.getDY() / ball.getDX());

    }
    // Checks if a goal is scored
    public boolean isGoal(){
        if(ball.getX() - ball.getDX() <= leftgoal.getWidth() && ball.getY() >= leftgoal.getY() && ball.getY() <= leftgoal.getLength() + leftgoal.getY()){
            twoScore += 1;
            return true;
        }
        else if(ball.getX() + ball.getRadius() >= rightgoal.getX() && ball.getY() >= rightgoal.getY() && ball.getY() <= rightgoal.getY() + rightgoal.getLength()){
            oneScore += 1;
            return true;
        }
        return false;
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
    public Paddle getPaddleTwo(){
        return two;
    }
    public void setPaddleTwo(Paddle two){
        this.two = two;
    }
    public Goal getLeftGoal(){
        return leftgoal;
    }
    public Goal getRightGoal(){
        return rightgoal;
    }
}
