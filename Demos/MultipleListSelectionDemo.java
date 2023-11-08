import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MultipleListSelectionDemo implements ListSelectionListener {
    JList fruitList;
    String fruit[] = {"apple", "banana", "tomato", "grapes"};
    JLabel purchasedFruit;

    MultipleListSelectionDemo() {
        JFrame frame = new JFrame("List Demo");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        fruitList = new JList(fruit);

        //convention to wrap in scroll pane
        JScrollPane pane = new JScrollPane(fruitList);

        fruitList.addListSelectionListener(this);

        purchasedFruit = new JLabel("Select fruits: ");

        frame.add(purchasedFruit);
        frame.add(pane);

        frame.setVisible(true);
    }

    public void valueChanged(ListSelectionEvent event) {
        int indices[] = fruitList.getSelectedIndices();
        String output = "";

        if (indices.length == 0) purchasedFruit.setText("Please select multiple fruits.");
        
        for (int i = 0; i < indices.length; i++) {
            output += fruit[indices[i]] + "<br>";
        }

        purchasedFruit.setText("<html>Current selection: <br>" + output);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MultipleListSelectionDemo();
            }
        });
    }
}