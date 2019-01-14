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

    public String name, phone;
    public long id, key;
    public int level;

    public User(String name, long id, long key, String phone, int level) {
        this.name = name;
        this.id = id;
        this.key = key;
        this.phone = phone;
        this.level = level;
    }

    public User(int key) {
        this.key = key;
    }

    public static User creatUser(String name, int id, String phone, int level) {
        System.out.println("crat user random key");
        ConnDB cn = new ConnDB();
        User u;
        int key;
        String barrcode = null;
        do {            
            barrcode = "";
            while (barrcode.length() < 18) {
                key = (int) (Math.random() * 999999);
                barrcode += key;
            }
            barrcode = barrcode.substring(barrcode.length() - 18); //creat a random key  with length 12
            u = new User(name, id, Long.parseLong(barrcode), phone, level);
        } while (!cn.update(u));
        
        return u;
    }
}
