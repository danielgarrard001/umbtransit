import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResetPassword extends JPanel implements ActionListener {
  
  private JLabel jLabel1;
  private JTextField emailField;
  private GridBagConstraints c;
  
  public ResetPassword() {
    super(new GridBagLayout());
    jLabel1 = new JLabel("Please enter the email address associated with your account:");
    emailField = new JTextField(20);
    emailField.addActionListener(this);
    
    c = new GridBagConstraints();
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10, 10, 10, 10);
    add(jLabel1, c);
    add(emailField, c);
  }
  
  public void actionPerformed(ActionEvent evt) {
    String emailAddress = emailField.getText();
    // implement code for sending password reset email here
    
    remove(emailField);
    jLabel1.setText("<html>An email with a temporary password has been sent to " + emailAddress + "</html>");
    repaint();
    
    //implement button to return to login page here
  }
  
  private static void createAndShowGUI() {
    JFrame frame = new JFrame("Reset Password");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.add(new ResetPassword());
    
    frame.pack();
    frame.setBounds(300, 150, 450, 750);
    frame.setVisible(true);
  }
  
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}