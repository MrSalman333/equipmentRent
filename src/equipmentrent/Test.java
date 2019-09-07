/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipmentrent;

/**
 *
 * @author Salman
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("!-------------START TEST--------------!");
        User user = User.getUser("510445228399963851");
        System.out.println("");
        System.out.println("!-------------GET USER--------------!");
        Equipment equpment = Equipment.getEquipment(3321);
        System.out.println("");
        System.out.println("!-------------GET EQUPMENT--------------!");

        if (user.rent(equpment)) {
            System.out.println("user.rent works!");
        } else {
            System.out.println("user.rent dosn't work!");
        }
        System.out.println("");
        System.out.println("!-------------RENT--------------!");
        Thread.sleep(1000);
        if (user.returnRent(equpment)) {
            System.out.println("user.returnRent works!");
        } else {
            System.out.println("user.returnRent dosn't work!");
        }
        System.out.println("");
        System.out.println("!-------------RETURN RENT--------------!");
        
        user.rent(equpment);
        user.returnRent(equpment, "SOME DAMGE");
        System.out.println("");
        System.out.println("!-------------RENT AND RETUNR WITH DAMEGE--------------!");

    }

}
