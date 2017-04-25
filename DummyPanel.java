import java .awt  .GridBagConstraints;
import java .awt  .GridBagLayout;
import java .awt  .Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DummyPanel extends JPanel {
  public DummyPanel() {
    super(new GridBagLayout());
    
    JLabel label = new JLabel("This is a dummy panel.");
    
    setBackground(UMBParkingApp.UMB_BLUE);
    
    GridBagConstraints c = new GridBagConstraints();
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10, 10, 10, 10);
    add(label, c);
  }
}