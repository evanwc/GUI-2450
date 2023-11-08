import java.awt.*;
import java.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import java.awt.event.*;


public class ToggleButtonDemo implements ItemListener {
    JLabel jlab;
    JToggleButton jtb;

    ToggleButtonDemo() {
        //new jfrm
        JFrame jfrm = new JFrame("Toggle Button Demo");
        jfrm.setSize(300, 200);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLayout(new FlowLayout());

        //label
        jlab = new JLabel("Button is off");

        //toggle button
        jtb = new JToggleButton("On/Off");
        jtb.addItemListener(this);

        //add to content pane
        jfrm.getContentPane().add(jlab);
        jfrm.getContentPane().add(jtb);

        //display frame
        jfrm.setVisible(true);
    }
    
    public void itemStateChanged(ItemEvent ie) {
        if (jtb.isSelected())
            jlab.setText("Button is 'on'.");
        else
            jlab.setText("Button is 'off'.");
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ToggleButtonDemo();
            }
        });
    }
}
