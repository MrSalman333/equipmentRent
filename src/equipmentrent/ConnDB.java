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
import java.util.ArrayList;
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
            
            try {
                if(con != null)
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            //if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            //}
            //if (stat == null || stat.isClosed()) {
            stat = con.createStatement();
            //}

            //System.out.println("database DONE!!!!");
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

    public boolean update(Rent r) {
        String query = "SELECT * FROM rent WHERE id =" + r.id; //searsh from data with this ID
        try {
            rs = stat.executeQuery(query);

            if (rs.first()) {//cheack if there is any data returned from the DataBase
                System.out.println("The Rent alrady exists");

                if (r.id == rs.getInt("id") //cheack if all the data from the caller is the same as in the DataBase
                        && r.checkIn.equals(rs.getTimestamp("checkIn")) 
                        && r.equId == rs.getInt("equId")
                        && r.userId == rs.getBigDecimal("userId").longValue()) {
                    System.out.print(" and there are no defrinces!");
                    return false;
                } else {
                    System.out.println(" and there are some difrncess");
                    try {
                        if (stat.execute("UPDATE rent SET open=0 WHERE id=" + r.id)) {
                            System.out.println("false");
                        }
                        //updated the data in the DataBase
                        return true;
                    } catch (SQLException sQLException) {
                        System.out.println("error while updating" + sQLException.getMessage());
                        return false;
                    }
                }
            } else { //the user is not in the DataBase
                System.out.println("Trying to insert");
                stat.execute("INSERT INTO `rent`(`id`, `equId`, `userId`) VALUES"
                        + " (" + r.id + "," + r.equId + "," + r.userId + ")");
                System.out.println("inserted");
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("error while cheacking the data" + ex.getMessage());
            return false;
        }
    }

    public boolean getData(User user) {
        String query;
        if (user.key != 0) {
            query = "SELECT * FROM user WHERE keyId =" + user.key;
        } else if (user.id != 0) {
            query = "SELECT * FROM user WHERE jucId =" + user.id;
        } else {
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

    public boolean getData(Equipment e) {
        String query;
        if (e.id != 0) {
            query = "SELECT * FROM equipmentrent WHERE id =" + e.id;
        } else {
            System.out.println("no such equipment \"id error\" ");
            return false;
        }

        try {
            rs = stat.executeQuery(query);

            if (rs.first()) {
                System.out.println("the equipment is there");
                e.name = rs.getString("name");
                e.level = rs.getInt("level");
                e.model = rs.getString("model");
                e.available = rs.getInt("available") == 1;
                e.damges = new ConnDB().getDamges(e.id);

                return true;
            } else {
                System.out.println("no data");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Damage[] getDamges(int id) {
        String query;
        Damage[] damges;
        if (id != 0) {
            query = "SELECT * FROM damage WHERE equId =" + id;
        } else {
            System.out.println("there is no id fo equ");
            return null;
        }

        try {
            rs = stat.executeQuery(query);
            ArrayList<Damage> damgesArray = new ArrayList<>();

            while (rs.next()) {
                System.out.println("there are some damges");
                Damage damage = new Damage(
                        rs.getInt("id"),
                        rs.getInt("equId"),
                        rs.getInt("userId"),
                        rs.getInt("rentId"),
                        rs.getString("description"),
                        rs.getTimestamp("time"));

                damgesArray.add(damage);
            }
            damges = damgesArray.toArray(new Damage[damgesArray.size()]);

        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return damges;
    }

    public boolean getRentedEquipments(User user) {

        String query;
        if (user.id != 0) {
            query = "SELECT * FROM equipmentrent WHERE rentedBy =" + user.id;
        } else {
            System.out.println("there is no id");
            return false;
        }

        try {
            rs = stat.executeQuery(query);
            ArrayList<Equipment> equipmentsArray = new ArrayList<>();

            while (rs.next()) {
                System.out.println("there are some Equipments");
                Equipment equipment = new Equipment(
                        rs.getInt("level"),
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("model"),
                        false);

                equipmentsArray.add(equipment);
            }
            user.equipments = equipmentsArray.toArray(new Equipment[equipmentsArray.size()]);

        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public boolean getOpenRent(Rent r) {
        String query;
        query = "SELECT * FROM rent WHERE (equId =" + r.equId + " AND userId=" + r.userId + ")";

        try {
            rs = stat.executeQuery(query);
            while (rs.next()) {
                //System.out.println("while");
                if (rs.getInt("open") == 1) {
                    System.out.println("the rent is there");
                    r.id = rs.getInt("id");
                    r.checkOut = rs.getTimestamp("checkOut");
                    r.equId = rs.getInt("equId");
                    r.userId = rs.getBigDecimal("userId").longValue();
                    return true;
                } else {
                    //System.out.println("checkin = " + rs.getTimestamp("checkIn").toString());
                }
            }

            System.out.println("no open Rent");
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private boolean insertData(User user) {
        try {
            stat.execute("INSERT INTO `user`(`keyId`, `jucId`, `name`, `level`, `phone`) VALUES"
                    + " (" + user.key + "," + user.id + ",'" + user.name + "'," + user.level + ",'" + user.phone + "')");
            System.out.println("inserted");
            return true;
        } catch (Exception e) {
            System.err.println("insertData Error " + e);
            return false;
        }
    }

}
