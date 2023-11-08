import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.*;

public class ListDemo implements ListSelectionListener {
    JList fruitList;
    String fruit[] = {"apple", "banana", "tomato", "grapes"};
    JLabel purchasedFruit;

    ListDemo() {
        JFrame frame = new JFrame("List Demo");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        fruitList = new JList(fruit);

        //convention to wrap in scroll pane
        JScrollPane pane = new JScrollPane(fruitList);

        fruitList.addListSelectionListener(this);

        purchasedFruit = new JLabel("Select a fruit: ");

        frame.add(purchasedFruit);
        frame.add(pane);

        frame.setVisible(true);
    }

    public void valueChanged(ListSelectionEvent event) {
        int index = fruitList.getSelectedIndex();

        if (index != -1) {
            purchasedFruit.setText("Selected fruit: " + fruit[index]);
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListDemo();
            }
        });
    }
}
