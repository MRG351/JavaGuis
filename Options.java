import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Options extends JPanel implements ActionListener {

	private final int DELAY = 10;
	
	private Timer timer;
	private JFrame frame;
	private Font font = new Font("Courier", Font.PLAIN, 16);
	private boolean paintInProgress = false;
	
	public Options() {
		setPreferredSize(new Dimension(400,300));
		setMaximumSize(new Dimension(400,300));
		setMinimumSize(new Dimension(400,300));
		setIgnoreRepaint(true);
		
		frame = new JFrame("Options");
		//frame.setSize(new Dimension(400,300)); // not necessary with pack()
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.addKeyListener(new KeyManager());
		
		frame.add(this);	
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	private void drawBackground(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0,this.getWidth(),this.getHeight());		
		g.setFont(font);	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (paintInProgress)
			return;
		paintInProgress = true;
		
		super.paintComponent(g);
		drawBackground(g); //draw background		
		
		// Sync and reset
		Toolkit.getDefaultToolkit().sync();
		paintInProgress = false;
	}
	
	/*public static Object start() {
		return new Options();
	}*/
	
	public static void start() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Options();
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Options();
			}
		});
	}
	
	public void actionPerformed(ActionEvent ee) {
		repaint();
	}
	
	private class KeyManager extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {}		
	}
}