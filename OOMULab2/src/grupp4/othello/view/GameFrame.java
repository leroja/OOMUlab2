/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import grupp4.othello.controller.ClickListener;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Lennart
 */
public class GameFrame {
    private GameBoard board;
    private BorderPane border;
    private Stage primaryStage;
    
    public GameFrame(Stage primaryStage){
        this.primaryStage = primaryStage;
        
        board = new GameBoard();
        border = new BorderPane();
        VBox buttonColumn, nbrCol;
        HBox hBox = getLetterRow();
        buttonColumn = getVBox();
        nbrCol = getNumberColumn();
        
        Label currentPlayer = new Label("Temp");    
        
        
        border.setTop(hBox);
        border.setLeft(nbrCol);
        border.setRight(buttonColumn);
        border.setCenter(board.getGridPane());
        border.setBottom(currentPlayer);
        
        Image image = new Image("/resources/sym57.cur");
        ImageCursor curs = new ImageCursor(image);
        border.setCursor(curs);
        
        
        Scene scene = new Scene(border);
        this.primaryStage.setScene(scene);
        
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/reversi_icon.png")));
        this.primaryStage.setTitle("Othello");
        this.primaryStage.setResizable(false);
        this.primaryStage.sizeToScene();
        
        this.primaryStage.show();
        
    }
    
    public void addli(ClickListener listener){
        board.addListener(listener);
    }
    
    public GameBoard getBoard(){
        return board;
    }
    
    private HBox getLetterRow(){
        HBox hBox= new HBox();
        
        for(char i= 'A';i < 'I';i++){
            StackPane square = new StackPane();
            square.setMinSize(50, 10);
            
            square.getChildren().add(new Label("" + i));  
            hBox.getChildren().add(square);
        }
        return hBox;
    }
    
    private VBox getNumberColumn(){
        VBox vvBox = new VBox();
        
        for(int i= 0;i<8;i++){
            StackPane square = new StackPane();
            square.setMinSize(10, 50);
            
            square.getChildren().add(new Label("" + i));  
            vvBox.getChildren().add(square);
        }
        return vvBox;
    }
    
    
    private VBox getVBox(){
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

