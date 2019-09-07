/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipmentrent;

import com.keepautomation.barcode.BarCode;
import com.keepautomation.barcode.IBarCode;
import java.sql.Timestamp;

/**
 *
 * @author MrS
 */
public class User {

    public String name, phone;
    public long id, key;
    public int level;
    public boolean ready;
    public Equipment[] equipments;

    private User(String name, long id, String phone, int level) {
        this.name = name;
        this.id = id;
        this.key = 0;
        this.phone = phone;
        this.level = level;
    }

    private User(long key) {
        this.key = key;
        ready = false;
    }
    
    public static User getUser(String key){
        User user = new User(Long.parseLong(key));
        
        if ((new ConnDB().getData(user))) {
            System.out.println("there is a user with this ID ");
            user.ready = true;
        }else{
            System.out.println("no such user \"key error\" ");
        }
        
        if ((new ConnDB().getRentedEquipments(user))) {
            System.out.println("there are some equpmints ");
        }else{
            System.out.println("no equpments ");
        }    
        return user;
    }

    public static User creatUser(String name, long id, String phone, int level) {
        User u = new User(name, id, phone, level);
        if ((new ConnDB().getData(u))) {
            System.out.println("there is a user with this ID ERROR");
            return null;
        }

        System.out.println("crat user random key");
        ConnDB cn = new ConnDB();
        int key;
        String barrcode = null;
        do {
            barrcode = "";
            while (barrcode.length() < 18) {
                key = (int) (Math.random() * 999999);
                barrcode += key;
            }
            barrcode = barrcode.substring(barrcode.length() - 18); //creat a random key  with length 12
            u.key = Long.parseLong(barrcode);
        } while (!cn.update(u));
        makeBarCode(barrcode, u.id);

        return u;
    }

    private static void makeBarCode(String barrcode, long id) {
        BarCode barcode = new BarCode();
        barcode.setCodeToEncode(barrcode);
        barcode.setSymbology(IBarCode.CODE128A);
        barcode.setX(2);
        barcode.setY(50);
        barcode.setRightMargin(0);
        barcode.setLeftMargin(0);
        barcode.setTopMargin(0);
        barcode.setBottomMargin(0);
        barcode.setChecksumEnabled(true);
        barcode.setDisplayText(false);
        barcode.setFnc1(IBarCode.FNC1_NONE);
        try {
            barcode.draw(id + ".gif");
        } catch (Exception e) {
            System.out.println("shit");
        }

    }
    
    public boolean rent(Equipment e) {
        if (e.id == 0) {
            System.out.println("no id in the equpmit object");
            return false;
        }

        return (new ConnDB()).update(new Rent(id, e.id)); //inserting into DB
    }

    public boolean returnRent(Equipment e) {
        if (e.id == 0) {
            System.out.println("no id in the equpmit object");
            return false;
        }
        ConnDB db =  new ConnDB();
        Rent cloaseRent = new Rent(id, e.id);
        db.getOpenRent(cloaseRent);
        cloaseRent.checkIn = new Timestamp(System.currentTimeMillis());
        db.update(cloaseRent);
        
        return db.update(cloaseRent); //updating into DB
    }
}
