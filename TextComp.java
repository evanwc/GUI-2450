import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.StyledDocument;
import javax.swing.text.Style;

public class TextComp {
    
    TextComp() {
        JFrame frame = new JFrame("Menu Demo");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane jtb = new JTabbedPane();

        JPanel tab1 = new JPanel();
        tab1.setLayout(new BoxLayout(tab1, BoxLayout.Y_AXIS));

        JLabel name = new JLabel("Evan Cheng 12/1/23");

        JLabel label1 = new JLabel("Knock Knock!");
        JTextField field1 = new JTextField(10);
        //columns 20 is overrided by box layout size

        JLabel label2 = new JLabel("Enter password:");
        JPasswordField field2 = new JPasswordField(10);

        JLabel label3 = new JLabel("Custom Date Format:");
        JFormattedTextField field3 = new JFormattedTextField(createFormatter("AAA-##-####"));

        field3.setColumns(10);

        JLabel label4 = new JLabel("Basic Text Area");
        JTextArea field4 = new JTextArea(3, 10);
        JScrollPane scroll = new JScrollPane(field4);

        tab1.add(name);
        tab1.add(label1);
        tab1.add(field1);
        tab1.add(label2);
        tab1.add(field2);
        tab1.add(label3);
        tab1.add(field3);
        tab1.add(label4);
        tab1.add(scroll);

        String shrek = "Text courtesy of Bing AI: Shrek is a 2001 American animated fantasy comedy film loosely based on the 1990 children's picture book of the same name by William Steig.\\nThe film follows the adventures of an embittered ogre named Shrek who finds his home in the swamp overrun by fairy tale creatures banished by the obsessive ruler Lord Farquaad.\\nWith the help of Donkey, Shrek makes a pact with Farquaad to rescue Princess Fiona in exchange for regaining control of his swamp.\\nThe film stars Mike Myers, Eddie Murphy, Cameron Diaz, and John Lithgow.\\nShrek parodies other fairy tale adaptations, primarily animated Disney films.\\nThe film won the first ever Academy Award for Best Animated Feature.\\nShrek has since spawned several sequels and spin-offs.\\nThe character of Shrek has become a cultural icon and has been referenced in numerous films, TV shows, and video games.\\nThe name \"Shrek\" is derived from the German word Schreck, meaning \"fright\" or \"terror\".\\nShrek is a beloved character that has captured the hearts of audiences around the world.";
        JTextPane tab2 = new JTextPane();
        StyledDocument doc = tab2.getStyledDocument();
        Style style = tab2.addStyle(shrek, null);

        JEditorPane tab3 = new JEditorPane();
        tab3.setPage("https://www.google.com/");

        jtb.addTab("Basic Components", tab1);
        jtb.addTab("Text Pane", tab2);
        jtb.addTab("Editor Pane", tab3);

        frame.add(jtb);
        frame.setVisible(true);
    }
    
    protected MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextComp();
            }
        });
    }

}
