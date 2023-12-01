import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;

public class TableDemo {
    
    TableDemo() {
        JFrame frame = new JFrame("Table Demo");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        //headers
        String headers[] = {"Artist", "Song", "Album", "Year"};
        Object data[][] = {
            {"Taylor Swift", "Picture to Burn", "Taylor Swift", "2005"},
            {"Weezer", "Holiday", "Weezer", "1994"},
            {"modernlove.", "Shades of Blue", "Shades of Blue", "2023"},
            {"The All-American Rejects", "Move Along", "Move Along", "2005"},
            {"Counting Crows", "Mr. Jones", "August And Everything After",
            "1993"},
            {"ABBA", "Angeleyes", "Voulez-Vous", "1979"},
            {"Kenny G", "Songbird", "Duotones", "1986"},
            {"Celine Dion", "The Power of Love", "The Color Of My Love",
            "1993"},
            {"Stromae", "Alors on danse", "Cheese", "2010"},
            {"Ed Sheeran", "Perfect", "%", "2017"},
            {"Aerosmith", "Walk This Way", "Toys In The Attic", "1975"}
            };
            
        JTable jtab = new JTable(data, headers);

        JScrollPane jsp = new JScrollPane(jtab);
        jtab.setGridColor(Color.blue);
        jtab.setShowGrid(false);
        jtab.setShowVerticalLines(true);
        jtab.setShowHorizontalLines(false);

        JLabel label = new JLabel("");
        JButton printTable = new JButton("Print");
        printTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    jtab.print();
                }
                catch(PrinterException exc) {
                    label.setText("print error");
                }
            }
        });

        frame.add(jsp);
        frame.add(printTable);
        frame.setVisible(true);
    }
    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TableDemo();
            }
        });
    }
}
