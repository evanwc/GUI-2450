import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ThreeLayout {
    
    ThreeLayout() {
        JFrame frame = new JFrame("Three Layouts");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel cards = new JPanel(new CardLayout());

        JPanel panel1 = new JPanel();
        String p1 = "Card 1";
        JButton btn1 = new JButton("This is a CardLayout.");
        JButton btn2 = new JButton("Evan Cheng 12/2/2023");
        panel1.add(btn1);
        panel1.add(btn2);
        
        JPanel panel2 = new JPanel();
        String p2 = "Card 2";
        JLabel jlab1 = new JLabel("This is a CardLayout. ");
        JLabel jlab2 = new JLabel("Evan Cheng 12/2/2023");
        panel2.add(jlab1);
        panel2.add(jlab2);

        cards.add(panel1, p1);
        cards.add(panel2, p2);

        String items[] = {"Card 1", "Card 2"};
        JComboBox jcb = new JComboBox(items);
        jcb.setEditable(false);

        JPanel cbPane = new JPanel();
        jcb.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                CardLayout cl = (CardLayout) cards.getLayout();
                if(e.getItem().toString().equals("Card 1")) {
                    cl.show(cards, p1);
                }
                if(e.getItem().toString().equals("Card 2")) {
                    cl.show(cards, p2);
                }
            }
        });
        cbPane.add(jcb);
        cbPane.add(cards);

        JPanel border = new JPanel();
        border.setLayout(new BorderLayout());

        JButton button1 = new JButton("This is a BorderLayout.");
        JButton button2 = new JButton("Button Line Start");
        JButton button3 = new JButton("Button Line End");
        JLabel label3 = new JLabel("Label Center");
        JLabel label4 = new JLabel("Label Page End");

        border.add(button1, BorderLayout.PAGE_START);
        border.add(button2, BorderLayout.LINE_START);
        border.add(button3, BorderLayout.LINE_END);
        border.add(label3, BorderLayout.CENTER);
        border.add(label4, BorderLayout.PAGE_END);


        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));

        JLabel label5 = new JLabel("This is a BoxLayout.");
        JButton button = new JButton("This is a button.");
        JTextField field = new JTextField(20);
        JButton button4 = new JButton("This is another button.");

        box.add(label5);
        box.add(button);
        box.add(field);
        box.add(button4);

        JTabbedPane tab = new JTabbedPane();

        tab.addTab("Card Pane", cbPane);
        tab.addTab("Border Pane", border);
        tab.addTab("Box Pane", box);
        frame.add(tab);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ThreeLayout();
            }
        });
    }
}
