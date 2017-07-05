import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

class Menu extends JPanel implements ActionListener{
	
	enum State {INTRO, NEW, LOAD, OPTIONS, QUIT}
	
	
	private final int DELAY = 10;
	
	private JFrame frame;
	private JTextField nameField, numberField, diffField;
	private JLabel nameLabel, numberLabel, diffLabel;
	private JPanel namePanel, numberPanel, diffPanel, leftPanel, rightPanel;
	private Timer timer;
	private State state = State.INTRO;
	private Font font = new Font("Courier", Font.PLAIN, 16);
	private boolean paintInProgress = false;
	private boolean select = false;
	
	private int selector = 0;
	private String[] introLabels = {"NEW", "LOAD", "OPTIONS", "QUIT"};
	private String[] newLabels = {};
	
	public Menu()  {
		setPreferredSize(new Dimension(400, 300));
		setMaximumSize(new Dimension(400, 300));
		setMinimumSize(new Dimension(400,300));
		setIgnoreRepaint(true);
		
		frame = new JFrame("Menu");
		//frame.setSize(new Dimension(400,300)); // not necessary with pack()
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.addKeyListener(new KeyManager());
		
		frame.add(this);	
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	private void exitProtocol(State s) {
		if (s == State.QUIT) {
			frame.dispose();
			System.exit(0);
		} else if (s == State.NEW) {
			frame.dispose();// temp
			System.exit(0);
		} else if (s == State.LOAD) {
			frame.dispose();	// temp
			System.exit(0);
		} else if (s == State.OPTIONS) {
			timer.stop();
			frame.dispose();
			Options.start();	// also temp, but will do something similar when Game class is lauched.
		} else {
			frame.dispose();
			System.exit(0); // temp
		}
	}
	
	private void setupNew() {
		/*
		namePanel = new JPanel();
		namePanel.setMaximumSize(new Dimension(400, 30));
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
		
		nameLabel = new JLabel("Name:");
		nameLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		nameField = new JTextField(40);
		nameField.setAlignmentX(Component.LEFT_ALIGNMENT);		
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		numberPanel = new JPanel();
		numberPanel.setMaximumSize(new Dimension(400, 30));
		numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.LINE_AXIS));
		
		numberLabel = new JLabel("Number of Minions:");
		numberLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		numberField = new JTextField(40);
		numberField.setAlignmentX(Component.LEFT_ALIGNMENT);		
		numberPanel.add(numberLabel);
		numberPanel.add(numberField);
		
		
		diffPanel = new JPanel();
		diffPanel.setMaximumSize(new Dimension(400, 30));
		diffPanel.setLayout(new BoxLayout(diffPanel, BoxLayout.LINE_AXIS));	
		
		diffLabel = new JLabel("Difficulty:");
		diffLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		diffField = new JTextField(40);
		diffField.setAlignmentX(Component.LEFT_ALIGNMENT);		
		diffPanel.add(diffLabel);
		diffPanel.add(diffField); */
		
		leftPanel = new JPanel();
		leftPanel.setMaximumSize(new Dimension(150,200));
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
		leftPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		nameLabel = new JLabel("Name:");
		nameLabel.setMaximumSize(new Dimension(150, 30));
		nameLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		numberLabel = new JLabel("Number of Minions:");
		numberLabel.setMaximumSize(new Dimension(150, 30));
		numberLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		diffLabel = new JLabel("Difficulty:");
		diffLabel.setMaximumSize(new Dimension(150, 30));
		diffLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		leftPanel.add(nameLabel);
		leftPanel.add(numberLabel);
		leftPanel.add(diffLabel);
		
		rightPanel = new JPanel();
		rightPanel.setMaximumSize(new Dimension(250,200));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
		rightPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		nameField = new JTextField(40);
		nameField.setMaximumSize(new Dimension(50, 30));
		nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
		numberField = new JTextField(40);
		numberField.setMaximumSize(new Dimension(50, 30));
		numberField.setAlignmentX(Component.LEFT_ALIGNMENT);
		diffField = new JTextField(40);
		diffField.setMaximumSize(new Dimension(50, 30));
		diffField.setAlignmentX(Component.LEFT_ALIGNMENT);
		rightPanel.add(nameField);
		rightPanel.add(numberField);
		rightPanel.add(diffField);
		
		/*this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(namePanel);
		this.add(numberPanel);
		this.add(diffPanel); */
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(leftPanel);
		this.add(rightPanel);		
		frame.pack();
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
		//if (state == State.INTRO)
			drawBackground(g); //draw background
		
		switch (state) {
			case INTRO:	
				// // draw text
				for (int i=0; i<introLabels.length; i++) {
						if (selector == i) {
							g.setColor(Color.YELLOW);
							g.drawString(introLabels[i], 50, 50 + 60*i);	// standard rectangular notation... suggests the use of an array.
						}
						else {
							g.setColor(Color.WHITE);
							g.drawString(introLabels[i], 50, 50 + 60*i);
						}
				
				}
		
				if (select) {
					if (selector == 3)	{// EXIT
						state = State.QUIT;
						exitProtocol(state);
					}
					else if (selector == 0) { // NEW
						state = State.NEW;
						selector = 0;
						setupNew();
						select = false;
					}
					else if (selector == 1) { // LOAD 
						state = State.LOAD;
						selector = 0;
						select = false;
					}
					else if (selector == 2) {// OPTIONS 
						state = State.OPTIONS;
						selector = 0;						
						select = false;
						exitProtocol(state);
					}	
					else
						select = false;
				
				}
				break;
			case NEW:				
				break;
			case LOAD:
				break;
			case OPTIONS:
				break;
		}
		// Sync and reset
		Toolkit.getDefaultToolkit().sync();
		paintInProgress = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Menu();
			}
		});
	}
	
	private class KeyManager extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch(state) {
				case INTRO:				
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						selector = (selector + introLabels.length - 1) % introLabels.length; // move selector up
					}
					else if (e.getKeyCode() == KeyEvent.VK_DOWN) {		// move selector down.
						selector = (selector + 1) % introLabels.length;
					}
					else if (e.getKeyCode() == KeyEvent.VK_ENTER) { // select = true.
						select = true;
					}
					break;
				case NEW:
					break;
				case LOAD:
					break;
				case OPTIONS:
					break;					
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			
		}
		
	}
}