import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MealPlan implements ItemListener {
    JLabel label, total;
    JComboBox dorms, meals;
    
    MealPlan() {
        JFrame frame = new JFrame("Dorm and Meal Plan");
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

        dorms.addItemListener(this);
        meals.addItemListener(this);

        total = new JLabel("");

        frame.add(label);
        frame.add(dorms);
        frame.add(meals);
        frame.add(total);
        frame.setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        int out = 0;
        int i = dorms.getSelectedIndex();
        int l = meals.getSelectedIndex();
        switch (i) {
            case 0: 
                out += 1500;
                break;
            case 1: 
                out += 1600;
                break;
            case 2: 
                out += 1200;
                break;
            case 3: 
                out += 1800;
                break;
        }
        switch (l) {
            case 0: 
                out += 560;
                break;
            case 1: 
                out += 1095;
                break;
            case 2: 
                out += 1500;
                break;
        }
        total.setText("\nTotal: $" + out);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MealPlan();
            }
        });
    }
}
