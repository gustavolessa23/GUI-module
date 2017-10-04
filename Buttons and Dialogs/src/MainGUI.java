import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainGUI extends JFrame implements ActionListener {
  
  //Creating panel as global item
  JPanel buttonPanel = new JPanel();
  
  //Creating showPanel button as global
  JButton showPanel = new JButton("Show Panel");

  
  public MainGUI() {
    
    // Make the bar for the menu
    JMenuBar bar = new JMenuBar();
    this.setJMenuBar(bar);
    
      // Make and Add File menu onto the bar
      JMenu file = new JMenu("File");
      bar.add(file); // add "File" to the menu (menu is on the bar)
        
        // Add items to File
        JMenuItem open = new JMenuItem("Open");
        file.add(open);
        JMenuItem close = new JMenuItem("Close");
        file.add(close);
        
      // Create About us menu
      JMenu about = new JMenu("About");
      bar.add(about);
      
        // Add items do About
        JMenuItem aboutus = new JMenuItem("About us");
        about.add(aboutus);
        JMenuItem moreinfo = new JMenuItem("More Info");
        about.add(moreinfo);
        

    this.setSize(500,500);
    this.setVisible(true);
    this.setLayout(new FlowLayout()); //Puts the objects beside each other. Layer Manager is set with setLayout.
    
    //Button to show panel

    showPanel.addActionListener(this);
    showPanel.setActionCommand("show");//ID for the button
    this.add(showPanel);
    
    
    // First button added to the panel
    JButton test2 = new JButton("Create another button");
    test2.addActionListener(this);
    test2.setActionCommand("test2");
    buttonPanel.add(test2);
    
    //test.setPreferredSize(new Dimension());
    
    // Second button added to the panel
    JButton test = new JButton("Exit"); // Making the button
    test.addActionListener(this); //turn the listening on
    test.setActionCommand("test");// gives the button an ID
    buttonPanel.add(test); 

    validate();
    repaint();  
  }
  
  public static void main(String[] args){
    new MainGUI();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JButton test3 = new JButton("Apareceu");
    if(e.getActionCommand().equals("test")){
      System.exit(0);
      
    } else if(e.getActionCommand().equals("test2")){
        test3.addActionListener(this);
        test3.setActionCommand("test3");
        this.add(test3);
        validate();
        repaint();
    
    } else if(e.getActionCommand().equals("test3")){
        test3.setVisible(false);
        validate();
        repaint();
        
    } else if(e.getActionCommand().equals("show")){
        this.remove(showPanel);
        this.add(buttonPanel);
        validate();
        repaint();
    }
    //MainGUI x = new MainGUI(); //opens another page
  }
}
