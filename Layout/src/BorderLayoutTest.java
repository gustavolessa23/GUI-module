import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutTest extends JFrame {
  
  
  public BorderLayoutTest() {
    
    this.setVisible(true);
    this.setSize(500,600);
    
    //Border Layout being used
    this.setLayout(new BorderLayout());
    
    //First panel
    JPanel top = new JPanel();
      JButton clickme = new JButton("Click here");
      top.add(clickme);  
    this.add(top, BorderLayout.LINE_START);
    
    
    //Second panel
    JPanel bottom = new JPanel();
      JButton bottomButton = new JButton("Bottom Button");
      bottom.add(bottomButton); 
    this.add(bottom, BorderLayout.LINE_END);
    
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    new BorderLayoutTest();
    

  }

}
