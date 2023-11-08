import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;

public class ImageButton implements ActionListener {
    JLabel prompt;
    JButton shrek, fiona, donkey;

    ImageButton() {
        //make frame and layout
        JFrame frame = new JFrame("Images and Labels");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        //make and align labels/buttons, add icons
        ImageIcon shrekIcon = new ImageIcon("/Users/topev/Documents/shrek.png");
        ImageIcon fionaIcon = new ImageIcon("/Users/topev/Documents/fiona.png");
        ImageIcon donkeyIcon = new ImageIcon("/Users/topev/Documents/donkey.png");
        prompt = new JLabel("Select a character to see their quote!");
        shrek = new JButton("Shrek", shrekIcon);
        fiona = new JButton("Fiona", fionaIcon);
        donkey = new JButton("Donkey", donkeyIcon);

        //add labels
        frame.add(prompt);
        frame.add(shrek);
        frame.add(fiona);
        frame.add(donkey);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Shrek")) prompt.setText("Onions have layers...");
        else if (event.getActionCommand().equals("Fiona")) prompt.setText("You didn't slay the dragon?!");
        else prompt.setText("I like that boulder that's a nice boulder.");
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageButton();
            }
        });
    }
}
