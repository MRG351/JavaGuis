import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;


public class GUIcalc2 extends JPanel {
   private static final String[][] BTN_TEXTS = { 
      { "7", "8", "9", "/" },
      { "6", "5", "4", "*" }, 
      { "3", "2", "1", "+" }, 
      { "0", ".", "=", "-" } };
   private static final int GAP = 3;
   private static final float TF_SIZE = 18f;
   private static final float BTN_SIZE = 24f;
   private JButton[][] buttons = new JButton[BTN_TEXTS.length][BTN_TEXTS[0].length];
   private JTextField textField = new JTextField(10);

   public GUIcalc2() {
      textField.setFont(textField.getFont().deriveFont(TF_SIZE));
      JPanel btnPanel = new JPanel(new GridLayout(BTN_TEXTS.length, 
            BTN_TEXTS[0].length, GAP, GAP));
      for (int row = 0; row < BTN_TEXTS.length; row++) {
         for (int col = 0; col < BTN_TEXTS[0].length; col++) {
            JButton btn = new JButton(BTN_TEXTS[row][col]);
            // add ActionLIstener here
            btn.setFont(btn.getFont().deriveFont(Font.BOLD, BTN_SIZE));
            btnPanel.add(btn);

            buttons[row][col] = btn;
         }
      }

      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      setLayout(new BorderLayout(GAP, GAP));
      add(textField, BorderLayout.PAGE_START);
      add(btnPanel, BorderLayout.CENTER);
   }

   private static void createAndShowGui() {
      GUIcalc2 mainPanel = new GUIcalc2();

      JFrame frame = new JFrame("Calc");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
       
       /* Set System L&F: This is the L&F style that uses the native system look */
        try {
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.exit(1);
        } catch (InstantiationException e) {
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.exit(1);
        } 
       
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}