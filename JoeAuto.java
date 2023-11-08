import java.swing.*;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;

public class JoeAuto implements ActionListener {
    JCheckBox oil, lube, radiator, transmission, inspec, muffler, tire;
    JTextField other;
    JLabel hours, total;
    JButton calc;

    JoeAuto() {
        //new frame
        JFrame frame = new JFrame("Joe's Automotive");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        
        //add checkboxes
        oil = new JCheckBox("Oil change $36.00");
        lube = new JCheckBox("Lube job $18.00");
        radiator = new JCheckBox("Radiator flush $30.00");
        transmission = new JCheckBox("Transmission flush $80.00");
        inspec = new JCheckBox("Inspection $15.00");
        muffler = new JCheckBox("Muffler replacement $100.00");
        tire = new JCheckBox("Tire rotation $20.00");

        //add label + textfields + button
        hours = new JLabel("How many hours on non-routine services?");
        other = new JTextField(15);
        total = new JLabel("");
        calc = new JButton("Calculate total");
        calc.addActionListener(this);

        //add components
        frame.add(oil);
        frame.add(lube);
        frame.add(radiator);
        frame.add(transmission);
        frame.add(inspec);
        frame.add(muffler);
        frame.add(tire);
        frame.add(hours);
        frame.add(other);
        frame.add(calc);
        frame.add(total);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String pattern = "#.00";
        DecimalFormat dformat = new DecimalFormat(pattern);
        double subtotal = 0;
        if (event.getActionCommand().equals("Calculate total")) {
            if (oil.isSelected()) subtotal += 36;
            if (lube.isSelected()) subtotal += 18;
            if (radiator.isSelected()) subtotal += 30;
            if (transmission.isSelected()) subtotal += 80;
            if (inspec.isSelected()) subtotal += 15;
            if (muffler.isSelected()) subtotal += 100;
            if (tire.isSelected())  subtotal += 20;
            if (!other.getText().isEmpty()) total.setText("Total = $" + dformat.format(subtotal + (Double.parseDouble(other.getText()) * 20)));
            else total.setText("Total = $" + dformat.format(subtotal));
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JoeAuto();
            }
        });
    }
}