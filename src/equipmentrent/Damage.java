/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipmentrent;

/**
 *
 * @author MrS
 */
public class Damage {
    
    public String id, description , equId , imgPath , userId , rentId ;

    public Damage(String id, String description, String equId, String imgPath, String userId, String rentId) {
        this.id = id;
        this.description = description;
        this.equId = equId;
        this.imgPath = imgPath;
        this.userId = userId;
        this.rentId = rentId;
    }
    
    
    
    
}
