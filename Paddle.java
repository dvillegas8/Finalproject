public class Paddle {
    // Location of the paddle
    private int x;
    private int y;
    // how much the paddle is going to be moving
    private int dx;
    private int dy;
    // dimensions of the paddle
    private int length;
    private int width;
    public Paddle(int x, int y, int dx, int dy, int length, int width){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.length = length;
        this.width = width;
    }
}
