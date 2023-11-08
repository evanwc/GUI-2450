import javax.swing.*;
import java.awt.*;
import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ScrollBarDemo {
	//horiontal and vertical scrollbar
	JScrollBar jsbHoriz;
	JScrollBar jsbVert;
	
	//label
	JLabel currentValHoriz;
	JLabel currentValVert;
	JLabel infoVertSB;
	
	ScrollBarDemo() {
		//jframe
		JFrame jfrm = new JFrame("Scroll bar demo");
		jfrm.setSize(500, 500);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setLayout(new FlowLayout());
		
		//set 0
		currentValHoriz = new JLabel("Current view for horizontal scroll bar: 0");
		currentValVert = new JLabel("Current view for vertical scroll bar: 0");
		
		//init scroll bars
		jsbHoriz = new JScrollBar(Adjustable.HORIZONTAL);
		jsbVert = new JScrollBar(Adjustable.VERTICAL, 0, 50, 0, 300);
		jsbVert.setPreferredSize(new Dimension(30, 300));
		
		//adjustment listeners
		jsbVert.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent ae) {
				currentValVert.setText("Current value for vertical scroll bar: " + ae.getValue());
			}
		});
		
		jsbHoriz.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent ae) {
				currentValHoriz.setText("Current value for horizontal scroll bar: " + ae.getValue());
			}
		});
		
		//set info for infoVertSB
		infoVertSB = new JLabel("<html>Scroll Bar Defaults"
				+ "<br>Minimum Value: " + jsbVert.getMinimum()
				+ "<br>Maximum Value: " + jsbVert.getMaximum()
				+ "<br>Visible Amount (extent): " + jsbVert.getVisibleAmount()
				+ "<br>Block Increment: " + jsbVert.getBlockIncrement()
				+ "<br>Unit Increment: " + jsbVert.getUnitIncrement()
				);
		
		//add to JFrame
		jfrm.add(jsbVert);
		jfrm.add(jsbHoriz);
		jfrm.add(currentValVert);
		jfrm.add(currentValHoriz);
		jfrm.add(infoVertSB);
		
		//set visible
		jfrm.setVisible(true);
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ScrollBarDemo();
			}
		});
	}
}