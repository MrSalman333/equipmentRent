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
public class Damage {
    
    public int id , equId    , rentId ;
    public String description,imgPath;
    public java.sql.Timestamp timeStamp;
    private final static String THEPATH = "some path";
    public long userId;

    public Damage(int id, int equId, long userId, int rentId, String description) {
        this.id = id;
        this.equId = equId;
        imgPath = THEPATH+id;
        this.userId = userId;
        this.rentId = rentId;
        this.description = description;
    }
    public Damage( int equId, long userId, int rentId, String description) {
        
        this.equId = equId;
        imgPath = THEPATH+id;
        this.userId = userId;
        this.rentId = rentId;
        this.description = description;
    }
    
    
    
    
}
