
	import javax.swing.*;

	import java.awt.*;

	import java.awt.event.*;

	 

	class Login extends JFrame implements ActionListener
	{

	    final JButton submitBtn;

	    final JPanel panel;

	    final JLabel usernameLabel, passwordLabel;

	    final JTextField  usernameField;

	    final JPasswordField passwordField;

	     

	    JFrame father;

	     

	    Login(JFrame masterForm)

	    {

	        super("Login form");

	        father = masterForm;

	        usernameLabel = new JLabel("Username:");

	        usernameField = new JTextField(15);

	 

	        passwordLabel = new JLabel("Password:");

	        passwordField = new JPasswordField(15);

	 

	        submitBtn =new JButton("SUBMIT");

	        submitBtn.addActionListener(this);

	         

	        panel = new JPanel(new GridLayout(3,2));

	        panel.add(usernameLabel);

	        panel.add(usernameField);

	        panel.add(passwordLabel);

	        panel.add(passwordField);

	        panel.add(submitBtn);

	        // to fill the GridLayout

	        panel.add(new JLabel(""));

			add(panel,BorderLayout.CENTER);

	 

	        setTitle("LOGIN FORM");

	        setSize(300,100);

	        setVisible(true);

	    }

	     

	    public void actionPerformed(ActionEvent ee)

	    {

	        // validate here the username from usernameField.getText()

	        // and the password form passwordField.getPassword();

	        // if valid

	        this.setVisible(false);             // hide myself

	        father.setVisible(true);            // show my father

	        this.dispose();                     // clean my resource

	         

	    }

	}