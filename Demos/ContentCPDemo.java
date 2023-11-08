import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.BorderFactory.*;

public class ContentCPDemo {
    ContentCPDemo() {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create myContentPanel
        myContentPanel myCP = new myContentPanel();

        frame.setContentPane(myCP);

        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ContentCPDemo();
            }
        });
    }
}

class myContentPanel extends JPanel {
    myContentPanel() {
        //set opaque (true)
        setOpaque(true);
        //green border thickness 5
        setBorder(BorderFactory.createLineBorder(Color.green, 5));

        JLabel label = new JLabel("Pick a border color: ");
        JButton red = new JButton("red");
        JButton blue = new JButton("blue");

        red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getActionCommand().equals("red")) {
                    setBorder(BorderFactory.createLineBorder(Color.red, 5));
                }
            }
        });

        blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getActionCommand().equals("blue")) {
                    setBorder(BorderFactory.createLineBorder(Color.blue, 5));
                }
            }
        });

        add(label);
        add(red);
        add(blue);
    }
}