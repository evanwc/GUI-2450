import java.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class SliderDemo implements ChangeListener {
    JLabel labelH, labelV, label;

    SliderDemo() {
        JFrame frame = new JFrame("Slider Demo");
        frame.setSize(300, 350);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSlider jslide = new JSlider();
        JSlider jslide2 = new JSlider(JSlider.VERTICAL);

        jslide.setMajorTickSpacing(10);
        jslide2.setMajorTickSpacing(10);
        jslide2.setMinorTickSpacing(5);
        jslide.setPaintTicks(true);
        jslide2.setPaintTicks(true);
        jslide.createStandardLabels(10);
        jslide2.createStandardLabels(10);
        jslide.setPaintLabels(true);
        jslide2.setPaintLabels(true);

        labelH = new JLabel("Current horizontal value: " + jslide.getValue());
        labelV = new JLabel("Current vertical value " + jslide2.getValue());

        jslide.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                labelH.setText("Current horizontal value: " + jslide.getValue());
            }
        });

        jslide2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                labelV.setText("Current vertical value: " + jslide2.getValue());
            }
        });

        JLabel label = new JLabel("Evan Cheng 11/5/23");

        frame.add(label);
        frame.add(jslide);
        frame.add(jslide2);
        frame.add(labelH);
        frame.add(labelV);

        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SliderDemo();
            }
        });
    }
}
