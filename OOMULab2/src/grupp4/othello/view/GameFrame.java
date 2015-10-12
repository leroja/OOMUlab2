/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Lennart
 */
public class GameFrame {
    
    public void displayGameFrame(Stage primaryStage){
        Button nyttParti = new Button("Nytt parti");
        GameBoard board = new GameBoard();
        nyttParti.setPrefSize(70,35);
        Button avsluta = new Button("Avsluta");
        avsluta.setPrefSize(70, 35);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(nyttParti,avsluta);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10));
        BorderPane border = new BorderPane();
        border.setRight(vbox);
        border.setCenter(board.getGridPane());
    
    
        Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/reversi_icon.png")));
        primaryStage.setTitle("Othello");
        primaryStage.show();
    }
    
    
    }

