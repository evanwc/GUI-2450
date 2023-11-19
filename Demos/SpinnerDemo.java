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
import javax.swing.BorderFactory;
import java.awt.event.*;

public class SpinnerDemo {
    String colors[] = {"blue", "green", "red", "white", "teal", "black"};
    JSpinner colorSpinner, numSpinner;
    JLabel lab1, lab2;
    JPanel pane;
    Color myBlue = new Color(134, 171, 226);
    Color myGreen = new Color(134, 226, 137);
    Color myRed = new Color(226, 134, 134);
    Color myWhite = new Color(255, 254, 252);
    Color myTeal = new Color(105, 230,209);
    Color myBlack = new Color(5, 5, 5);
    
    SpinnerDemo() {
        JFrame frame = new JFrame("Spinners");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        pane = new JPanel();
        pane.setLayout(new FlowLayout());

        JLabel name = new JLabel("Evan Cheng 11/19/23");
        lab1 = new JLabel("Select a color: ");
        lab2 = new JLabel("Select a border size: ");

        SpinnerListModel model = new SpinnerListModel(colors);
        colorSpinner = new JSpinner(model);
        colorSpinner.setPreferredSize(new Dimension(60, 25));

        colorSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                String colorChoice = (String)colorSpinner.getValue();
                lab1.setText("Color selected: " + colorChoice);
                if (colorChoice.equals("blue")) pane.setBackground(myBlue);
                else if (colorChoice.equals("green")) pane.setBackground(myGreen);
                else if (colorChoice.equals("red")) pane.setBackground(myRed);
                else if (colorChoice.equals("white")) pane.setBackground(myWhite);
                else if (colorChoice.equals("teal")) pane.setBackground(myTeal);
                else if (colorChoice.equals("black")) pane.setBackground(myBlack);
            }
        });

        pane.add(lab1);
        pane.add(colorSpinner);

        SpinnerNumberModel model2 = new SpinnerNumberModel(1, 1, 10, 1);
        numSpinner = new JSpinner(model2);
        numSpinner.setPreferredSize(new Dimension(60, 25));

        numSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int i = (Integer)numSpinner.getValue();
                lab2.setText("Border size: " + i);
                pane.setBorder(BorderFactory.createLineBorder(Color.black, i));
            }
        });

        pane.add(lab2);
        pane.add(numSpinner);

        frame.add(name);
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
