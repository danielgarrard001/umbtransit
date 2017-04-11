import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.time.*;
import java.time.temporal.*;
import java.lang.Math;
import java.awt.event.*;

public class ParkingInfoPage extends JFrame {
   final static int MAX_CAPACITY = 1000;
  
    static double time(){
      LocalDateTime now = LocalDateTime.now();
      double hour = now.get(ChronoField.HOUR_OF_DAY);
      double minute = now.get(ChronoField.MINUTE_OF_DAY);
   
      return (hour +  (minute - hour*60)/60 ) ;
  }
    
    static double parkingLot2(double x){
  
    double a = 100*Math.pow(x-8, 2)/Math.pow(1 + Math.pow(.25*(x-8),3),2);
    double b = 70*Math.pow(x-16, 2)/Math.pow(1 + Math.pow(.29*(x-16),3),2);
             
    if(x<=17 && x>=8)
        return a;
    if(x > 17 && x < 22 )
        return b;
    if(x < 8 || x>22)
        return 35;
    return 0;
  }
    
    
    public   ParkingInfoPage ()
    {
        createAndShowGUI();
    }
   
     public void createAndShowGUI() {
   
   
   
      setBounds(300,150, 450, 750);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setContentPane(new JLabel(new ImageIcon("group.jpg")));   
      setTitle("UMass Parking app");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      BoxLayout boxlayout = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);   
      setLayout(boxlayout);
      setIconImage(new ImageIcon("unnamed.png").getImage());     
      setBounds(300, 150, 450, 750); 
    
      JButton a = addButton( "doc.jpg", 1000, 1);
      JButton b = addButton( "bashful.jpg", 600, 2);
      JButton c = addButton( "dopey.jpg", 400, 3);
      JButton d = addButton( "sleepy.jpg", 76, 4);
      JButton e = addButton( "sneezy.jpg", 10, 5);
     
   
      pack();
      setSize(400,400);
      setVisible(true);
       
           
  }
     
     public static void main(String[] args) {
      new  ParkingInfoPage ();
     }
    
      JButton addButton( String imageonbutton,int maxcapacityofparkinglot, int ycoordinate ){
      ImageIcon B = new ImageIcon(imageonbutton);
      Image image = B.getImage();
      Image newimg = image.getScaledInstance(100,60, java.awt.Image.SCALE_SMOOTH);
      B = new ImageIcon(newimg);
      int numberOfCars = (int)parkingLot2(time());
      
      String s = Integer.toString(numberOfCars) + "/" + Integer.toString(maxcapacityofparkinglot);
    
      JButton b = new JButton(s ,B);
      b.setAlignmentX(Component.CENTER_ALIGNMENT);
      b.setBackground(Color.GREEN);
      getContentPane().setBackground(Color.BLACK);
    
      if(numberOfCars == maxcapacityofparkinglot ){
         b.setText("FULL");
         b.setBackground(Color.RED);   
      }
          
      b.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      button1ActionPerformed(  );
      }}); 
             
      add(b);
      return b;
   }
   

  private  void button1ActionPerformed() {
    
     dummyFrame x = new dummyFrame();     
     dispose();
      
 }
 


 

  public static void setConstraints( int x,int y,double h){
      GridBagConstraints c = new GridBagConstraints();//button
      c.fill = GridBagConstraints.HORIZONTAL;//button
      c.gridx = x;//x;//button
      c.gridy = y;//y;button
      c.weightx = h;//h;button
  }
  

}