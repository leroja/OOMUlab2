package grupp4.othello;



/*
 *
 */

import grupp4.othello.controller.GameManager;
import grupp4.othello.model.Player;
import grupp4.othello.view.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 *Main class for starting the application.
 *
 */
public class Othello extends Application{
    
    /**
     * The start method of the application
     * @param stage 
     */
    @Override
    public void start(Stage stage){
        
        
        
        SetUpGameDialog setUp = new SetUpGameDialog();
        Pair<String, String> player1, player2;
        Player p1, p2;
        
        player1 = setUp.setPlayer1();
        player2 = setUp.setPlayer2();
        p1 = Player.setPlayer(player1.getValue(), player1.getKey(), 'W');
        p2 = Player.setPlayer(player2.getValue(), player2.getKey(), 'B');
        
        GameManager man = new GameManager(p1, p2, stage);
        man.initGame(stage);
        
        new Thread(man).start();
                
    }
}
   
