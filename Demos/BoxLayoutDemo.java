import javax.swing.*;

public class BoxLayoutDemo {

    BoxLayoutDemo() {
        JFrame frame = new JFrame("Box Layout Demo");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JLabel label = new JLabel("This is a label.");
        JButton button = new JButton("This is a button.");
        JTextField field = new JTextField(20);
        JButton button2 = new JButton("This is another button.");

        frame.add(label);
        frame.add(button);
        frame.add(field);
        frame.add(button2);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BoxLayoutDemo();
            }
        });
    }
    
}
