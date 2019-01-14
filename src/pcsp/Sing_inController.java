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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ali
 */
public class Sing_inController implements Initializable {

    @FXML
    private AnchorPane Mine_bane_Sning;
    @FXML
    private PasswordField PassordText;
    @FXML
    private TextField NameText;
    @FXML
    private Button close;
    @FXML
    private Button ok;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void PassordText(ActionEvent event) {
    }

    @FXML
    private void NameText(DragEvent event) {
    }

    @FXML
    private void close(ActionEvent event) {
    }

    @FXML
    private void ok(ActionEvent event) {
           try { 
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainAdmin.fxml"));
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
                   stage.setFullScreen(true);

            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Cant load new window");
        }
        
    }

    @FXML
    private void Mine_bane_Sning(MouseEvent event) {
    }
    
}
