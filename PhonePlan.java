import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PhonePlan implements ItemListener {
    JLabel label, total;
    JComboBox packages, phone;
    JCheckBox voicemail, text;
    
    PhonePlan() {
        JFrame frame = new JFrame("Phone Plan");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        label = new JLabel("Please select the purchased items (each phone model will have 6% tax added):");
        total = new JLabel("");

        String[] packageList = {"300 minutes per month: $45.00 per month",
            "800 minutes per month: $65.00 per month",
            "1500 minutes per month: $99.00 per month"};
        String[] phoneList = {"Model 100: $29.95 plus tax",
            "Model 110: $49.95 plus tax",
            "Model 200: $99.95 plus tax"};

        voicemail = new JCheckBox("Voice mail: $5.00 per month");
        text = new JCheckBox("Text messaging: $10.00 per month");
        
        packages = new JComboBox<String>(packageList);
        phone = new JComboBox<String>(phoneList);

        packages.addItemListener(this);
        phone.addItemListener(this);
        voicemail.addItemListener(this);
        text.addItemListener(this);

        frame.add(label);
        frame.add(packages);
        frame.add(phone);
        frame.add(voicemail);
        frame.add(text);
        frame.add(total);
        frame.setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        int monthly = 0;
        double phoneTotal = 0;
        int i = packages.getSelectedIndex();
        int l = phone.getSelectedIndex();
        switch (i) {
            case 0: 
                monthly += 45;
                break;
            case 1: 
                monthly += 65;
                break;
            case 2: 
                monthly += 99;
                break;
        }
        switch (l) {
            case 0: 
                phoneTotal += 31.75;
                break;
            case 1: 
                phoneTotal += 52.95;
                break;
            case 2: 
                phoneTotal += 105.95;
                break;
        }
        if (voicemail.isSelected()) monthly += 5;
        if (text.isSelected()) monthly += 10;
        //"Monthly total: $" + monthly + ".00 Phone total: $" + String.valueOf(total));
        total.setText("Monthly total: $" + monthly + ".00 Phone total: $" + String.valueOf(phoneTotal));
        
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PhonePlan();
            }
        });
    }
}
