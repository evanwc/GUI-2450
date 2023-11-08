import java.awt.*;
import java.swing.*;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import java.awt.event.*;

public class RadioButtonDemo implements ActionListener {
    JRadioButton jrb1;
    JRadioButton jrb2;
    JRadioButton jrb3;
    JLabel userSelected = new JLabel("");

    RadioButtonDemo() {
        //jfrm
        JFrame jfrm = new JFrame("Radio Button Demo");
        jfrm.setSize(300, 200);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLayout(new FlowLayout());

        //radio buttons
        jrb1 = new JRadioButton("option 1");
        jrb2 = new JRadioButton("option 2");
        jrb3 = new JRadioButton("option 3");

        //add buttons to ButtonGroup for mutual exclusive
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        
        //add action listneres
        jrb1.addActionListener(this);
        jrb2.addActionListener(this);
        jrb3.addActionListener(this);

        jfrm.getContentPane().add(userSelected);
        jfrm.getContentPane().add(jrb1);
        jfrm.getContentPane().add(jrb2);
        jfrm.getContentPane().add(jrb3);

        jfrm.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String userOption = "";
        if (jrb1.isSelected()) userOption = "first option!";
        else if (jrb2.isSelected()) userOption = "second option!";
        else userOption = "third option!";

        userSelected.setText("You selected the " + userOption);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RadioButtonDemo();
            }
        });
    }
}
