/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcsp;

import equipmentrent.ConnDB;
import equipmentrent.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ali
 */

  
public class DeliveryController implements Initializable {
    
    
    ConnDB con = new ConnDB();
    
    @FXML
    private Button NextToDelivery_1;
    @FXML
    private AnchorPane Delivery;
    @FXML
    private TextField idCode;
    @FXML
    private Label errorLable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLable.setVisible(false);  // TODO
       
        
    }

    @FXML
    private void NextToDelivery_1(ActionEvent event) throws IOException {
        if (idCode(event) == true) {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Delivery_1.fxml"));
            pane.setPrefSize(Delivery.getWidth(), Delivery.getHeight());
            System.out.println(Delivery.getWidth() + "  " + Delivery.getHeight());
            Delivery.getChildren().setAll(pane);
        } else {
            errorLable.setVisible(true);
            idCode.setText(null);
        }
    }

    @FXML
    private void Delivery(MouseEvent event) {

    }

    @FXML
    private boolean idCode(ActionEvent event) {
        User u = new User(idCode.getText());
        if (con.getData(u)) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    private void errorLable(MouseEvent event) {
    }

}
