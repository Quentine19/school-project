
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18m01acs031
 */
public class DbConnection {
     //creae the connection strings
        //creae the connection strings
    String host="jdbc:mysql://localhost:3306/schooldb";
    String user="root";
     String pass="";
     //DECLARE CONNECTION
     java.sql.Connection conn;
     
     //initialize the connection object
     
     public java.sql.Connection getConnection(){
         try{
             conn=DriverManager.getConnection(host, user, pass);
            JOptionPane.showMessageDialog(null, "connection successful");
             return conn;
         }
         catch(SQLException ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
             return null;
         }
         }
       public void insertStudentBiography(String fName,String lName,String studentId,String gender,String birthDate,String courseName) {
String q="INSERT into biography(firstname,lastname,studentid,gender,birthdate,coursename) VALUES(?,?,?,?,?,?)";
int k=0;
try{
       java.sql.PreparedStatement st=getConnection().prepareStatement(q);
       st.setString(1,fName);
       st.setString(2,lName);
       st.setString(3,studentId);
       st.setString(4,gender);
       st.setString(5,birthDate);
       st.setString(6,courseName);
       if(st.executeUpdate()>k){
           JOptionPane.showMessageDialog(null,fName+" registered successful");
       }
           
       
   }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    
}
         
     }
        public void insertStudentContactInformation(String Email,String Phone,String PostalCode,String AddressLine1,String AddressLine2) {
String q="INSERT into contactinformation(email,phone,postalcode,addressline,addresslines) VALUES(?,?,?,?,?)";
int k=0;
try{
       java.sql.PreparedStatement st=getConnection().prepareStatement(q);
       st.setString(1,Email);
       st.setString(2,Phone);
       st.setString(3,PostalCode);
       st.setString(4,AddressLine1);
       st.setString(5,AddressLine2);
       
       if(st.executeUpdate()>k){
           JOptionPane.showMessageDialog(null,Email+" registered successful");
       }
           
       
   }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    
}
         
     }
        public void insertUserAccount(String Fullname,String Password,String Institution) {
String q="INSERT into useraccount(fullname,password,institution) VALUES(?,?,?)";
int k=0;
try{
       java.sql.PreparedStatement st=getConnection().prepareStatement(q);
       st.setString(1,Fullname);
       st.setString(2,Password);
       st.setString(3,Institution);
       if(st.executeUpdate()>k){
           JOptionPane.showMessageDialog(null,Fullname+" registered successful");
           StudentSystem student = new StudentSystem();
           LogInForm login = new LogInForm();
           login.dispose();
           student.setVisible(true);
       }
           
       
   }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    
}
        }  
        public void deleteStudentBiography(String studentId ){
        String q="DELETE FROM biography WHERE studentid=?";
        int k=0;
        try {
            java.sql.PreparedStatement st=getConnection().prepareStatement(q);
            
            st.setString(1,studentId);
            
            if(st.executeUpdate()>k){
           JOptionPane.showMessageDialog(null,studentId+" Deleted successful");
        } 
        }
            
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
              }
    }
        public void deleteStudentContactInformation(String Phone ){
        String q="DELETE FROM contactinformation WHERE phone=?";
        int k=0;
        try {
            java.sql.PreparedStatement st=getConnection().prepareStatement(q);
            
            st.setString(1,Phone);
            
            if(st.executeUpdate()>k){
           JOptionPane.showMessageDialog(null,Phone+" Deleted successful");
        } 
        }
            
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
              }
    }
         public void UpdateStudentBiography(String fName,String lName,String studentId,String gender,String birthDate,String courseName){
    String q="UPDATE biography SET firstname=?,lastname=?,gender=?,birthdate=?,coursename=? WHERE studentid=?";
    int k=0;
    try{
       
        
        java.sql.PreparedStatement st=getConnection().prepareStatement(q);
       st.setString(1,fName);
       st.setString(2,lName);
       st.setString(3,studentId);
       st.setString(4,gender);
       st.setString(5,birthDate);
       st.setString(6,courseName);
      
       if(st.executeUpdate()>k){
           JOptionPane.showMessageDialog(null,"Student Record Updated successful");
       }
           
       
   }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    
}
    
    
}
  public ResultSet getStudentsBiography(){
         String q="SELECT * FROM biography";
         try{
             Statement st=getConnection().createStatement();
             ResultSet rs=st.executeQuery(q);
             return rs;
         }
         catch(SQLException x){
              JOptionPane.showMessageDialog(null, x.getMessage());
              return null;
         }
         }
       public ResultSet getStudentsContact(){
         String q="SELECT * FROM contactinformation";
         try{
             Statement st=getConnection().createStatement();
             ResultSet rs=st.executeQuery(q);
             return rs;
         }
         catch(SQLException x){
              JOptionPane.showMessageDialog(null, x.getMessage());
              return null;
         }
         }       
     
}
