import java.awt.*;
import java.swing.*;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.event.*;

public class CheckBoxDemo implements ItemListener {
    JCheckBox jcb;
    JLabel jlab;

    CheckBoxDemo() {
        //new jfrm
        JFrame jfrm = new JFrame("Check Box Demo");
        jfrm.setSize(300,200);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLayout(new FlowLayout());

        //new jlab
        jlab = new JLabel("Check box is not checked");
        
        //new jcb
        jcb = new JCheckBox("Checkbox");
        jcb.addItemListener(this);

        jfrm.getContentPane().add(jlab);
        jfrm.getContentPane().add(jcb);

        jfrm.setVisible(true);
    }

    public void itemStateChanged(ItemEvent ie) {
        if (jcb.isSelected()) jlab.setText("Check box is checked");
        else jlab.setText("Check box is not checked");
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CheckBoxDemo();
            }
        });
    }
}