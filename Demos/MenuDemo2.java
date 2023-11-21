import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuDemo2 {
    
    MenuDemo2() {
        JFrame frame = new JFrame("Menu Demo");
        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane jtb = new JTabbedPane();

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("First Field: ");
        JTextField field1 = new JTextField(20);
        //columns 20 is overrided by box layout size

        JLabel label2 = new JLabel("Second Field: ");
        JTextField field2 = new JTextField(20);

        myPanel.add(label1);
        myPanel.add(field1);
        myPanel.add(label2);
        myPanel.add(field2);
        
        jtb.addTab("My Info", myPanel);

        JMenuBar jmb = new JMenuBar();

        JMenu jmFile = new JMenu("File");

        JMenuItem addNewTab = new JMenuItem("Add Tab");
        addNewTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel defaultPanel = new JPanel();
                defaultPanel.setLayout(new BoxLayout(defaultPanel, BoxLayout.Y_AXIS));
                
                JLabel defaultLabel = new JLabel("Default Text: ");
                JTextArea defaultTextArea = new JTextArea(10, 30);
                defaultPanel.add(defaultLabel);
                defaultPanel.add(defaultTextArea);

                jtb.insertTab("Tab " + jtb.getTabCount(), null, defaultPanel, null, 0);
            }
        });

        JMenuItem removeExistingTab = new JMenuItem("Remove Tab");

        jmFile.add(addNewTab);
        jmFile.add(removeExistingTab);

        jmb.add(jmFile);

        frame.add(jmb);
        frame.add(jtb);
        frame.setVisible(true);
    }
    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuDemo2();
            }
        });
    }

}
