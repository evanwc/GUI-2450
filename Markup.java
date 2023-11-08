import java.swing.*;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;

public class Markup implements ActionListener {
    JLabel prompt;
    JTextField cost;
    JTextField markup;
    JButton calc;
    JLabel out;
        
    Markup() {
        //make frame
        JFrame frame = new JFrame("Markup Application");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        //make prompt
        prompt = new JLabel("Please enter wholesale price and markup percentage: ");

        //make text fields
        cost = new JTextField("Wholesale price ($)", 15);
        markup = new JTextField("Markup percentage (%)",15);
        cost.addActionListener(this);
        markup.addActionListener(this);

        //make button
        calc = new JButton("Calculate retail price");
        calc.addActionListener(this);

        //make output label
        out = new JLabel("");

        //add components + make visible
        frame.add(prompt);
        frame.add(cost);
        frame.add(markup);
        frame.add(calc);
        frame.add(out);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String pattern = "#.00";
        DecimalFormat dformat = new DecimalFormat(pattern);
        if (event.getActionCommand().equals("Calculate retail price")) {
            double c = Double.parseDouble(cost.getText());
            double m = Double.parseDouble(markup.getText());
            out.setText("The retail price is: $" + dformat.format(c * (m / 100d + 1)));
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Markup();
            }
        });
    }
}