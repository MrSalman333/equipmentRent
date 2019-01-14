/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcsp;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ali
 */
public class Delivery_1Controller  implements Initializable {
    
    @FXML
    private ScrollPane PaneOfshow;
    @FXML
    private AnchorPane AnchorPanes;
    @FXML
    private VBox Vbox;
    
            
       @Override
       public void initialize(URL url, ResourceBundle rb) {
             final Random rng = new Random();
                     PaneOfshow.setFitToWidth(true);
        for (int i = 0; i < 6; i++) 
 {         
           AnchorPane  v = new AnchorPane();
              String style = String.format("-fx-background:  #800000;"+
                    "-fx-background-color: #800000;"+"-fx-border-color: #FFE4E1;"+
                     "-fx-border-width:15;"
                      +"-fx-padding:45;",
                    rng.nextInt(256),
                    rng.nextInt(256),
                    rng.nextInt(256));
            v.setStyle(style);
            Label label = new Label("Pane "+(Vbox.getChildren().size()+1));
            AnchorPane.setLeftAnchor(label, 5.0);
            AnchorPane.setTopAnchor(label, 5.0);
            Button button = new Button("Remove");
            button.setOnAction(evt -> Vbox.getChildren().remove(v));
            AnchorPane.setRightAnchor(button, 5.0);
            AnchorPane.setTopAnchor(button, 5.0);
            AnchorPane.setBottomAnchor(button, 5.0);
            v.getChildren().addAll(label, button);
            Vbox.getChildren().add(v);
      
 };




       }
        }   // TODO




        

    

