/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import grupp4.othello.controller.ClickListener;
import grupp4.othello.controller.NewGameGen;
import grupp4.othello.controller.NewGameListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Lennart
 */
public class GameFrame implements NewGameGen{
    private GameBoard board;
    private BorderPane border;
    private Stage primaryStage;
    private NewGameListener listener;
    
    /**
     * 
     * @param primaryStage 
     */
    public GameFrame(Stage primaryStage){
        this.primaryStage = primaryStage;
        
        board = new GameBoard();
        border = new BorderPane();
        VBox buttonColumn;
        buttonColumn = getButtonPanel();
        
        Label currentPlayer = new Label("Temp");    
        
        border.setRight(buttonColumn);
        border.setCenter(board.getGameBoard());
        border.setBottom(currentPlayer);
        
//        Image image = new Image("/resources/sym57.cur");
//        ImageCursor curs = new ImageCursor(image);
//        border.setCursor(curs);s
        
        
        Scene scene = new Scene(border);
        this.primaryStage.setScene(scene);
        
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/reversi_icon.png")));
        this.primaryStage.setTitle("Othello");
        this.primaryStage.setResizable(false);
        this.primaryStage.sizeToScene();
        
        this.primaryStage.show();
        
    }
    
    /**
     * 
     * @param listener 
     */
    public void addli(ClickListener listener){
        board.addListener(listener);
    }
    
    /**
     * 
     * @return 
     */
    public GameBoard getBoard(){
        return board;
    }
    
    
    /**
     * 
     * @return 
     */
    private VBox getButtonPanel(){
        Button nyttParti = new Button("Nytt parti");
        nyttParti.setPrefSize(70,35);
        NewGameEventHandler Game = new NewGameEventHandler();
        //nyttParti.setOnAction(Game);
        nyttParti.setOnMouseClicked((MouseEvent e) -> {
            this.listener.newGame(null);
        });
        
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

    /**
     * 
     * @param listener 
     */
    @Override
    public void addListener(NewGameListener listener) {
        this.listener = listener;
    }
   /**
    * 
    */
    public class  ExitEventHandler implements EventHandler<ActionEvent> {
  
        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    }
    
    /**
     * 
     */
    public class NewGameEventHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event){
            System.out.println("New Game");
     
        }
        
    }
    
}

