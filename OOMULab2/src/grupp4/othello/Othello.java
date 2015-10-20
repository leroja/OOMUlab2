package grupp4.othello;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import grupp4.othello.controller.GameManager;
import grupp4.othello.model.ComputerPlayer;
import grupp4.othello.model.GameGrid;
import grupp4.othello.model.GridRow;
import grupp4.othello.model.HumanPlayer;
import grupp4.othello.model.Player;
import grupp4.othello.view.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 *
 * @author Lennart
 */
public class Othello extends Application{
    
    /**
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception{
        
        
        
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
   
