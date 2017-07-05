import java.util.Scanner;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DieGen extends JPanel implements ActionListener {
	
		private final int DELAY = 10;
		private Timer timer;
		private JFrame frame;
		
		private JPanel topPanel;
		private JPanel bottomPanel;
		private JLabel label;
		private JButton three, four, six, twelve, twenty, two;
		
		public DieGen() {
			// init main Panel
			this.setPreferredSize(new Dimension(400,300));
			this.setMaximumSize(new Dimension(400,300));
			this.setMinimumSize(new Dimension(400,300));
			this.setIgnoreRepaint(true);
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));			
			//this.setLayout(new GridLayout(2,1));
			
			// init topPanel
			topPanel = new JPanel();
			topPanel.setMinimumSize(new Dimension(400,200));
			topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
				// init labels
				label = new JLabel("Buttons");
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				label.setAlignmentY(Component.CENTER_ALIGNMENT);
			topPanel.add(label);
			// fin topPanel
			
			// init bottomPanel
			bottomPanel = new JPanel();
			bottomPanel.setMaximumSize(new Dimension(400,100));
			bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
				// init buttons
				two = new JButton(" 2");
				three = new JButton(" 3");
				four = new JButton(" 4");
				six = new JButton(" 6");
				twelve = new JButton("12");
				twenty = new JButton("20");
			bottomPanel.add(Box.createHorizontalGlue());
			bottomPanel.add(two);	
			//bottomPanel.add(Box.createHorizontalGlue());
			bottomPanel.add(three);
			//bottomPanel.add(Box.createHorizontalGlue());
			bottomPanel.add(four);
			//bottomPanel.add(Box.createHorizontalGlue());
			bottomPanel.add(six);
			//bottomPanel.add(Box.createHorizontalGlue());
			bottomPanel.add(twelve);
			//bottomPanel.add(Box.createHorizontalGlue());
			bottomPanel.add(twenty);
			bottomPanel.add(Box.createHorizontalGlue());
			
			/// fin bottomPanel
			
			this.add(topPanel);
			this.add(bottomPanel);
			// fin main Panel init
			
			// init frame
			frame = new JFrame("Dice Simulator");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			
			frame.add(this);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			timer = new Timer(DELAY,this);
			timer.start();
			
		}
		
		protected void paintComponant(Graphics g) {
			
		}
		
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new DieGen();
				}
			});
		}
		
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
}