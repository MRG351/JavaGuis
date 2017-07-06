
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;
/*
import java.io.*;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.filechooser.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
*/

public class RetinaParser extends JPanel implements ActionListener {

    JPanel buttonPanel, displayPanel;
    JPanel infoPanel, checkBoxPanel, optionsPanel;
    
    JButton openButton;
    JButton parseButton;
    JButton generateButton;
    
    JFileChooser fc;
    
    public RetinaParser() {   
        super(new BorderLayout());
        fc = new JFileChooser();
        createButtons();
        

        //Add the buttons to this panel
        //add(buttonPanel, BorderLayout.PAGE_START);
        
        //add(buttonPanel);
        //add(displayPanel);
        add(buttonPanel, BorderLayout.LINE_START);
        add(displayPanel, BorderLayout.LINE_END);
    }
    
    private void createButtons() {        
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,0, 1, 16));    // use a gridlayout for these buttons, 3 columns 1 row, 1 unit (pixel) hor and ver gaps between panels.
        
        /* use this if you need empty panels between your grid layout
        JPanel[] placeHolders = new JPanel[3];
        for (int i=0; i<placeHolders.length; i++) {
            placeHolders[i] = new JPanel();
        }*/
        //openButton = new JButton("Open a File...", createImageIcon("images/Open16.gif")); // can add an image next to the Button Text if you want
        openButton = new JButton("Open a File...");
        openButton.addActionListener(this);
        
        parseButton = new JButton("Parse File");
        parseButton.addActionListener(this);
        
        generateButton = new JButton("Generate Report");
        generateButton.addActionListener(this);
        
        buttonPanel.add(openButton);
        buttonPanel.add(parseButton);
        buttonPanel.add(generateButton);
        
        displayPanel = new JPanel();    // gridbaglayout may be best here, as it allows for specification of component width/height
        infoPanel = new JPanel();
        checkBoxPanel = new JPanel();
        optionsPanel = new JPanel();
        
        displayPanel.add(infoPanel, BorderLayout.PAGE_START);
        displayPanel.add(checkBoxPanel, BorderLayout.CENTER);
        displayPanel.add(optionsPanel, BorderLayout.PAGE_END);       
    }
    
    private static void createAndShowGUI() {
        
        JFrame frame = new JFrame("XML Parser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new RetinaParser();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        //frame.add(new RetinaParser());

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
    
    public void actionPerformed(ActionEvent e) {
         //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(RetinaParser.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                //log.append("Opening: " + file.getName() + "." + newline);
            } else {
                //log.append("Open command cancelled by user." + newline);
            }
            //log.setCaretPosition(log.getDocument().getLength());

        //Handle save button action.
        } else if (e.getSource() == parseButton) {
            // this is where the application would use the FileAnalyzer (or XML_Analyzer) class to analyize the xml file
        } else if (e.getSource() == generateButton) {
            // this is where the application would generate a file based upon the xml file used and options specified.
        }
    }
}