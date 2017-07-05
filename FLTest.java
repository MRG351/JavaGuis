
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

public class FLTest extends JPanel {
    
    JButton button1, button2, button3, button4, button5;
    
    public FLTest() {   
        //super(new BorderLayout());
        super(new BorderLayout());
                
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");
        button4 = new JButton("Button 4");
        button5 = new JButton("Button 5");
           
        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        
        //Add the buttons to this panel
        add(buttonPanel, BorderLayout.PAGE_START);
    }
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FlowLayout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JComponent newContentPane = new ComboBoxDemo();
        //newContentPane.setOpaque(true); //content panes must be opaque
        //frame.setContentPane(newContentPane);
        frame.add(new FLTest());

        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {            
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });        
    }
}