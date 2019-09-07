/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipmentrent;



public class Equipment {
    public int level,id;
    public String name,model,rentedBy;
    public boolean available;
    public Damage[] damges;

    public Equipment(int level, int id, String name, String model, boolean available,String rentedBy) {
        this.level = level;
        this.id = id;
        this.name = name;
        this.model = model;
        this.available = available;
        this.rentedBy = rentedBy;
        
        damges = new ConnDB().getDamges(id); 
    }
    
    public Equipment(int level, int id, String name, String model, boolean available) {
        this.level = level;
        this.id = id;
        this.name = name;
        this.model = model;
        this.available = available;
        
        damges = new ConnDB().getDamges(id); 
    }

    public Equipment(int id) {
        this.id = id;
    }
    
    public static Equipment getEquipment(int id){
        Equipment e = new Equipment(id);
        
        if ((new ConnDB().getData(e))) {
            System.out.println("there is an equipment with this ID ");
        }else{
            System.out.println("can't get equpment error");
        }
           
        return e;
    }
    
    

    
}
