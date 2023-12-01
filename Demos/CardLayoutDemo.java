import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutDemo {
    
    CardLayoutDemo() {
        JFrame frame = new JFrame("Card Layout Demo");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel cards = new JPanel(new CardLayout());
        JPanel card1 = new JPanel();
        String buttons = "card with buttons";
        JPanel card2 = new JPanel();
        String text = "card with text";

        JButton jbtn1 = new JButton("btn 1");
        JButton jbtn2 = new JButton("btn 2");

        card1.add(jbtn1);
        card1.add(jbtn2);

        JLabel label = new JLabel("label text");
        JLabel label2 = new JLabel("label text 2");

        card2.add(label);
        card2.add(label2);

        cards.add(card1, buttons);
        cards.add(card2, text);

        String items[] = {"Panel 1", "Panel 2"};
        JComboBox jcb = new JComboBox(items);
        jcb.setEditable(false);

        JPanel cbPane = new JPanel();
        jcb.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.show(cards, (String) e.getItem());
            }
        });
        cbPane.add(jcb);

        frame.add(cbPane, BorderLayout.PAGE_START);
        frame.add(cards, BorderLayout.PAGE_END);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CardLayoutDemo();
            }
        });
    }
}
