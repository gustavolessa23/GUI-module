import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;


public class DBTest extends JFrame implements ActionListener{

  public static void main(String[] args) {
    try {
      // First we will create a new instance of the MySQL driver
      Class.forName("com.mysql.jdbc.Driver").newInstance();
     }catch(Exception e ){
       
     }
     // We will then create an instance of each Object that we will need to use.
       Connection conn = null;
       Statement stmt = null;
       ResultSet rs = null;
     try {
      // Below we are building up our connection string to point to the database
       conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?user=root&password=");
     // Creating a new statement
       stmt = conn.createStatement();
     // Running the SQL command we want to use, this can be any SQL statement!
       if (stmt.execute("select * from samplelogin;")) { rs = stmt.getResultSet();
       }
         // loop over results, each row in the database table is a new iteration of the loop
       while(rs.next()){
         System.out.println("----------------------");
         String id = rs.getString("id");  // get the ID column and put it into a variable
         System.out.println("ID: " + id);
         String sid = rs.getString("username");  // get the username column and put it into a variable
         System.out.println("UN: " + sid);
       } 
     } catch (SQLException ex) {
         // handle any errors
         System.out.println("SQLException: " + ex.getMessage()); System.out.println("SQLState: " + ex.getSQLState()); System.out.println("VendorError: " + ex.getErrorCode());
     }
     }

  
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    
  }
}

