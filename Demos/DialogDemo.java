import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogDemo implements ActionListener {
	
	JFrame jfrm;
	JLabel defaultDialogLabel;
	JLabel inputDialogLabel;
	JDialog dialogBox;
	
	DialogDemo(){
		//JFrame
		JFrame jfrm = new JFrame("Basic Dialogs Example");
		jfrm.setSize(400, 400);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setLayout(new BorderLayout());
		
		//button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		//prompt
		JLabel prompt = new JLabel("Press a button to discover each type of label");
		
		//buttons for each type of dialog (message, confirm, input, option)
		JButton messageOP = new JButton("JOptionPane Message Dialog");
		messageOP.setActionCommand("message");
		JButton confirmOP = new JButton("JOptionPane Confirm Diaog");
		confirmOP.setActionCommand("confirm");
		JButton inputOP = new JButton("JOptionPane Input Diaog");
		inputOP.setActionCommand("input");	
		JButton optionOP = new JButton("JOptionPane Option Diaog");
		optionOP.setActionCommand("option");
		JButton dialogEX = new JButton("JDialog Example");
		dialogEX.setActionCommand("dialog");
		
		//label information
		defaultDialogLabel = new JLabel("Select a button to close the dialog.");
		inputDialogLabel = new JLabel("Input Content: ");
		
		//add action listener to buttons
		messageOP.addActionListener(this);
		confirmOP.addActionListener(this);
		inputOP.addActionListener(this);
		optionOP.addActionListener(this);
		dialogEX.addActionListener(this);
		
		//create JDialog
		dialogBox = new JDialog(jfrm, "Click a button", true);
		dialogBox.setSize(200, 200);
		dialogBox.setLayout(new FlowLayout());
		dialogBox.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//add buttons to button panel
		buttonPanel.add(messageOP);
		buttonPanel.add(confirmOP);
		buttonPanel.add(inputOP);
		buttonPanel.add(optionOP);
		buttonPanel.add(dialogEX);
		
		//add prompt and buttonPanel to content pane
		jfrm.add(prompt, BorderLayout.PAGE_START);
		jfrm.add(buttonPanel, BorderLayout.CENTER);
		
		//set visible
		jfrm.setVisible(true);

	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("message")) {
			JOptionPane.showMessageDialog(jfrm, defaultDialogLabel);
		}
		else if(ae.getActionCommand().equals("confirm")) {
			JOptionPane.showConfirmDialog(jfrm, defaultDialogLabel);
		}
		else if(ae.getActionCommand().equals("input")) {
			JOptionPane.showInputDialog(jfrm, inputDialogLabel);
		}
		else if(ae.getActionCommand().equals("option"))	{
			String options[] = {"happy","indifferent", "sad"};
			JOptionPane.showOptionDialog(jfrm, defaultDialogLabel, "Option Dialog", 0, 0, null, options, null);
		}
		else {
			dialogBox.add(defaultDialogLabel);
			dialogBox.setVisible(true);
		}
	}
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			new DialogDemo();
			}
		});
	} 
}
