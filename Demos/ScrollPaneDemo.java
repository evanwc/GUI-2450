import java.awt.*;
import javax.swing.*;

public class ScrollPaneDemo {
    ScrollPaneDemo() {
        JFrame frame = new JFrame("Scroll Pane Demo");
        frame.setSize(200, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("/Users/topev/Documents/molangpeach.jpg");

        JLabel label = new JLabel("<html>Evan Cheng 11/12/23<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text"
        + "<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text"
        + "<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text<br>Any text", icon, SwingConstants.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        JScrollPane pane = new JScrollPane(label, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(pane);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ScrollPaneDemo();
            }
        });
    }
}
