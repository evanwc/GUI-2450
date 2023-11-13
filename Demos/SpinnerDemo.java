import java.awt.*;
import java.swing.*;
import java.util.concurrent.Flow;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;

public class SpinnerDemo {
    String colors[] = {"blue", "green", "red", "white", "teal", "black"};
    JSpinner colorSpinner, numSpinner;
    JLabel lab1, lab2;
    JPanel pane;
    
    SpinnerDemo() {
        JFrame frame = new JFrame("Spinners");
        frame.setSize(450, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        pane = new JPanel();
        pane.setLayout(new FlowLayout());

        lab1 = new JLabel("Select a color: ");
        lab2 = new JLabel("Select a border size: ");

        SpinnerListModel model = new SpinnerListModel(colors);
        colorSpinner = new JSpinner(model);
        colorSpinner.setPreferredSize(new Dimension(60, 20));

        colorSpinner.addChangeListener(new ChangeListener() {
            public void stateChagned(ChangeEvent e) {
                String colorChoice = (String) colorSpinner.getValue();
                lab1.setText("Color selected: " + colorChoice);
                if (colorChoice.equals("blue")) pane.setBackground(Color.blue);
                else if (colorChoice.equals("green")) pane.setBackground(Color.green);
                else if (colorChoice.equals("red")) pane.setBackground(Color.red);
                else if (colorChoice.equals("white")) pane.setBackground(Color.white);
                else if (colorChoice.equals("teal")) pane.setBackground(Color.teal);
                else if (colorChoice.equals("black")) pane.setBackground(Color.black);
            }
        });

        SpinnerNumberModel model2 = new SpinnerNumberModel(1, 1, 10, 1);

        pane.add(lab1);
        pane.add(colorSpinner);

        frame.add(pane);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SpinnerDemo();
            }
        });
    }
}
