/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipmentrent;



public class Equipments {
    public int level,id;
    public String name,model;
    public boolean available;

    public Equipments(int level, int id, String name, String model, boolean available) {
        this.level = level;
        this.id = id;
        this.name = name;
        this.model = model;
        this.available = available;
    }

    
}
