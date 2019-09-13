/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipmentrent;

import com.keepautomation.barcode.BarCode;
import com.keepautomation.barcode.IBarCode;

public class Equipment {

    public int level, id;
    public String name, model, rentedBy;
    public boolean available;
    public Damage[] damges;
    private static ConnDB cn ;

    public Equipment(int level, int id, String name, String model, boolean available, String rentedBy) {
        this.level = level;
        this.id = id;
        this.name = name;
        this.model = model;
        this.available = available;
        if ("".equals(rentedBy)) {
            this.rentedBy = null;
        } else {
            this.rentedBy = rentedBy;
        }
        if(cn == null)
            cn = new ConnDB();
        damges = cn.getDamges(id);
    }

    public Equipment(int level, int id, String name, String model, boolean available) {
        this.level = level;
        this.id = id;
        this.name = name;
        this.model = model;
        this.available = available;
        
        if(cn == null)
            cn = new ConnDB();
        damges = cn.getDamges(id);
    }

    public Equipment(int id) {
        this.id = id;
    }

    
    public static Equipment creatEquipment(String name, String model, int level) {
        System.out.println("create equipment random id");
        if(cn == null)
            cn = new ConnDB();
        
        int id;
        String barrcode = null;
        Equipment e;
        do {
            barrcode = "";
            while (barrcode.length() < 18) {
                id = (int) (Math.random() * 999999);
                barrcode += id;
            }
            barrcode = barrcode.substring(barrcode.length() - 6); //creat a random key  with length 18
            id = Integer.parseInt(barrcode);
            
            e = new Equipment(
                    level,
                    id,
                    name,
                    model,
                    true);
        } while (!cn.update(e));
        makeBarCode(barrcode, e.name);

        return e;
    }
    
    private static void makeBarCode(String barrcode, String name) {
        
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
            barcode.draw(name + ".gif");
        } catch (Exception e) {
            System.out.println("shit");
        }

    }
    
    public static Equipment getEquipment(int id) {
        Equipment e = new Equipment(id);

        if ((new ConnDB().getData(e))) {
            System.out.println("there is an equipment with this ID ");
            return e;
        } else {
            System.out.println("can't get equpment error");
            return null;
        }
    }

}
