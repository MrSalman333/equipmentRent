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

    private Connection con;
    private Statement stat;
    private ResultSet rs;

    public ConnDB() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            stat = con.createStatement();

            System.out.println("database DONE!!!!");
        } catch (Exception e) {
            System.err.println("myError" + e);
        }
    }

    public boolean update(User user) {
        String query = "SELECT * FROM user WHERE keyId =" + user.key; //searsh from data with this ID
        try {
            rs = stat.executeQuery(query);

            if (rs.first()) {//cheack if there is any data returned from the DataBase
                System.out.println("The User alrady exists");
                
                if (user.key == rs.getInt("keyId") //cheack if all the data from the caller is the same as in the DataBase
                    && user.id == rs.getInt("jucId")
                    && user.level == rs.getInt("level")
                    && user.name.equals(rs.getString("name"))
                    && user.phone.equals(rs.getString("phone"))) {
                    System.out.print(" and there are no defrinces!");
                    return false;
                    
                } else {
                    System.out.println(" and there are some difrncess");
                    try {
                        stat.execute("UPDATE user SET name='" + user.name + "', level=" + user.level + ", phone='" + user.phone + "' WHERE jucId =" + user.id);
                        //updated the data in the DataBase
                        return true;
                    } catch (SQLException sQLException) {
                        System.out.println("error while updating" + sQLException.getMessage());
                        return false;
                    }
                   
                }
            } else { //the user is not in the DataBase
                System.out.println("Trying to insert");
                return insertData(user);
            }

        } catch (SQLException ex) {
            System.out.println("error while cheacking the data" + ex.getMessage());
            return false;
        }


    }
    
    public boolean insert(Rent r){
        try {
            stat.execute("INSERT INTO `rent`(`equId`, `userId`) VALUES"
                    + " ("+ r.equId +","+ r.userId +")");
            System.out.println("inserted");
            return true;
        } catch (Exception e) {
            System.err.println("insertData Error " + e);
            return false;
        }
    }

    public boolean getData(User user) {
        String query;
        if(user.key != 0)
            query = "SELECT * FROM user WHERE keyId =" + user.key;
        else if(user.key != 0)
            query = "SELECT * FROM user WHERE id =" + user.id;
        else{
            System.out.println("there is no key nore id");
            return false;
        }
            

        try {
            rs = stat.executeQuery(query);

            if (rs.first()) {
                System.out.println("the user is there");
                user.id = rs.getInt("jucId");
                user.name = rs.getString("name");
                user.level = rs.getInt("level");
                user.phone = rs.getString("phone");
                user.key = rs.getLong("keyId");
                return true;
            } else {
                System.out.println("no data");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    

    private boolean insertData(User user) {
        try {
            stat.execute("INSERT INTO `user`(`keyId`, `jucId`, `name`, `level`, `phone`) VALUES"
                    + " ("+ user.key +","+ user.id +",'"+ user.name +"',"+ user.level +",'"+ user.phone +"')");
            System.out.println("inserted");
            return true;
        } catch (Exception e) {
            System.err.println("insertData Error " + e);
            return false;
        }
    }
    

}
