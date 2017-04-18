import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.mail.*;
import javax.mail.internet.*;

public class ResetPassword extends JPanel implements ActionListener {
  
  private JLabel jLabel1;
  private JTextField emailField;
  private GridBagConstraints c;
  private static final Font FRANKLIN = new Font("Franklin Gothic Book", Font.PLAIN, 12);
  
  public ResetPassword() {
    super(new GridBagLayout());
    jLabel1 = new JLabel("Please enter the email address associated with your account:");
    jLabel1.setForeground(Color.WHITE);
    jLabel1.setFont(FRANKLIN);
    emailField = new JTextField(20);
    emailField.setFont(FRANKLIN);
    emailField.addActionListener(this);
    
    setBackground(new Color(0, 90, 139));
    
    c = new GridBagConstraints();
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10, 10, 10, 10);
    add(jLabel1, c);
    add(emailField, c);
  }
  
  public void actionPerformed(ActionEvent evt) {
    String emailAddress = emailField.getText();
    
    remove(emailField);
    jLabel1.setText("Please wait.");
    repaint();
    
    // Try to send an email to the specified address; display a positive message for success and negative for failure.
    try {
      sendResetEmailTo(emailAddress);
      jLabel1.setText("<html>An email with a temporary password has been sent to \"" + emailAddress + "\"</html>");
    } catch(MessagingException mex) {
      jLabel1.setText("<html>Sorry, there was a problem sending an email to \"" + emailAddress + "\".</html>");
    }
    
    //implement button to return to login page here
    repaint();
  }
  
  private static void createAndShowGUI() {
    JFrame frame = new JFrame("Reset Password");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.add(new ResetPassword());
    
    frame.pack();
    frame.setBounds(300, 150, 450, 750);
    frame.setVisible(true);
  }
  
  private static class SMTPAuthenticator extends Authenticator
  {
    private PasswordAuthentication authentication;
    
    public SMTPAuthenticator(String login, String password)
    {
      authentication = new PasswordAuthentication(login, password);
    }
    
    @Override
    protected PasswordAuthentication getPasswordAuthentication()
    {
      return authentication;
    }
  }
  
  private static void sendResetEmailTo(String toAddress) throws MessagingException {
    String fromAddress = "umb.transit.app@gmail.com";
    Properties props = System.getProperties();
    props.setProperty("mail.host", "smtp.gmail.com");
    props.setProperty("mail.smtp.port", "587");
    props.setProperty("mail.smtp.auth", "true");
    props.setProperty("mail.smtp.starttls.enable", "true");
    
    Authenticator auth = new SMTPAuthenticator("umb.transit.app@gmail.com", "TheSevenDwarves");
    
    Session session = Session.getDefaultInstance(props, auth);
    
    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(fromAddress));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
      message.setSubject("Reset Password");
      message.setText("In a final version of the app, this email would contain a temporary password for you to use.");
      
      Transport.send(message);
    } catch(MessagingException mex) {
      mex.printStackTrace();
      throw(mex);
    }
  }
  
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}