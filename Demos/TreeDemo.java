import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;

public class TreeDemo {
    
    TreeDemo() {
        JFrame frame = new JFrame("Tree Demo");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Foods");

        DefaultMutableTreeNode fruit = new DefaultMutableTreeNode("Fruits");
        DefaultMutableTreeNode veggie = new DefaultMutableTreeNode("Vegetables");

        DefaultMutableTreeNode apple = new DefaultMutableTreeNode("Apple");
        DefaultMutableTreeNode banana = new DefaultMutableTreeNode("Banana");
        DefaultMutableTreeNode cantaloupe = new DefaultMutableTreeNode("Cantaloupe");
        fruit.add(apple);
        fruit.add(banana);
        fruit.add(cantaloupe);

        DefaultMutableTreeNode rootVeggies = new DefaultMutableTreeNode("Root Vegetables");
        DefaultMutableTreeNode potato = new DefaultMutableTreeNode("Potato");
        DefaultMutableTreeNode sweet = new DefaultMutableTreeNode("Sweet Potato");
        DefaultMutableTreeNode yam = new DefaultMutableTreeNode("Yam");
        rootVeggies.add(potato);
        rootVeggies.add(sweet);
        rootVeggies.add(yam);

        DefaultMutableTreeNode leafs = new DefaultMutableTreeNode("Leafy Greens");
        DefaultMutableTreeNode lettuce = new DefaultMutableTreeNode("Lettuce");
        DefaultMutableTreeNode spinach = new DefaultMutableTreeNode("Spinach");
        leafs.add(lettuce);
        leafs.add(spinach);

        veggie.add(rootVeggies);
        veggie.add(leafs);

        root.add(fruit);
        root.add(veggie);

        JTree foodTree = new JTree(root);

        JLabel label = new JLabel();

        ImageIcon appleIcon = new ImageIcon("apple.jpg");
        ImageIcon bananaIcon = new ImageIcon("banana.jpg");
        ImageIcon cantaloupeIcon = new ImageIcon("cantaloupe.jpg");
        ImageIcon potatoIcon = new ImageIcon("potato.jpg");
        ImageIcon sweetIcon = new ImageIcon("sweet.jpg");
        ImageIcon yamIcon = new ImageIcon("yam.png");
        ImageIcon lettuceIcon = new ImageIcon("lettuce.jpg");
        ImageIcon spinachIcon = new ImageIcon("spinach.jpg");

        foodTree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) foodTree.getLastSelectedPathComponent();
                if (node == apple) label.setIcon(appleIcon);
                else if (node == banana) label.setIcon(bananaIcon);
                else if (node == cantaloupe) label.setIcon(cantaloupeIcon);
                else if (node == potato) label.setIcon(potatoIcon);
                else if (node == sweet) label.setIcon(sweetIcon);
                else if (node == yam) label.setIcon(yamIcon);
                else if (node == lettuce) label.setIcon(lettuceIcon);
                else label.setIcon(spinachIcon);
            }
        });

        JScrollPane pane = new JScrollPane(foodTree);
        pane.setPreferredSize(new Dimension(500, 100));

        JPanel pane2 = new JPanel();
        pane2.add(label);
        pane2.setPreferredSize(new Dimension(500, 200));
        
        frame.add(pane);
        frame.add(pane2);
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
