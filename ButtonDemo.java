import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ButtonDemo implements ActionListener {
    JLabel jlab;
    ButtonDemo() {
        //create a new JFrame container
        JFrame jfrm = new JFrame("ButtonDemo");

        //flow layout for layout manager
        jfrm.getContentPane().setLayout(new FlowLayout());

        //Give the frame an initial size
        jfrm.setSize(300,200);

        //Terminate program when user closes applications
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create label
        jlab = new JLabel("Press this button");

        //add label to content pane
        jfrm.getContentPane().add(jlab);

        //create button
        JButton jbtn1 = new JButton("yes");
        JButton jbtn2 = new JButton("no");

        //add action listener
        jbtn1.addActionListener(this);
        jbtn2.addActionListener(this);
        
        jfrm.getContentPane().add(jbtn1);
        jfrm.getContentPane().add(jbtn2);

        //display frame
        jfrm.setVisible(true);
    }
    //handle action event (for when the button is pressed)
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("yes"))
            jlab.setText("Yes was pressed");
        else 
            jlab.setText("No was pressed");
    }
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ButtonDemo();
            }
        });
    }
}