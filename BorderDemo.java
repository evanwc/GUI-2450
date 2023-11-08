import java.awt.*;
import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.JFrame;

public class BorderDemo {
    JLabel simple;
    JLabel etched;
    JLabel empty;
    JLabel raisedBevel;
    JLabel loweredBevel;
    BorderDemo() {
        JFrame jfrm = new JFrame("Border Demo");
        jfrm.setSize(250, 200);
        jfrm.getContentPane().setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //make each border
        Border simpleBorder = BorderFactory.createLineBorder(Color.red);
        simple = new JLabel("This is a simple border");
        simple.setBorder(simpleBorder);

        Border etchedBorder = BorderFactory.createEtchedBorder();
        etched = new JLabel("This is an etched border");
        etched.setBorder(etchedBorder);

        Border emptyBorder = BorderFactory.createEmptyBorder();
        empty = new JLabel("This is an empty border");
        empty.setBorder(emptyBorder);

        Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
        raisedBevel = new JLabel("This is a raised bevel border");
        raisedBevel.setBorder(raisedBevelBorder);

        Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
        loweredBevel = new JLabel("This is a lowered border");
        loweredBevel.setBorder(loweredBevelBorder);

        jfrm.add(simple);
        jfrm.add(etched);
        jfrm.add(empty);
        jfrm.add(raisedBevel);
        jfrm.add(loweredBevel);

        jfrm.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BorderDemo();
            }
        });
    }
}
