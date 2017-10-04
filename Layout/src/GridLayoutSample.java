import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridLayoutSample extends JFrame {
  
  public GridLayoutSample(){
    
    this.setSize(600,600);
    this.setVisible(true);
    
    //this.setLayout(new FlowLayout());
    this.setLayout(new GridLayout(2,2));
    
    JPanel p1 = new JPanel();
    JButton button1 = new JButton("one");
    p1.add(button1);
    
    JButton button1a = new JButton("one and a half");
    p1.add(button1a);
    p1.setLayout(new GridLayout(2,1,50,50));
    this.add(p1);
    
    
    JButton button2 = new JButton("two");
    this.add(button2);
    
    JButton button3 = new JButton("three");
    this.add(button3);
    
    JButton button4 = new JButton("four");
    this.add(button4);
    
    
    validate();
    repaint();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    new GridLayoutSample();

  }

}
