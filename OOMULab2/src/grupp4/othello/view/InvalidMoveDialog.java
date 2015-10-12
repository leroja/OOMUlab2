/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import javafx.scene.control.Alert;

/**
 *
 * @author alexander
 */
public class InvalidMoveDialog {
    
    public void DisplayInvalidMoveDialog(){
     Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Invalid Move!!!");
    alert.setHeaderText(null);
    alert.setContentText("Invalid move. Pleas redo you'r move." );
    
    alert.showAndWait();
 } 
}
