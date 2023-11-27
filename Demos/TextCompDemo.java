import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuDemo2 {
    
    MenuDemo2() {
        JFrame frame = new JFrame("Menu Demo");
        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane jtb = new JTabbedPane();

        JPanel tab1 = new JPanel();
        tab1.setLayout(new BoxLayout(tab1, BoxLayout.Y_AXIS));

        JLabel name = new JLabel("Evan Cheng 12/1/23");

        JLabel label1 = new JLabel("Knock Knock!");
        JTextField field1 = new JTextField(20);
        //columns 20 is overrided by box layout size

        JLabel label2 = new JLabel("Enter password:");
        JPasswordField field2 = new JPasswordField(20);

        JLabel label3 = new JLabel("Custom Date Format:");
        JFormattedTextField field3 = new JFormattedTextField();

        JLabel label4 = new JLabel("Basic Text Area");
        JTextArea field4 = new JTextArea();

        tab1.add(name);
        tab1.add(label1);
        tab1.add(field1);
        tab1.add(label2);
        tab1.add(field2);
        tab1.add(label3);
        tab1.add(field3);
        
        
        jtb.addTab("My Info", myPanel);

        frame.add(jtb);
        frame.setVisible(true);
    }
    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuDemo2();
            }
        });
    }

}
