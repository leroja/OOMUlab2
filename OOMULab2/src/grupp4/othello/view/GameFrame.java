/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import grupp4.othello.controller.ClickListener;
import grupp4.othello.controller.CustomEvent;
import grupp4.othello.controller.NewGameGen;
import grupp4.othello.controller.NewGameListener;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
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
 * Class for creating and displaying gameFrame
 * @author Lennart
 */
public class GameFrame implements NewGameGen{
    private GameBoard board;
    private BorderPane border;
    private Stage primaryStage;
    private ArrayList<NewGameListener> listeners = new ArrayList<>();
    private Label currentPlayer;
    
    /**
     * Constructor for GameFrame
     * @param primaryStage 
     */
    public GameFrame(Stage primaryStage){
        this.primaryStage = primaryStage;
        
        board = new GameBoard();
        border = new BorderPane();
        VBox buttonColumn;
        buttonColumn = getButtonPanel();
        
        currentPlayer = new Label("Temp");    
        
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
     * Sets CurentPlayer text till name and marker of current player.
     * @param currentPlayer 
     */
    public void setCurrentPlayer(StringProperty currentPlayer){
        Platform.runLater(()->{
        this.currentPlayer.textProperty().bind(currentPlayer);
        });
        
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
     * Creates button panel for gameFrame
     * @return 
     */
    private VBox getButtonPanel(){
        Button nyttParti = new Button("Nytt parti");
        nyttParti.setPrefSize(70,35);
        nyttParti.setOnAction((ActionEvent e) -> {
            fireEvents(null);
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
        listeners.add(listener);
    }
    
    private void fireEvents(CustomEvent e){
        int j = listeners.size();
        if (j == 0){
            return;
        }
        for(int i = 0; i < j; i++) {
            listeners.get(i).newGame(e);
        }
    }
    
   /**
    * EventHandler for Exit button on gameFrame
    */
    public class  ExitEventHandler implements EventHandler<ActionEvent> {
  
        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    }
    
}
    


