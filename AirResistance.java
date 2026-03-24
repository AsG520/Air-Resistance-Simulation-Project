import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JLabel;

public class AirResistance {
    public static void main(String[] args) {
        ImageIcon ballIcon = new ImageIcon("ball.png");
        JLabel ball = new JLabel(ballIcon);
        JFrame frame = new JFrame("Air Resistance Simulation");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(ball);
    }
}