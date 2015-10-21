/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;


/**
 *
 * @author Lennart
 */
public class SetUpGameDialog {
    
    /**
     * fires up a custom dialog that lets the user set the name and type of the player
     * @return a pair that contains the name and the type of the player
     */
    public Pair<String, String> setPlayer1(){
        
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Set Player 1");
        dialog.setHeaderText(null);
        
        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/resources/reversi_icon.png").toString()));
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
    
    /**
     * fires up a custom dialog that lets the user set the name and type of the player
     * @return a pair that contains the name and the type of the player
     */
    public Pair<String, String> setPlayer2(){
        
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Set Player 2");
        dialog.setHeaderText(null);
        
        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/resources/reversi_icon.png").toString()));
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