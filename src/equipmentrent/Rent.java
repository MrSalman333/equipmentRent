/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipmentrent;

import java.sql.Timestamp;

/**
 *
 * @author MrS
 */
public class Rent {
    public Timestamp checkOut , checkIn ;
    public int equId , id,open;
    public long userId;
    

    public Rent(long userId, int equId) {
        this.userId = userId;
        this.equId = equId;
        this.id = 0;
        open = 0;
        checkIn = checkOut  = new Timestamp(0);
    }
    
    public Damage getDamage(String d){
        return new Damage(equId, userId, id, d);
    }
    
    
    
    
}
