/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipmentrent;
import java.security.PublicKey;
import java.sql.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnDB {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/equipmentrent";
    
    private Connection con ;
    private Statement stat;
    private ResultSet rs ;
    
    public ConnDB(){
        try  {
           //Class.forName("com.mysql.cj.jdbc.Driver");
           
           con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
           stat = con.createStatement();
           
            System.out.println("database DONE!!!!");
        }
        catch(Exception e){
           System.err.println("myError"+e);
        }
    }
    
    public String update(User user){
        String query = "SELECT * FROM user WHERE jucId =" + user.id;
        try {
            rs = stat.executeQuery(query);

            if (rs.first()) {
                System.out.println("some data");
                System.out.println(rs.getString(1));
                System.out.println(rs.getString("jucId"));
            }else{
                System.out.println("no data");
            }

            while(rs.next()){
                
            }

            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return "";
    }
    public void getData(User user){
        String query = "SELECT * FROM user WHERE jucId =" + user.id;
        try {
            rs = stat.executeQuery(query);

            if (rs.first()) {
                System.out.println("the user is there");
                user.id = rs.getString("jucId");
                user.name = rs.getString("name");
                user.level = rs.getInt("level");
                user.phone = rs.getString("phone");
            }else{
                System.out.println("no data");
            }

            while(rs.next()){
                
            }

            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    
    }
    
    public void insertData(String id,String name,String mood){
         
        try {
            stat= con.createStatement();
            String sql = "insert into tabletest"
                       + "(id ,name , mood)"
                       + " values ("+"'"+id+"'"+","+"'"+name+"'"+","+"'"+mood+"')";
            
            stat.execute(sql);
            System.out.println("inserted");
            }
        
        catch(Exception e){
           System.err.println("Error "+e);
        }
        
    
    }    
}