
// import properties
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// public class
public class AirResistance {
    // window properties
    static int WIDTH_WINDOW = 500; // width of the window screen
    static int HEIGHT_WINDOW = 500; // height of the window screen
    static JFrame frame; // window for the simulation
    static ImageIcon ballIcon; // icon for the ball
    static JLabel ball, floor; // ball and floor for the simulation
    static Timer timer; // timer for the animation

    // floor properties
    static int WIDTH_FLOOR = 500; // width of the floor
    static int HEIGHT_FLOOR = 35; // height of the floor
    static int X_POSITION_FLOOR = 0; // x-position of the floor
    static int Y_POSITION_FLOOR = 430; // y-position of the floor
    static int TIMER_DELAY = 10; // interval duration of the timer (s)

    // color properties
    static int[] BLACK_COLOR = { 0, 0, 0 }; // r = 0, g = 0, b = 0 makes the color black
    static int[] WHITE_COLOR = { 255, 255, 255 }; // r = 255, g = 255, b = 255 makes the color white

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
    static double COR = 0.6; // coefficient of restitution for the ball
    static double vy = 0.0; // velocity in the vertical direction for the ball
    static double vx = 0.0; // velocity in the horizontal direction for the ball
    static double GRAVITY = 0.2; // gravitational constant for the simulation

    // physics properties
    static double Fg = GRAVITY * MASS; // force of gravity acting on the ball
    static double Fapp = 0.010; // applied force acting on the ball

    static double FdY = 0.0; // initializating the drag force variable for vertical direction
    static double FdX = 0.0; // initializating the drag force variable for horizontal direction

    static double fnetX = Fapp - FdX; // force in the horizontal direction
    static double fnetY = Fg - FdY; // force in the vertical direction

    static double ay = fnetY / MASS; // newton 2nd law, to calculate acceleration in the vertical direction (ay)
    static double ax = fnetX / MASS; // newton 2nd law, to calculate acceleration in the horizontal direction (ax)

    // main method
    public static void main(String[] args) {
        frame = new JFrame("Air Resistance Simulation"); // title of the window
        frame.setSize(WIDTH_WINDOW, HEIGHT_WINDOW); // intalizing windows, width and length value
        frame.setResizable(false); // cannot resize the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows user to exit, when clicking the 'x' button at
                                                              // the top right of the window
        frame.setLayout(null); // no layout of the window

        ballIcon = new ImageIcon("ball.png"); // creating an ImageIcon for the ball
        ball = new JLabel(ballIcon); // creating a JLabel for the ball
        ball.setBounds((int) dx, (int) dy, WIDTH_BALL, HEIGHT_BALL); // setting the x-position, y-position, width, and
                                                                     // height of the ball

        floor = new JLabel(); // creating a JLabel for the floor
        floor.setOpaque(true); // allows the floor to be visible
        floor.setBackground(new Color(WHITE_COLOR[0], WHITE_COLOR[1], WHITE_COLOR[2])); // black color to the floor (0,
                                                                                        // 0, 0)
        floor.setBounds(X_POSITION_FLOOR, Y_POSITION_FLOOR, WIDTH_FLOOR, HEIGHT_FLOOR); // setting the x-position,
                                                                                        // y-position, width, and height
                                                                                        // of the floor

        frame.add(ball); // adding ball to the window
        frame.add(floor); // adding floor to the window

        frame.getContentPane().setBackground(new Color(BLACK_COLOR[0], BLACK_COLOR[1], BLACK_COLOR[2])); // background
                                                                                                         // color of the
                                                                                                         // window
        frame.setVisible(true); // allows user to see the overall window

        timer = new Timer(TIMER_DELAY, new ActionListener() { // declaration of the timer for animation
            public void actionPerformed(ActionEvent e) { // public void actionPerformed method
                if (dy > 328) { // collision contact between the base of the ball and the floor
                    vy = -vy * COR; // reverses the vertical direction of the ball movement
                    // 20% of useful energy and 80% of wasted energys
                    dy = 328; // keeps the ball base on top of the floor, prevents from sinking
                    // vy = 0; // ball at rest
                }

                vx += ax; // updates velocity with accleration (ax) in the horizontal direction
                dx += vx; // updates distance in the horizontal direction using the velocity (vx)

                vy += ay; // updates velocity with accleration (ay) in the vertical direction
                dy += vy; // updates distance in the vertical direction using the velocity (vy)

                FdY = 0.5 * P * CD * CROSS_SECTIONAL_AREA * vy * Math.abs(vy); // formula to calculate the force of drag
                                                                               // in the vertical direction
                FdX = 0.5 * P * CD * CROSS_SECTIONAL_AREA * vx + Math.abs(vx); // formula to calculate the force of drag
                                                                               // in the horizontal direction

                ball.setLocation((int) dx, (int) dy); // updating the position of the ball after implementing the effect
                                                      // of gravity
            }
        });
        timer.start(); // starts the timer for the animation
    }
}