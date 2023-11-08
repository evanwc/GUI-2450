import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SplitPane {
    SplitPane() {
        JFrame frame = new JFrame("Split Pane");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create new split pane
        JSplitPane pane = new JSplitPane();

        //create 2 panels
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        //create labels for each panel
        JLabel leftLabel = new JLabel("<html>Evan Cheng 11/12/23<br>this is left pane");
        JLabel rightLabel = new JLabel("this is right pane");

        JButton red = new JButton("red");
        JButton yellow = new JButton("yellow");
        JButton cyan = new JButton("cyan");

        red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getActionCommand().equals("red")) rightPanel.setBackground(Color.red);
            }
        });

        yellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getActionCommand().equals("yellow")) rightPanel.setBackground(Color.yellow);
            }
        });

        cyan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getActionCommand().equals("cyan")) rightPanel.setBackground(Color.cyan);
            }
        });

        //add labels to panels
        leftPanel.add(leftLabel);
        leftPanel.add(red);
        leftPanel.add(yellow);
        leftPanel.add(cyan);
        rightPanel.add(rightLabel);

        pane.setLeftComponent(leftPanel);
        pane.setRightComponent(rightPanel);

        frame.add(pane);
        frame.setVisible(true);

    }
    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SplitPane();
            }
        });
    }
}