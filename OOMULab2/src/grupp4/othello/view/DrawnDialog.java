/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Class for Displaying DrawnDialog. 
 * 
 */
public class DrawnDialog {
    
    
    /**
     * Displays DrawnDialog
     */
    public void DisplayDrawDialog(){
        Platform.runLater(()->{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tie!");
        alert.setHeaderText(null);
        alert.setContentText("The game resulted in a Tie." );
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/resources/reversi_icon.png").toString()));
        
        alert.showAndWait();
        });
    }
}
