import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class TreeDemo {
    
    TreeDemo() {
        JFrame frame = new JFrame("Tree Demo");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Foods");

        DefaultMutableTreeNode fruit = new DefaultMutableTreeNode("Fruits");
        DefaultMutableTreeNode veggie = new DefaultMutableTreeNode("Vegetables");

        root.add(fruit);
        root.add(veggie);

        DefaultMutableTreeNode apple = new DefaultMutableTreeNode("Apple");
        fruit.add(apple);

        DefaultMutableTreeNode rootVeggies = new DefaultMutableTreeNode("Root Vegetables");
        veggie.add(rootVeggies);
        rootVeggies.add(new DefaultMutableTreeNode("Potato"));

        JTree foodTree = new JTree(root);

        JScrollPane pane = new JScrollPane();
        pane.setPreferredSize(new Dimension(350, 275));
        pane.add(foodTree);
        
        frame.add(pane);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TreeDemo();
            }
        });
    }
}
