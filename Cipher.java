import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.StringBuilder.*;

public class Cipher implements ActionListener {
    //declare containers and components
    JFrame frame;
    JLabel label1;
    JTextField plain;
    JLabel label2;
    JTextField cipher;
    JButton encode;
    JButton decode;
    JButton reset;
    JLabel answer;

    Cipher() {
        //basic frame creation
        frame = new JFrame("Simple Cipher");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //make first label + text field
        label1 = new JLabel("Plain text: ", SwingConstants.CENTER);
        plain = new JTextField(15);
        plain.addActionListener(this);
        frame.getContentPane().add(label1);
        frame.getContentPane().add(plain);

        //make second label + text field
        label2 = new JLabel("Cipher text: ", SwingConstants.CENTER);
        cipher = new JTextField(15);
        cipher.addActionListener(this);
        frame.getContentPane().add(label2);
        frame.getContentPane().add(cipher);

        //make buttons
        encode = new JButton("Encode");
        decode = new JButton("Decode");
        reset = new JButton("Reset");
        encode.addActionListener(this);
        decode.addActionListener(this);
        reset.addActionListener(this);
        frame.getContentPane().add(encode);
        frame.getContentPane().add(decode);
        frame.getContentPane().add(reset);

        //make last label
        answer = new JLabel("", SwingConstants.CENTER);
        frame.getContentPane().add(answer);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        StringBuilder build = new StringBuilder();
        String output;
        //when encode button is pressed, output encoded message
        if (event.getActionCommand().equals("Encode")) {
            String original = plain.getText();
            for (int i = 0; i < original.length(); i++) {
                if (original.charAt(i) == ' ') build.append(' ');
                else if (Character.isUpperCase(original.charAt(i))) {
                    char ch = (char)(((int)original.charAt(i) - 64) % 26 + 65);
                    build.append(ch);
                }
                else {
                    char ch = (char)(((int)original.charAt(i) - 96) % 26 + 97);
                    build.append(ch);
                }
            }
            output = build.toString();
            answer.setText(output);
        }
        //when decode button is pressed, output decoded message
        else if (event.getActionCommand().equals("Decode")) {
            String original = cipher.getText();
            for (int i = 0; i < original.length(); i++) {
                if (original.charAt(i) == ' ') build.append(' ');
                else if (Character.isUpperCase(original.charAt(i))) {
                    char ch = (char)(((int)original.charAt(i) + 64) % 26 + 65);
                    build.append(ch);
                }
                else {
                    char ch = (char)(((int)original.charAt(i) - 97) % 26 + 96);
                    if (ch == '`') ch = 'z';
                    build.append(ch);
                }
            }
            output = build.toString();
            answer.setText(output);
        }
        //when reset is pressed, clear both text fields
        else if (event.getActionCommand().equals("Reset")) {
            plain.setText("");
            cipher.setText("");
        }
    }
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Cipher();
            }
        });
    }
}