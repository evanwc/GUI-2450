import java.swing.*;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;

public class Conference implements ActionListener {
    JCheckBox general, student, dinner, intro, future, java, network;
    JLabel total;
    JButton calc;

    Conference() {
        //new frame
        JFrame frame = new JFrame("Conference Registration");
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        
        //add checkboxes
        general = new JCheckBox("General Conference Fee - $895");
        student = new JCheckBox("Student Conference Fee - $495");
        dinner = new JCheckBox("Opening Night Dinner and Keynote Speech - $30");
        intro = new JCheckBox("Introduction to E-Commerce - $295");
        future = new JCheckBox("The Future of the Web - $295");
        java = new JCheckBox("Advanced Java Programming - $395");
        network = new JCheckBox("Network Security - $395");

        //add button
        total = new JLabel("");
        calc = new JButton("Calculate total");
        calc.addActionListener(this);

        //add components
        frame.add(general);
        frame.add(student);
        frame.add(dinner);
        frame.add(intro);
        frame.add(future);
        frame.add(java);
        frame.add(network);
        frame.add(calc);
        frame.add(total);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String pattern = "#.00";
        DecimalFormat dformat = new DecimalFormat(pattern);
        double subtotal = 0;
        if (event.getActionCommand().equals("Calculate total")) {
            if (general.isSelected()) subtotal += 895;
            if (student.isSelected()) subtotal += 495;
            if (dinner.isSelected()) subtotal += 30;
            if (intro.isSelected()) subtotal += 295;
            if (future.isSelected()) subtotal += 295;
            if (java.isSelected()) subtotal += 395;
            if (network.isSelected())  subtotal += 395;
            else total.setText("Total = $" + dformat.format(subtotal));
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Conference();
            }
        });
    }
}