
	import java.awt.*;

	import javax.swing.*;

	 

	 /** 
		* Excellent (and short) example of how to use multiple windows within an application,
		* just don't forget, this program deals only with the frames and leaves out of consideration
		* any objects which may be associated with the master/slave frames and which need to be dealt 
		* with. In particular, may sure you remove any references to key/mouse/window/event listerners
		* which may cause bugginess in the behavior of the "active" frame.
		*
		* Also, see if you can do something with this idea, and the idea of putting "settings" in a stack.
		* 
	 */
	public class MasterFrame extends JFrame {

	 

	    final static String[] labelStr = {"Just a test", "Dummy label", "to fill", "the form"};

	     
	    // this the master frame... we just fill it with labels an button to show how it works

	    MasterFrame() {

	        super("MasterFrame");

	         

	        // build a dummy panel with dummy labels just to fill the GUI

	        JPanel panel = new JPanel(new GridLayout(labelStr.length, 2));

	        for(int i = 0; i < labelStr.length; i++) {

	            panel.add(new JLabel(labelStr[i]));

	            panel.add(new JButton("Button " + i));

	        }

	        add(panel);

	        setSize(400, 200);
			
	        // create and show the Login form

	        new Login(this);

	    }

	     

	    // to test the whole thing

	    public static void main(String[] args) {

	        new MasterFrame();

	    }

	}

	 

	 
