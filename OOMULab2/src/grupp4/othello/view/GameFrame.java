/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        GameBoard board = new GameBoard();
        BorderPane border = new BorderPane();
        VBox vbox;
        vbox = getVBox();
                
     
        border.setRight(vbox);
        border.setCenter(board.getGridPane());
        Label currentPlayer = new Label("Temp");
        border.setBottom(currentPlayer);
    
    
        Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/reversi_icon.png")));
        primaryStage.setTitle("Othello");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
    
    
    public VBox getVBox(){
        Button nyttParti = new Button("Nytt parti");
        nyttParti.setPrefSize(70,35);
        NewGameEventHandler Game = new NewGameEventHandler();
        nyttParti.setOnAction(Game);
        
        Button avsluta = new Button("Avsluta");
        avsluta.setPrefSize(70, 35);
        ExitEventHandler exit = new ExitEventHandler();
        avsluta.setOnAction(exit);
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(nyttParti,avsluta);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10));
        
        return(vbox);
    }
    
    public class  ExitEventHandler implements EventHandler<ActionEvent> {
  
        @Override
    public void handle(ActionEvent event) {
        System.exit(0);
    }
    }
    public class NewGameEventHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event){
            System.out.println("New Game");
     
        }
        
    }
    
}

