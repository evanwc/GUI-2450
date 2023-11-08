import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;

public class TabbedPaneDemo {
    TabbedPaneDemo() {
        JFrame frame = new JFrame("Tabbed Pane Demo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create tabbed pane
        JTabbedPane pane = new JTabbedPane();

        //create 3 JPanels
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        //first tab: list of top-level containers
        JLabel label1 = new JLabel("<htmL>Evan Cheng 11/12/23<br>Top Level Containers: "
            + "<br>JFrame"
            + "<br>JApplet"
            + "<br>JDialog"
            + "<br>JWindow");
        
        //second tab: different buttons and BoundedRangeModelItems
        JCheckBox checkbox = new JCheckBox("slider enabled");
        JSlider slider = new JSlider();
        slider.setEnabled(false);
        JButton button = new JButton("Hover over me");
        button.setToolTipText("This is a tooltip!");
            //add item listener to checkbox
            checkbox.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent event) {
                    if(checkbox.isSelected()) slider.setEnabled(true);
                    else slider.setEnabled(false);
                }
            });

        //third tab: list of other containers (panels/panes)
        JLabel label3 = new JLabel("<html>Other Containers:<br>JPanel<br>JScrollPane<br>JTabbedPane");

        //add components to JPanels
        panel1.add(label1);
        panel2.add(checkbox);
        panel2.add(slider);
        panel2.add(button);
        panel3.add(label3);

        //add JPanels as tabs to JTabbedPane
        //pane.addTab("First", panel1);
        pane.addTab("First", null, panel1, "top-level containers");
        pane.addTab("Second", panel2);
        pane.addTab("Third", panel3);

        frame.add(pane);

        frame.setVisible(true);
    }
    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TabbedPaneDemo();
            }
        });
    }
}
