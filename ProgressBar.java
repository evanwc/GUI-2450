import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ProgressBar implements ActionListener {
    JLabel label, percent;
    JButton press, reset;
    JProgressBar bar;

    ProgressBar() {
        JFrame frame = new JFrame("Progress Bar");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        label = new JLabel("Evan Cheng 11/5/23");
        percent = new JLabel("Current Percentage: 0");

        press = new JButton("Press Me!");
        reset = new JButton("Reset");
        press.addActionListener(this);
        reset.addActionListener(this);
        reset.setEnabled(false);

        bar = new JProgressBar(0, 100);
        bar.setValue(0);

        frame.add(label);
        frame.add(bar);
        frame.add(press);
        frame.add(reset);
        frame.add(percent);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Press Me!")) {
            bar.setValue(bar.getValue() + 10);
            percent.setText("Current Percentage: " + bar.getValue());
            if (bar.getValue() == 100) {
                reset.setEnabled(true);
                press.setEnabled(false);
            }
        }
        else {
            bar.setValue(0);
            percent.setText("Current Percentage: 0");
            reset.setEnabled(false);
            press.setEnabled(true);
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProgressBar();
            }
        });
    }
}