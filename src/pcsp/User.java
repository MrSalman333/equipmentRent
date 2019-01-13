/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcsp;

/**
 *
 * @author MrS
 */
public class User {
    
    public String name,id,key,phone;
    public int level;
    
    public User(String name, String id, String key, String phone, int level) {
        this.name = name;
        this.id = id;
        this.key = key;
        this.phone = phone;
        this.level = level;
    }

   
}
