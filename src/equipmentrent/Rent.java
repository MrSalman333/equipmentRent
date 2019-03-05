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
public class Rent {
    long checkOut , checkIn ,userId;
    int equId , id;

    public Rent(long userId, int equId) {
        this.userId = userId;
        this.equId = equId;
        this.id = 0;
        checkIn = checkOut  = 0;
    }
    
    
    
    
}
