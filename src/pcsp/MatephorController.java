/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcsp;

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
public class MatephorController implements Initializable {

    User u = new User("ALi", 33, "966551138844", 1);
    User u1 = new User("ALi",  34, "966551138844", 1);
    User u2 = new User("ALi",  35, "966551138844", 1);
    User u3 = new User("ALi", 36, "966551138844", 1);
    User u4 = new User("ALi", 37, "966551138844", 1);

    @FXML
    private AnchorPane Matephor;
    @FXML
    private Button NextToMatephor_1;
    @FXML
    private TextField IdCode;
    @FXML
    private Label errorLable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLable.setVisible(false);

        // TODO
    }

    @FXML
    private void NextToMatephor_1(ActionEvent event) throws IOException {

        if (IdCode(event) == true) {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Matephor_1.fxml"));
            pane.setPrefSize(Matephor.getWidth(), Matephor.getHeight());
            System.out.println(Matephor.getWidth() + "  " + Matephor.getHeight());
            Matephor.getChildren().setAll(pane);
        } else {
            errorLable.setVisible(true);
            IdCode.setText(null);
        }
    }

    @FXML
    private void Matephor(MouseEvent event) {
    }

    @FXML
    private boolean IdCode(ActionEvent event) {

        if (IdCode.getText().equals(u.key) || IdCode.getText().equals(u1.key) || IdCode.getText().equals(u2.key)
                || IdCode.getText().equals(u3.key) || IdCode.getText().equals(u4.key)) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    private void errorLable(MouseEvent event) {
    }
}
