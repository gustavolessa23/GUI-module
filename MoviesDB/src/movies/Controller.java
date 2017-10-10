package movies;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Controller implements ActionListener {

	Main main = null;
	
	public Controller(Main main) {
		
		this.main = main;
		
	}
	
	public void registerInfo() {
		try {    
			
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        
	      }catch(Exception e ){
	    	  
	      }
		
	        Connection conn = null;
	        Statement stmt = null;
	        
	        try {
	            conn =
	               DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?user=root&password=");

	            // Do something with the Connection
	            stmt = conn.createStatement();

	            // or alternatively, if you don't know ahead of time that
	            // the query will be a SELECT...

	            String movieTitle = main.title.getText();
	            String castMember = main.actor.getText();
	            
	            if (stmt.execute("INSERT INTO `movies` (`title`, `actor`) VALUES ('"+movieTitle+"', '"+castMember+"');")) {
	              
	            }
	                
	            
	        } catch (SQLException ex) {
	            // handle any errors
	            System.out.println("SQLException: " + ex.getMessage());
	            System.out.println("SQLState: " + ex.getSQLState());
	            System.out.println("VendorError: " + ex.getErrorCode());
	        }
	  }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("cls")){
			
		 int n = JOptionPane.showConfirmDialog(main, "Would you like to close?", "Confirm", JOptionPane.YES_NO_OPTION);
		 
		 if (n==0) {
			 System.exit(0);
		 }
		} else if (e.getActionCommand().equals("save")){
			registerInfo();
		} else if (e.getActionCommand().equals("search")) {
			searchInfo();
		}
	}

	private void searchInfo() {
		try {
		      
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	      
	      }catch(Exception e ){}

	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      try {
		    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?user=root&password=");
			
		    // Do something with the Connection
			stmt = conn.createStatement();
			
            String movieTitle = main.title.getText();
            
            rs = stmt.executeQuery("select * from movies where title =('"+movieTitle+"');");
			
	          
	          // loop over results
	          while(rs.next()) {
	            String result = rs.getString("actor");
	              main.actor.setText(result);
	          } 
	         
	      } catch (SQLException ex) {
	          // handle any errors
	          System.out.println("SQLException: " + ex.getMessage());
	          System.out.println("SQLState: " + ex.getSQLState());
	          System.out.println("VendorError: " + ex.getErrorCode());
	      }    
	}
}
