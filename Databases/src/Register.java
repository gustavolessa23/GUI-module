import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Register extends JFrame implements ActionListener{

  public int getAge(String date) throws Exception{
    int age = 0;
    String[] dateInput = date.split("/");
    try {
        DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
        Date d1 = df.parse(dateInput[2]+"-"+dateInput[1]+"-"+dateInput[0]);
     //   Date date1 = DateFormat.getDateInstance().parse(date);
        Calendar now = Calendar.getInstance();
        Calendar dob = Calendar.getInstance();
        dob.setTime(d1);
        if (dob.after(now)) {
            throw new IllegalArgumentException("Can't be born in the future");
        }
        int year1 = now.get(Calendar.YEAR);
        int year2 = dob.get(Calendar.YEAR);
        age = year1 - year2;
        int month1 = now.get(Calendar.MONTH);
        int month2 = dob.get(Calendar.MONTH);
        if (month2 > month1) {
            age--;
        } else if (month1 == month2) {
            int day1 = now.get(Calendar.DAY_OF_MONTH);
            int day2 = dob.get(Calendar.DAY_OF_MONTH);
            if (day2 > day1) {
                age--;
            }
        }
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return age ;
  }
 

 // make the fields global so we can see them!!
  JTextField username = null;
  JTextField password = null;
  JTextField dob = null;
  
 // JTextField age = null;
  JLabel age = null;
  JComboBox type = null;
  
  //Panels
  JPanel panel = new JPanel();
  JPanel buttonsPanel = new JPanel();
  JTable table;
  
  JScrollPane scroll;
  
  String [][] data;
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Register(){
    
    setSize(400,500);
    setVisible(true);   
    
    panel.setLayout(new GridLayout(5,1));
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    JLabel un = new JLabel(" Username:");
    panel.add(un);
    username = new JTextField(20);
    panel.add(username);
    
    JLabel pw = new JLabel(" Password:");
    panel.add(pw);
    password = new JTextField(20);
    panel.add(password);
    
    JLabel dobLabel = new JLabel(" DOB (DD/MM/YYYY)");
    panel.add(dobLabel);
    dob = new JTextField(10);
    panel.add(dob);
    
    JLabel old = new JLabel(" Age:");
    panel.add(old);
    age = new JLabel("");
   // age = new JTextField(2);
    //age.setEditable(false);
    panel.add(age);
    
    JLabel typeLabel = new JLabel(" User type:");
      panel.add(typeLabel);
        String[] userTypes = {"Admin","User"};
        type = new JComboBox(userTypes);
        panel.add(type);
    
    
    buttonsPanel.setLayout(new FlowLayout());
    
    
    JButton calculateAge = new JButton(" Calculate Age");
      calculateAge.addActionListener(this);
      calculateAge.setActionCommand("calculateAge");
      buttonsPanel.add(calculateAge);
      
    JButton register = new JButton(" Register");
      register.addActionListener(this);
      register.setActionCommand("register");
      buttonsPanel.add(register);
      
    JButton retrieve = new JButton("Retrieve");
    retrieve.addActionListener(this);
    retrieve.setActionCommand("retrieve");
    buttonsPanel.add(retrieve);
    
    this.add(buttonsPanel, BorderLayout.PAGE_END);
    this.add(panel, BorderLayout.CENTER);
    panel.setVisible(true);
    
    
    
    validate();
    repaint();
  }
  
  public static void main(String[] args) {
        new Register();
  }
  
  public void registerNewUser(){
    try {
      
        Class.forName("com.mysql.jdbc.Driver").newInstance();
      
      }catch(Exception e ){}
      
      
        Connection conn = null;
        Statement stmt = null;
    //    ResultSet rs = null;
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?user=root&password=");

            // Do something with the Connection
            stmt = conn.createStatement();

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

            String un = username.getText();
            String pw = password.getText();
            String userFromMenu = (String)type.getSelectedItem();
            
            if (stmt.execute("INSERT INTO `samplelogin` (`username`, `password`,`age`,`type`) VALUES ('"+un+"', '"+pw+"',"+age.getText()+",'"+userFromMenu+"');")) {
              
            }
            JOptionPane.showMessageDialog(this, "User Registered!");    
            
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
  }
  
  public void showUsers(){
    Connection conn2 = null;
    Statement stmt2 = null;
    ResultSet rs2 = null;

    try {
        conn2 =
           DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?user=root&password=");

        // Do something with the Connection
        stmt2 = conn2.createStatement();
        rs2 = stmt2.executeQuery("select * from samplelogin;");
        
        // Check how many rows
        int maxRow = 0;
        while(rs2.next()){
          maxRow++;
        }
        System.out.println("Number of rows: "+maxRow);
        
        // Query the info again => ResultSet
        rs2 = stmt2.executeQuery("select * from samplelogin;");
        
        //Create 2D array to store and display data
        int rowCounter = 0;
        data = new String[maxRow][4];
        
        // loop over results          
        while(rs2.next()){
          
          String id = rs2.getString("id");
          data[rowCounter][0] = id;
          
          String username = rs2.getString("username");
          data[rowCounter][1] = username;
          
          String password = rs2.getString("password");
          data[rowCounter][2] = password;
          
          String type = rs2.getString("type");
          data[rowCounter][3] = type; rowCounter++;      
        }
        
        String[] columnNames = {"id", "username", "password", "acctype"};
        
        table = new JTable(data, columnNames);
        
        scroll = new JScrollPane(table);
        
        this.add(scroll, BorderLayout.CENTER);
       
    } catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }    
    
    repaint();
    revalidate();
}
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("register")){
      try {
         scroll.setVisible(false);
      } catch (Exception f){
        f.printStackTrace();
      }

        
      if (panel.isVisible()){
        calculateAge();
        registerNewUser();
      } 
      
      panel.setVisible(true);
      
      
      validate();
      repaint();
    } else if (e.getActionCommand().equals("calculateAge")){
      if (panel.isVisible()){
         calculateAge();
      }
    } else if (e.getActionCommand().equals("retrieve")){
      panel.setVisible(false);
      showUsers();
      validate();
      repaint();
    } 
  }
  
  private void calculateAge(){
    try {
      age.setText(String.valueOf(getAge(dob.getText())));
    } catch (Exception e) {
      e.printStackTrace();
      age.setText("-1");
    }
  }
  
}
