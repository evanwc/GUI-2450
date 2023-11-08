import java.awt.*;
import java.swing.*;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import java.awt.event.*;

public class RBDemo implements ActionListener {
    JLabel jlabOptions;
    JLabel jlabWhat;
    JCheckBox jcbOptions;
    JRadioButton jrbSpeed;
    JRadioButton jrbSize;
    JRadioButton jrbDebug;
    RBDemo() {
        JFrame jfrm = new JFrame("RB Demo");
        jfrm.setSize(300, 200);
        jfrm.getContentPane().setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlabOptions = new JLabel("Choose an option: ");
        jlabWhat = new JLabel("Option selected: Speed");

        jcbOptions = new JCheckBox("Enable Options");

        jrbSpeed = new JRadioButton("Speed", true); //setting to true as default selection
        jrbSize = new JRadioButton("Size");
        jrbDebug = new JRadioButton("Debug");

        ButtonGroup rbOptions = new ButtonGroup();
        rbOptions.add(jrbSpeed);
        rbOptions.add(jrbSize);
        rbOptions.add(jrbDebug);

        jrbSpeed.setEnabled(false);
        jrbSize.setEnabled(false);
        jrbDebug.setEnabled(false);

        jcbOptions.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                if (jcbOptions.isSelected()) {
                    jrbSpeed.setEnabled(true);
                    jrbSize.setEnabled(true);
                    jrbDebug.setEnabled(true);
                }
                else {
                    jrbSpeed.setEnabled(false);
                    jrbSize.setEnabled(false);
                    jrbDebug.setEnabled(false);
                }
            }
        });

        jrbSpeed.addActionListener(this);
        jrbSize.addActionListener(this);
        jrbDebug.addActionListener(this);

        jfrm.getContentPane().add(jlabOptions);
        jfrm.getContentPane().add(jcbOptions);
        jfrm.getContentPane().add(jrbSpeed);
        jfrm.getContentPane().add(jrbSize);
        jfrm.getContentPane().add(jrbDebug);
        jfrm.getContentPane().add(jlabWhat);

        jfrm.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (jrbSpeed.isSelected()) jlabWhat.setText("Option selected: Speed");
        else if (jrbSize.isSelected()) jlabWhat.setText("Option selected: Size");
        else jlabWhat.setText("Option selected: Debug");
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RBDemo();
            }
        });
    }
}