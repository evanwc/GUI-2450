import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {
    
    BorderLayoutDemo() {
        JFrame frame = new JFrame("Border Layout Demo");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JButton button1 = new JButton("Button Start");
        JButton button2 = new JButton("Button Line Start");
        JButton button3 = new JButton("Button Line End");
        JLabel label = new JLabel("Label Center");
        JLabel label2 = new JLabel("Label Page End");

        frame.add(button1, BorderLayout.PAGE_START);
        frame.add(button2, BorderLayout.LINE_START);
        frame.add(button3, BorderLayout.LINE_END);
        frame.add(label, BorderLayout.CENTER);
        frame.add(label2, BorderLayout.PAGE_END);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BorderLayoutDemo();
            }
        });
    }
}
