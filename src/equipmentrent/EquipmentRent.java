/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipmentrent;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author MrS
 */
public class EquipmentRent extends Application {

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        Button btn = new Button();
        btn.setText("Test The DataBase");
        //User.creatUser("سلمان الراجحي", 1100, "0537243511", 1);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                Random r = new Random();
                User u = User.creatUser("salman new key", r.nextLong(), "05", 43);
                Equipment e = new Equipment(3, 32, "first Camera", "dsasac2fsa", true);
                u.rent(e);
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(EquipmentRent.class.getName()).log(Level.SEVERE, null, ex);
                }
                u.returnRent(e);
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        test();
        //launch(args);

    }

    public static void test() throws InterruptedException {

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
        Thread.sleep(1000);
        if (user.returnRent(equpment)) {
            System.out.println("user.returnRent works!");
        } else {
            System.out.println("user.returnRent dosn't work!");
        }
        
        System.out.println("");
        System.out.println("!-------------RENT EQUPMENT--------------!");
        
        if (user.rent(equpment)) {
            System.out.println("user.rent works!");
        } else {
            System.out.println("user.rent dosn't work!");
        }
        Thread.sleep(1000);
        if (user.returnRent(equpment,"some damge")) {
            System.out.println("user.returnRent works!");
        } else {
            System.out.println("user.returnRent dosn't work!");
        }
        
        System.out.println("");
        System.out.println("!-------------RENT WITH DAMAGE EQUPMENT--------------!");

    }

}
