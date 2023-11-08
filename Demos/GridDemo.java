import java.awt.*;
import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.JFrame;

public class GridDemo {
    JLabel tleft, tcenter, tright, cleft, ccenter, cright, bleft, bcenter, bright;

    GridDemo() {
        //make frame and layout
        JFrame frame = new JFrame("Horizontal and Vertical Alignment");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(3, 3);
        grid.setHgap(5);
        grid.setVgap(5);
        frame.setLayout(grid);

        //make and align labels, add border
        Border simple = BorderFactory.createLineBorder(Color.black);
        tleft = new JLabel("Top Left", SwingConstants.LEFT);
        tcenter = new JLabel("Top Center", SwingConstants.CENTER);
        tright = new JLabel("Top Right", SwingConstants.RIGHT);
        cleft = new JLabel("Center Left", SwingConstants.LEFT);
        ccenter = new JLabel("Center Center", SwingConstants.CENTER);
        cright = new JLabel("Center Right", SwingConstants.RIGHT);
        bleft = new JLabel("Bottom Left", SwingConstants.LEFT);
        bcenter = new JLabel("Bottom Center", SwingConstants.CENTER);
        bright = new JLabel("Bottom Right", SwingConstants.RIGHT);
        tleft.setBorder(simple);
        tcenter.setBorder(simple);
        tright.setBorder(simple);
        cleft.setBorder(simple);
        ccenter.setBorder(simple);
        cright.setBorder(simple);
        bleft.setBorder(simple);
        bcenter.setBorder(simple);
        bright.setBorder(simple);
        tleft.setVerticalAlignment(SwingConstants.TOP);
        tcenter.setVerticalAlignment(SwingConstants.TOP);
        tright.setVerticalAlignment(SwingConstants.TOP);
        bleft.setVerticalAlignment(SwingConstants.BOTTOM);
        bcenter.setVerticalAlignment(SwingConstants.BOTTOM);
        bright.setVerticalAlignment(SwingConstants.BOTTOM);


        //add labels
        frame.add(tleft);
        frame.add(tcenter);
        frame.add(tright);
        frame.add(cleft);
        frame.add(ccenter);
        frame.add(cright);
        frame.add(bleft);
        frame.add(bcenter);
        frame.add(bright);
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GridDemo();
            }
        });
    }
}
