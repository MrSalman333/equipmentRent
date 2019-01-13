/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcsp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ali
 */
public class Matephor_2Controller implements Initializable {
            Equipments c3 = new  Equipments(4, "444", "camera", "121", true);
    @FXML
    private Label labelShow;
    @FXML
    private CheckBox cheackboks;
    @FXML
    private Button ok;
    @FXML
    private Button exit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        labelShow.setText(toString());
    }    
   public String toString ()
   {
       return   " إسم القطعة : "+c3.name + "\n"+ "رقم القطعة :" + c3.id;
   }

    @FXML
    private void labelShow(MouseEvent event) {
    }

    @FXML
    private void cheackboks(ActionEvent event) {
    }

    @FXML
    private void ok(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
    }
           }
