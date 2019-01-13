/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcsp;

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
public class Matephor_1Controller implements Initializable {
            Equipments c = new  Equipments(1, "111", "camera", "121", true);
            Equipments c1 = new  Equipments(2, "222", "camera", "121", true);
            Equipments c2 = new  Equipments(3, "333", "camera", "121", false);
            Equipments c3 = new  Equipments(4, "444", "camera", "121", true);
            Equipments c4 = new  Equipments(5, "444", "camera", "121", false);
            User u = new User("ALi", "33", "33", "966551138844", 1);
            User u1 = new User("ALi", "34", "34", "966551138844", 2);
            User u2 = new User("ALi", "35", "35", "966551138844", 3);
            User u3 = new User("ALi", "36", "36", "966551138844", 4);
            User u4 = new User("ALi", "37", "37", "966551138844", 5);
              
    @FXML
    private Button Next_Matephor_2;
    @FXML
    private AnchorPane Matephor_12;
    @FXML
    private TextField itemTextFile;
    @FXML
    private Label error1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
                            error1.setVisible(false);


        
        // TODO
    }    

    @FXML
    private void Next_Matephor_2(ActionEvent event) throws IOException {
        if (itemTextFile(event)==true)
        {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Matephor_2.fxml"));
            pane.setPrefSize(Matephor_12.getWidth(), Matephor_12.getHeight());
            Matephor_12.getChildren().setAll(pane);
        }
        else
        {
              error1.setVisible(true);
            itemTextFile.setText(null);
        }
      
    }

    @FXML
    private void Matephor_12(MouseEvent event) {
    }

    @FXML
    private boolean itemTextFile(ActionEvent event) {
           if ((itemTextFile.getText().equals(c.id)&&c.available==true&&c.level>3)||(itemTextFile.getText().equals(c1.id)&&c1.available==true&&true&&c1.level>3)
                ||(itemTextFile.getText().equals(c2.id)&&c2.available==true&&true&&c2.level>3)||(itemTextFile.getText().equals(c3.id)&&c3.available
                   ==true&&true&&c3.level>3)||(itemTextFile.getText().equals(c4.id)&&c4.available==true&&true&&c4.level>3)) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    private void error1(MouseEvent event) {
    }
    
}
