/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import javafx.scene.control.Alert;

/**
 *
 * @author Lennart
 */
public class DrawnDialog {
    
    public void DisplayDrawDialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tie!");
        alert.setHeaderText(null);
        alert.setContentText("The game resulted in a Tie." );

        alert.showAndWait();
    }
}
