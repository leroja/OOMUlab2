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
 * Class For Displaying InvalidMoveDialog
 * 
 */
public class InvalidMoveDialog {
    
    /**
     *Displays InvalidMoveDialog 
     */
    public void DisplayInvalidMoveDialog(){
        Platform.runLater(()->{
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Move!!!");
        alert.setHeaderText(null);
        alert.setContentText("Invalid move. Please redo your move." );
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/resources/reversi_icon.png").toString()));
        
        alert.showAndWait();
        });
    } 
}
