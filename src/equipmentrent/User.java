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
public class User {
    
    public String name,phone;
    public int level,id,key;

    public User(String name, int id, int key, String phone, int level) {
        this.name = name;
        this.id = id;
        this.key = key;
        this.phone = phone;
        this.level = level;
    }
    
    public User(String key){
        this.key=key;
    }
}
