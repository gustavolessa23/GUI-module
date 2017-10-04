import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ShowingData  extends JFrame implements ActionListener {

  public ShowingData(){
    
    setSize(500,500);
    setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    

      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;

      try {
          conn =
             DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?user=root&password=");

          // Do something with the Connection
          stmt = conn.createStatement();
          rs = stmt.executeQuery("select * from samplelogin;");
          
          // Check how many rows
          int maxRow = 0;
          while(rs.next()){
            maxRow++;
          }
          System.out.println("Number of rows: "+maxRow);
          
          // Query the info again => ResultSet
          rs = stmt.executeQuery("select * from samplelogin;");
          
          //Create 2D array to store and display data
          int rowCounter = 0;
          String [][] data = new String[maxRow][4];
          
          // loop over results          
          while(rs.next()){
            
            String id = rs.getString("id");
            data[rowCounter][0] = id;
            
            String username = rs.getString("username");
            data[rowCounter][1] = username;
            
            String password = rs.getString("password");
            data[rowCounter][2] = password;
            
            String type = rs.getString("type");
            data[rowCounter][3] = type; rowCounter++;      
          }
          
          String[] columnNames = {"id", "username", "password", "acctype"};
          
          JTable table = new JTable(data, columnNames);
          
          JScrollPane scroll = new JScrollPane(table);
          
          this.add(scroll);
         
      } catch (SQLException ex) {
          // handle any errors
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
      }    
      
      repaint();
      revalidate();
  }
  
  public static void main(String[] args){
    new ShowingData();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
  }

}
