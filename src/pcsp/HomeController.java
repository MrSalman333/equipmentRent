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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ali
 */
public class HomeController implements Initializable {

    @FXML
    private Button SngIn;
    @FXML
    private AnchorPane Mine_bane;
    @FXML
    private Button Matephor;
    @FXML
    private Pane show_pane;
    @FXML
    private Button Delivery;
    @FXML
    private Button help_home;
    @FXML
    private Button Home;
    @FXML
    private Label PcLable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        // TODO
    }    

    @FXML
    private void SngIn(ActionEvent event) {
 
          try { 
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Sing_in.fxml"));
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Cant load new window");
        }
        
    }

    @FXML
    private void Matephor(ActionEvent event) throws IOException {
                try{
                 PcLable.setVisible(false);
                 AnchorPane pane = FXMLLoader.load(getClass().getResource("Matephor.fxml"));
                 pane.setPrefSize(show_pane.getWidth(), show_pane.getHeight());
                 System.out.println(show_pane.getWidth() +"  "+ show_pane.getHeight());
                  show_pane.getChildren().setAll(pane);
                 }catch (Exception e){
            System.out.println("Cant load new window");
        }
    }

    @FXML
    private void show_pane(MouseEvent event) {
      
    }

    @FXML
    private void Delivery(ActionEvent event) throws IOException {
        try{
        PcLable.setVisible(false);    
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Delivery.fxml"));
             pane.setPrefSize(show_pane.getWidth(), show_pane.getHeight());
             System.out.println(show_pane.getWidth() +"  "+ show_pane.getHeight());
             show_pane.getChildren().setAll(pane);
              }catch (Exception e){
            System.out.println("Cant load new window");
    }
    }
    @FXML
    private void help_home(ActionEvent event) throws IOException {
            try{
            PcLable.setVisible(false);    
            AnchorPane pane = FXMLLoader.load(getClass().getResource("HelpHome.fxml"));
             pane.setPrefSize(show_pane.getWidth(), show_pane.getHeight());
             System.out.println(show_pane.getWidth() +"  "+ show_pane.getHeight());
             show_pane.getChildren().setAll(pane);
                   }catch (Exception e){
            System.out.println("Cant load new window");
    }
        
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Home.fxml"));
             pane.setPrefSize(Mine_bane.getWidth(), Mine_bane.getHeight());
             System.out.println(Mine_bane.getWidth() +"  "+ Mine_bane.getHeight());
             Mine_bane.getChildren().setAll(pane);
    }

    @FXML
    private void PcLable(MouseEvent event) {
    }
    
}
