
import java.io.File;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;



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
    
    JLabel infoLabel;
    
    JButton openButton;
    JButton generateButton;
    
    JFileChooser fc;
    
    File file;
    
    String fileName = "";
    
    public RetinaParser() {   
        super(new BorderLayout());
        
        initFilechooser();
        initButtons();     

        //Add the buttons to this panel
        //add(buttonPanel, BorderLayout.PAGE_START);
        
        //add(buttonPanel);
        //add(displayPanel);
        add(buttonPanel, BorderLayout.LINE_START);
        add(displayPanel, BorderLayout.LINE_END);
    }
    
    private void initFilechooser() {        
        fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileFilter(new XMLFilter());
    }
    private void initButtons() {        
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,0, 1, 16));    // use a gridlayout for these buttons, 3 columns 1 row, 1 unit (pixel) hor and ver gaps between panels.
        
        /* use this if you need empty panels between your grid layout
        JPanel[] placeHolders = new JPanel[3];
        for (int i=0; i<placeHolders.length; i++) {
            placeHolders[i] = new JPanel();
        }*/
        //openButton = new JButton("Open a File...", createImageIcon("images/Open16.gif")); // can add an image next to the Button Text if you want
        openButton = new JButton("Open a File...");
        openButton.setPreferredSize(new Dimension(90,40));
        openButton.addActionListener(this);
        
        generateButton = new JButton("Generate Report");
        generateButton.setPreferredSize(new Dimension(90,40));
        generateButton.addActionListener(this);
        
        buttonPanel.add(openButton);
        buttonPanel.add(generateButton);
        
        displayPanel = new JPanel();    // gridbaglayout may be best here, as it allows for specification of component width/height
        displayPanel.setLayout(new GridLayout(3,0,1,16));
        displayPanel.setPreferredSize(new Dimension(400,300));
        infoPanel = new JPanel();
        infoLabel = new JLabel("File:" + fileName);
        infoPanel.add(infoLabel);
        checkBoxPanel = new JPanel();
        optionsPanel = new JPanel();
        
        displayPanel.add(infoPanel, BorderLayout.PAGE_START);
        displayPanel.add(checkBoxPanel, BorderLayout.CENTER);
        displayPanel.add(optionsPanel, BorderLayout.PAGE_END);       
    }
    
    private void populate() {
        fileName = file.getName();
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
                file = fc.getSelectedFile();
                populate();
                //log.append("Opening: " + file.getName() + "." + newline);
            } else {
                //log.append("Open command cancelled by user." + newline);
            }
            //log.setCaretPosition(log.getDocument().getLength());

        //Handle save button action.
        } else if (e.getSource() == generateButton) {
            // this is where the application would generate a file based upon the xml file used and options specified.
        }
    }    
    
    /* Filechooser .xml only filter */
    private class XMLFilter extends FileFilter {
    
        private static final String xml = "xml";
    
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
        
            String extension = getExtension(f);
            if (extension != null) { 
                if (extension.equals(xml)) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    
        public String getDescription() {
            return ".xml";
        }
    
        private String getExtension(File f) {
            String ext = null;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 &&  i < s.length() - 1) {
                ext = s.substring(i+1).toLowerCase();
            }
            return ext;
        }
    }
}

