import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MealPlan {
    JLabel label, total;
    JComboBox dorms, meals;
    
    MealPlan() {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        label = new JLabel("Please select a dorm and meal plan:");

        String[] dormList = {"Allen hall: $1500 per semester" ,
            "Pike hall: $1600 per semester",
            "Farthing hall: $1200 per semester", 
            "University Suites: $1800 per semester"};
        String[] mealList = {"7 meals per week: $560 per semester",
            "14 meals per week: $1095 per semester",
            "Unlimited meals: $1500 per semester"};
        
        dorms = new JComboBox<String>(dormList);
        meals = new JComboBox<String>(mealList);

        int output = 0;
        total = new JLabel("");

        dorms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int i = dorms.getSelectedIndex();
                if (i == 0) output += 1500;
                else if (i == 1) output += 1600;
                else if (i == 2) output += 1200;
                else output += 1800;
                total.setText(output + " for this semester.");
            }
        });
        meals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int i = meals.getSelectedIndex();
                switch (i) {
                    case 0:  output += 560;
                             break;
                    case 1:  output += 1095;
                             break;
                    case 2:  output += 1500;
                             break;
                }
                total.setText(output + " for this semester.");
            }
        });

        frame.add(label);
        frame.add(dorms);
        frame.add(meals);
        frame.add(total);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MealPlan();
            }
        });
    }
}
