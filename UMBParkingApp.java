import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UMBParkingApp extends JFrame {
  public static final Color UMB_BLUE       = new Color(  0,  90, 139);
  public static final Color UMB_LIGHT_BLUE = new Color(160, 207, 235);
  public static final Color UMB_RED        = new Color(163,  63,  31);
  public static final Color UMB_GOLD       = new Color(197, 146,  23);
  public static final Color UMB_WARM_GRAY  = new Color(152, 143, 134);
  public static final Color UMB_ORANGE     = new Color(212, 188,   0);
  public static final Color UMB_BEIGE      = new Color(167, 158, 112);
  
  public static final Font  FG_BOOK        = new Font( "Franklin Gothic Book", Font.PLAIN, 12);
  public static final Font  FG_DEMI        = new Font( "Franklin Gothic Demi", Font.PLAIN, 12);
  public static final Font  FG_HEAVY       = new Font("Franklin Gothic Heavy", Font.PLAIN, 12);
  
  private ActionListener listener;
  private ResetPassword  rPPanel;
  
  
  public UMBParkingApp() {
    super("UMB Parking App");
    
    listener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        remove(rPPanel);
        add(new DummyPanel());
        revalidate();
      }
    };
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setBounds(300, 150, 450, 750);
    setVisible(true);
 //   getContentPane().setBackground(UMASS_BOSTON_BLUE);
    
    rPPanel = new ResetPassword();
    rPPanel.getButton().addActionListener(listener);
    add(rPPanel);
    pack();
    setBounds(300, 150, 450, 750);
  }
  
  public static void main(String[] args) {
    new UMBParkingApp();
  }
}