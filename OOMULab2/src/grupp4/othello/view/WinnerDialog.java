/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Lennart
 */
public class WinnerDialog {
    
    public void displayWinnerDialog(String player){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner!");
        alert.setHeaderText(null);
        alert.setContentText("Congratulations! " + player + " you won the game." );

        alert.showAndWait();
    } 
}
