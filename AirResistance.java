import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AirResistance {
    // window properties
    static int WIDTH_WINDOW = 500; // width of the window screen
    static int HEIGHT_WINDOW = 500; // height of the window screen
    static double G = 9.8; // gravitational constant on earth

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
    // double P = 1.225; // air density
    // double MASS = 0.5; // mass of the ball
    // double RADIU = BALL_WIDTH / 2; // radius of the ball
    // double CROSS_SECTIONAL_AREA; // cross sectional area of the ball
    // double CD = 0.47; // drag coefficient
    // double VY = 0.0; // velocity of the ball in y-direction
    static double dx = 190.0; // x-position of the ball
    static double dy = 10.0; // y-position of the ball
    static int WIDTH_BALL = 100; // width of the ball
    static int HEIGHT_BAll = 100; // height of the ball

    public static void main(String[] args) {
        JFrame frame = new JFrame("Air Resistance Simulation");
        frame.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        ImageIcon ballIcon = new ImageIcon("ball.png");
        JLabel ball = new JLabel(ballIcon);
        ball.setBounds((int) dx, (int) dy, WIDTH_BALL, HEIGHT_BAll);

        JLabel floor = new JLabel();
        floor.setOpaque(true);
        floor.setBackground(new Color(R_VALUE, G_VALUE, B_VALUE));
        floor.setBounds(X_POSITION_FLOOR, Y_POSITION_FLOOR, WIDTH_FLOOR, HEIGHT_FLOOR);

        frame.add(ball);
        frame.add(floor);

        frame.setBackground(Color.black);
        frame.setVisible(true);

        Timer timer = new Timer(TIMER_DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dy += G;
                ball.setLocation((int) dx, (int) dy);
            }
        });
        timer.start();
    }
}