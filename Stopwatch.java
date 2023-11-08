import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Stopwatch implements ActionListener {
    JLabel jlab;
    long time;

    Stopwatch() {
        //create a new JFrame container
        JFrame jfrm = new JFrame("A Simple Stopwatch");

        //flow layout for layout manager
        jfrm.getContentPane().setLayout(new FlowLayout());

        //give the frame an initial size
        jfrm.setSize(250,125);

        //terminate program when user closes applications
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create button
        JButton jbtn1 = new JButton("Start");
        JButton jbtn2 = new JButton("Stop");

        //add action listener
        jbtn1.addActionListener(this);
        jbtn2.addActionListener(this);
        
        jfrm.getContentPane().add(jbtn1);
        jfrm.getContentPane().add(jbtn2);

        jlab = new JLabel("Press 'Start' when ready.");
        jfrm.getContentPane().add(jlab);

        //display frame
        jfrm.setVisible(true);
    }

    //handle action event (for when the button is pressed)
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Start")) {
            time = System.currentTimeMillis();
        }
        else if (time != 0 && ae.getActionCommand().equals("Stop")) {
            jlab.setText(System.currentTimeMillis() - time + "");
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Stopwatch();
            }
        });
    }
}