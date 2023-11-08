import java.awt.*;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import java.io.File;

public class ImageDemo {
    JLabel image, text, left, top;
    JButton button;

    ImageDemo() {
        //make frame and layout
        JFrame frame = new JFrame("Images and Labels");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        //make and align labels/buttons, add icons
        ImageIcon icon = new ImageIcon("/Users/topev/Documents/molangpeach.jpg");
        image = new JLabel(icon);
        text = new JLabel("Molang!", icon, SwingConstants.CENTER);
        left = new JLabel("Molang!", icon, SwingConstants.LEFT);
        left.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        top = new JLabel("Molang!", icon, SwingConstants.CENTER);
        top.setHorizontalTextPosition(JLabel.CENTER);
        top.setVerticalTextPosition(JLabel.TOP);
        button = new JButton(icon);

        //add labels
        frame.add(image);
        frame.add(text);
        frame.add(left);
        frame.add(top);
        frame.add(button);
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageDemo();
            }
        });
    }
}
