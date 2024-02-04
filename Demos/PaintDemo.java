import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class PaintPanel extends JPanel {
    Insets ins; //hold panel insets
    Random rand; //generate random numbers

    PaintPanel(int w, int h) {
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.red));
        setPreferredSize(new Dimension(w, h));
        rand = new Random();
    }

    protected void paintComponent(Graphics g) {
        //superclass method
        super.paintComponent(g);

        int height = getHeight();
        int width = getWidth();

        ins = getInsets();

        //fill panel, plot random data as bar graph
        for (int i = ins.left + 5; i <= width - ins.right - 5; i += 4) {
            //random number to bw 0 and max height of drawing area
            int h = rand.nextInt(height - ins.bottom);

            //change value to just outside the border if too close
            if (h <= ins.top) h = ins.top + 1;

            //draw the line
            g.drawLine(i, height - ins.bottom, i, h);
        }
    }

    public void changeBorderSize(int size) {
        setBorder(BorderFactory.createLineBorder(Color.red, size));
    }
}


public class PaintDemo {
    JButton more, size;
    JLabel lab;
    PaintPanel pp;
    boolean big;

    PaintDemo() {
        JFrame frame = new JFrame("Paint Demo 1");
        frame.setSize(240, 360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        pp = new PaintPanel(100, 100);

        more = new JButton("Show More Data");
        size = new JButton("Change Border Size");

        lab = new JLabel("Bar Graph of Random Data");

        more.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pp.repaint();
            }
        });

        size.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!big) pp.changeBorderSize(5);
                else pp.changeBorderSize(1);
                big = !big;
            }
        });

        frame.add(lab);
        frame.add(pp);
        frame.add(more);
        frame.add(size);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaintDemo();
            }
        });
    }
    
}
