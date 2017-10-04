import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainSample extends JFrame implements ActionListener{

  public MainSample() {
    
    setSize(500,500);
    setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    this.add(panel);
    
    
    JButton btn = new JButton("Botão");
    btn.addActionListener(this);
    btn.setActionCommand("btn");
    panel.add(btn);
    
    
    validate();
    repaint();
    
  }
  
  public static void main(String[] args){
    new MainSample();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("btn")){
      Object[] options = {"Yes, please",
          "No, thanks",
          "Remind me later"};
  
      int n = JOptionPane.showOptionDialog(this,
              "Would you like to save?",
              "Attention needed",
              JOptionPane.YES_NO_CANCEL_OPTION,
              JOptionPane.INFORMATION_MESSAGE,
              null,
              options,
              options[2]);
      if(n==0){
        JOptionPane.showMessageDialog(this, "You chose "+options[0]);
      } else if (n==1){
        JOptionPane.showMessageDialog(this, "You chose "+options[1]);
      } else if (n==2){
       
      } JOptionPane.showMessageDialog(this, "You chose "+options[2]);
    }
    
  }

}
