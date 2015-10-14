/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;



/**
 *
 * @author Lennart
 */
public class SetUpGameDialog {
    
    public String player1Name(){
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Player 1 name");
        dialog.setHeaderText(null);
        dialog.setContentText("Please enter Player 1's name:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) { 
            return result.get();
        }
        return "Player 1";
    }
    
    public String player2Name(){
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Player 2 name");
        dialog.setHeaderText(null);
        dialog.setContentText("Please enter Player 2's name:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) { 
            return result.get();
        }
        return "Player 2";
    }
    
    public String player1Type(){
        List<String> choices = new ArrayList<>();
        choices.add("Human");
        choices.add("Computer");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Human", choices);
        dialog.setTitle("Player 1 type");
        dialog.setHeaderText(null); 
        dialog.setContentText("Choose Player 1's Type:"); 
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) { 
            return result.get(); 
        }
        return "Human";
    }
    
    public String player2Type(){
        List<String> choices = new ArrayList<>();
        choices.add("Human");
        choices.add("Computer");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Computer", choices);
        dialog.setTitle("Player 2 type");
        dialog.setHeaderText(null); 
        dialog.setContentText("Choose Player 2's Type:"); 
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) { 
            return result.get(); 
        }
        return "Computer";
    }
    
}
