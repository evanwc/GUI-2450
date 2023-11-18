import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListModelDemo {
    JList fruit;
    JLabel name, label;
    JButton buy, manage;

    ListModelDemo() {
        JFrame frame = new JFrame("Default List Model Demo");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        DefaultListModel<String> model = new DefaultListModel<String>();
        model.addElement("blueberry");
        model.addElement("peach");
        model.addElement("cherry");
        model.addElement("pear");
        
        fruit = new JList(model);
        
        JScrollPane fruitScroll = new JScrollPane(fruit);

        name = new JLabel("Evan Cheng 11/19/23");
        label = new JLabel("Select a fruit: ");

        fruit.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                String selected = "";

                List<String> values = fruit.getSelectedValuesList();

                if (values.size() == 0) label.setText("Please make a selection.");
                else {
                    for (int i = 0; i < values.size(); i++) {
                        selected += values.get(i) + "<br>";
                    }
                    label.setText("<html>You selected: <br>" + selected);
                }
            }
        });

        buy = new JButton("Buy Fruit");
        buy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String purchased = "";

                List<String> values = fruit.getSelectedValuesList();

                if (values.size() == 0) label.setText("No fruit selected for purchase.");
                else {
                    for (int i = 0; i < values.size(); i++) {
                        purchased += values.get(i) + "<br>";
                    }
                    label.setText("<html>You purchased: <br>" + purchased);
                }
            }
        });

        manage = new JButton("Add Fruit");
        manage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DefaultListModel<String> reference = (DefaultListModel<String>) fruit.getModel();

                if (reference.getSize() > 4) {
                    for (int i = 6; i > 3; i--) {
                        reference.remove(i);
                        manage.setText("Add Fruit");
                    }
                }
                else {
                    reference.addElement("banana");
                    reference.addElement("strawberry");
                    reference.addElement("lemon");

                    manage.setText("Remove Extra Fruit");
                }
            }
        });

        frame.add(name);
        frame.add(fruitScroll);
        frame.add(label);
        frame.add(buy);
        frame.add(manage);
        frame.setVisible(true);
    }


    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListModelDemo();
            }
        });
    }
}
