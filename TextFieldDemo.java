import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldDemo implements ActionListener {
    JLabel jlab;
    jTextField jtf;

    TextFieldDemo() {
        // create jfrm
        JFrame jfrm = new JFrame("TextFieldDemo");
        jfrm.getContentPane().setLayout(new FlowLayout());
        jfrm.setSize(300, 200);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a label for text field
        jlab = new JLabel("User Input: ");
        jfrm.getContentPane().add(jlab);

        // create a text field
        jtf = new jTextField(15);
        // add actionListener
        jtf.addActionListener(this);
         // add to content pane
        jfrm.getContentPane.add(jtf);
        // display the jfrm
        jfrm.setVisible(true);
    }

    // event handler
    public void actionPerformed(ActionEvent ae) {
        // get curent text and set to label
        jlab.setText("Current contents of text field: " + jtf.getText());
    }

    // run on event dispatching thread
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextFieldDemo();
            }
        });
    }
}