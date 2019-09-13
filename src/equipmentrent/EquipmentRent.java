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
        front.MainJFrame.main(args);
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    static String[] args;
    public static void main(String[] a) throws InterruptedException {
        args = a;
        launch(args);

    }

    

}
