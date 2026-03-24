import javax.swing.*;
import java.awt.Color;

public class AirResistance {
    public static void main(String[] args) {
        // double G = 9.8; // gravitational constant on earth
        // double P = 1.225; // air density
        // double MASS = 0.5; // mass of the ball
        // double RADIUS = 0.1; // radius of the ball
        // double CROSS_SECTIONAL_AREA = 0.0314; // cross sectional area of the ball
        // double CD = 0.47; // drag coefficient
        // double HI = 20.0; // initial height of the ball
        // double VI = 0.0; // initial velocity of the ball

        int WIDTH_BALL = 100;
        int HEIGHT_BALL = 100;

        JFrame frame = new JFrame("Air Resistance Simulation");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        ImageIcon ballIcon = new ImageIcon("ball.png");
        JLabel ball = new JLabel(ballIcon);
        ball.setBounds(190, 10, WIDTH_BALL, HEIGHT_BALL);

        JLabel floor = new JLabel();
        floor.setOpaque(true);
        floor.setBackground(new Color(0, 0, 0));
        floor.setBounds(0, 430, 500, 35);

        frame.add(ball);
        frame.add(floor);

        frame.setVisible(true);
    }
}