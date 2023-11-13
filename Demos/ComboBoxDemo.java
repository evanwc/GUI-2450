import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import java.awt.event.*;
import java.util.concurrent.Flow;

public class ComboBoxDemo {
    ComboBoxDemo() {
        JFrame frame = new JFrame("Combo Box");
        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Please make a selection.");

        DefaultComboBoxModel fruitCBM = new DefaultComboBoxModel();
        fruitCBM.addElement("apple");
        fruitCBM.addElement("banana");
        fruitCBM.addElement("cantaloupe");

        JComboBox fruit = new JComboBox(fruitCBM);
        fruit.setEditable(true);

        fruit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String item = (String)fruit.getSelectedItem();
                label.setText("Current selection: " + item);

                int i;
                for (i = 0; i < fruit.getItemCount(); i++) {
                    if (item.equals(fruit.getItemAt(i))) break;
                }
                if(i == fruit.getItemCount()) fruit.addItem(item);
            }
        });

        JButton remove = new JButton("Remove Item");
        
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String item = (String)fruit.getSelectedItem();
                for (int i = 0; i < fruit.getItemCount(); i++) {
                    if (item.equals(fruit.getItemAt(i))) fruit.removeItem(item);
                }
                label.setText("Removed: " + item);
            }
        });

        JLabel label2 = new JLabel("List Data Event Stuff");
        fruitCBM.addListDataListener(new ListDataListener() {
            public void contentsChanged(ListDataEvent event) {
                label2.setText("There was a content change!");
            }
            public void intervalAdded(ListDataEvent event) {
                label2.setText("There was an element added!");
            }
            public void intervalRemoved(ListDataEvent event) {
                label2.setText("There was an element removed!");
            }
        });

        frame.add(fruit);
        frame.add(remove);
        frame.add(label);
        frame.add(label2);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxDemo();
            }
        });
    }
}
