import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

public class MenuDemo {
    
    MenuDemo() {
        JFrame frame = new JFrame("Menu Demo");
        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //menu bar
        JMenuBar bar = new JMenuBar();

        //file menu
        JMenu file = new JMenu("File");

        //file menu items
        JMenuItem open = new JMenuItem("Open");
        JMenuItem close = new JMenuItem("Close");

        file.add(open);
        file.add(close);

        bar.add(file);

        frame.add(bar);
        frame.setVisible(true);
    }
    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuDemo();
            }
        });
    }
}
