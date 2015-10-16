/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;



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
    
    
    
    public Pair<String, String> setPlayer1(){
        
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Set Player 1");
        dialog.setHeaderText(null);
        
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        
        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        
        TextField name = new TextField("Player 1");
        
        grid.add(name,0,4);
        grid.add(new Label("Name:"),0,3);
        grid.add(new Label("Human or Computer:"), 0, 1);
        
        
        ObservableList choices = FXCollections.observableArrayList("Human", "Computer");
        ChoiceBox cbox = new ChoiceBox(choices);
        cbox.setValue("Human");
        grid.add(cbox, 0, 2);
        
        dialog.getDialogPane().setContent(grid);
        
        dialog.setResultConverter(dialogButton -> {
        if (dialogButton == ButtonType.OK) {
            return new Pair<>(name.getText(), cbox.getSelectionModel().getSelectedItem().toString());
        }
        return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        if (result.isPresent()) { 
            return result.get(); 
        }
        return new Pair<>("Player 1","Human");
    }
    
        public Pair<String, String> setPlayer2(){
        
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Set Player 2");
        dialog.setHeaderText(null);
        
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        
        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        
        TextField name = new TextField("Player 2");
        
        grid.add(name,0,4);
        grid.add(new Label("Name:"),0,3);
        grid.add(new Label("Human or Computer:"), 0, 1);
        
        
        ObservableList choices = FXCollections.observableArrayList("Human", "Computer");
        ChoiceBox cbox = new ChoiceBox(choices);
        cbox.setValue("Computer");
        grid.add(cbox, 0, 2);
        
        dialog.getDialogPane().setContent(grid);
        
        dialog.setResultConverter(dialogButton -> {
        if (dialogButton == ButtonType.OK) {
            return new Pair<>(name.getText(), cbox.getSelectionModel().getSelectedItem().toString());
        }
        return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        if (result.isPresent()) { 
            return result.get(); 
        }
        return new Pair<>("Player 2","Computer");
    }
    
    
    
}
