import java.awt.*;
import javax.swing.*;

class MyPanel extends JPanel implements Runnable{

	public static void main(String[] args) {
		MyPanel panel = new MyPanel();
		panel.setSize(new Dimension(400, 300));
		panel.setBackground(Color.DARK_GRAY);
		
		MyPanel subpanel = new MyPanel();
		subpanel.setSize(new Dimension(100, 100));
		subpanel.setBackground(Color.RED);
		
		
		JFrame frame = new JFrame("My Panel");
		frame.setSize(new Dimension(400, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //sets fullscreen. May be problematic
        //frame.setUndecorated(true);
		frame.setResizable(false);
		
		panel.add(subpanel);
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public void run() {
	}
	
	
	private synchronized void start() {}
	
	private synchronized void stop() {}
	
	
}