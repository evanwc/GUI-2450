import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Journal {
    
    Journal() {
        JFrame frame = new JFrame("Menu Demo");
        frame.setSize(450, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane jtb = new JTabbedPane();
        jtb.setPreferredSize(new Dimension(400, 300));
        jtb.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        JPanel myInfo = new JPanel();
        myInfo.setLayout(new BoxLayout(myInfo, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("Name: ");
        JTextField field1 = new JTextField(20);
        field1.setEditable(false);

        JLabel label2 = new JLabel("Address: ");
        JTextField field2 = new JTextField(20);
        field2.setEditable(false);

        JLabel label3 = new JLabel("Notes: ");
        JTextField field3 = new JTextField(20);

        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Save")) {
                    field1.setEditable(false);
                    field2.setEditable(false);
                }
            }
        });

        myInfo.add(label1);
        myInfo.add(field1);
        myInfo.add(label2);
        myInfo.add(field2);
        myInfo.add(label3);
        myInfo.add(field3);
        myInfo.add(save);
        jtb.addTab("My Info", myInfo);

        JMenuBar jmb = new JMenuBar();

        JMenu info = new JMenu("Manage MyInfo");

        JMenuItem editName = new JMenuItem("Edit Name");
        editName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                field1.setEditable(true);
            }
        });

        JMenuItem editAdd = new JMenuItem("Edit Address");
        editAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                field2.setEditable(true);
            }
        });

        info.add(editName);
        info.add(editAdd);



        JMenu menu = new JMenu("Manage Entries");

        DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd YYYY"); 
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");

        JMenuItem newDay = new JMenuItem("New Day");
        newDay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel defaultPanel = new JPanel();
                defaultPanel.setLayout(new BoxLayout(defaultPanel, BoxLayout.Y_AXIS));
                LocalDate today = LocalDate.now();
                jtb.insertTab(date.format(today), null, defaultPanel, null, jtb.getTabCount() - 1);
            }
        });

        JMenuItem newEntry = new JMenuItem("New Entry");
        newEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jtb.getSelectedIndex() != jtb.getTabCount() - 1) {
                    JPanel defaultPanel = (JPanel) jtb.getSelectedComponent();;
                    LocalTime today = LocalTime.now();
                    JLabel prompt = new JLabel("Time: " + time.format(today));
                    JTextArea textarea = new JTextArea(3, 20);
                    JScrollPane scroll = new JScrollPane(textarea);
                    defaultPanel.add(prompt);
                    defaultPanel.add(scroll);              
                }  
            }
        });

        JMenuItem remove = new JMenuItem("Remove Day");
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jtb.getSelectedIndex() != jtb.getTabCount() - 1) jtb.remove(jtb.getSelectedIndex());
            }
        });

        menu.add(newDay);
        menu.add(newEntry);
        menu.addSeparator();
        menu.add(remove);



        jmb.add(menu);
        jmb.add(info);

        frame.add(jmb);
        frame.add(jtb);
        frame.setVisible(true);
    }
    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Journal();
            }
        });
    }

}
