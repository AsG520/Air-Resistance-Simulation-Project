
// import properties
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AirResistance {
    // window properties
    static int WIDTH_WINDOW = 500; // width of the window screen
    static int HEIGHT_WINDOW = 500; // height of the window screen
    static double vy = 5; // Vertical velocity direction for the ball

    // floor properties
    static int WIDTH_FLOOR = 500; // width of the floor
    static int HEIGHT_FLOOR = 35; // height of the floor
    static int X_POSITION_FLOOR = 0; // x-position of the floor
    static int Y_POSITION_FLOOR = 430; // y-position of the floor
    static int TIMER_DELAY = 10; // interval duration of the timer (s)

    // color properties
    static int R_VALUE = 0; // r value of RGB
    static int G_VALUE = 0; // g value of RGB
    static int B_VALUE = 0; // b value of RGB

    // ball properties
    static double P = 1.225; // air density
    static double MASS = 0.5; // mass of the ball
    static double CD = 0.47; // drag coefficient
    static double dx = 190.0; // x-position of the ball
    static double dy = 10.0; // y-position of the ball
    static int WIDTH_BALL = 100; // width of the ball
    static int HEIGHT_BALL = 100; // height of the ball
    static double RADIUS_BALL = WIDTH_BALL / 2; // radius of the ball
    static double CROSS_SECTIONAL_AREA = Math.PI * (RADIUS_BALL * RADIUS_BALL); // area of the circle
    static double COR = 0.8; // coefficient of restitution for the ball

    // double Fd = 0.5 * P * (vy * vy) * CD * CROSS_SECTIONAL_AREA; // formula to
    // calculate the force of drag

    public static void main(String[] args) {
        JFrame frame = new JFrame("Air Resistance Simulation"); // title of the window
        frame.setSize(WIDTH_WINDOW, HEIGHT_WINDOW); // intalizing windows, width and length value
        frame.setResizable(false); // cannot resize the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows user to exit, when clicking the 'x' button at
                                                              // the top right of the window
        frame.setLayout(null); // no layout of the window

        ImageIcon ballIcon = new ImageIcon("ball.png"); // creating an ImageIcon for the ball
        JLabel ball = new JLabel(ballIcon); // creating a JLabel for the ball
        ball.setBounds((int) dx, (int) dy, WIDTH_BALL, HEIGHT_BALL); // setting the x-position, y-position, width, and
                                                                     // height of the ball

        JLabel floor = new JLabel(); // creating a JLabel for the floor
        floor.setOpaque(true); // allows the floor to be visible
        floor.setBackground(new Color(R_VALUE, G_VALUE, B_VALUE)); // black color to the floor (0, 0, 0)
        floor.setBounds(X_POSITION_FLOOR, Y_POSITION_FLOOR, WIDTH_FLOOR, HEIGHT_FLOOR); // setting the x-position,
                                                                                        // y-position, width, and height
                                                                                        // of the floor

        frame.add(ball); // adding ball to the window
        frame.add(floor); // adding floor to the window

        frame.setBackground(Color.black); // background color of the window
        frame.setVisible(true); // allows user to see the overall window

        Timer timer = new Timer(TIMER_DELAY, new ActionListener() { // declaration of the timer for animation
            public void actionPerformed(ActionEvent e) {
                if (dy > 322) { // collision contact between the base of the ball and the floor
                    vy = -vy * COR; // reverses the vertical direction of the ball movement
                    // 20% of useful energy and 80% of wasted energy
                }

                dy += vy; // applying gravity to the ball, resulting it to fall down towards the floor
                ball.setLocation((int) dx, (int) dy); // updating the position of the ball after implementing the effect
                                                      // of gravity
            }
        });
        timer.start(); // starts the timer for the animation
    }
}