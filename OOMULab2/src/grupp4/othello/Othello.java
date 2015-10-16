package grupp4.othello;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
    
    @Override
    public void start(Stage stage) throws Exception{
        
        SetUpGameDialog setUp = new SetUpGameDialog();
        Pair<String, String> player1, player2;
        Player p1, p2;
        
        player1 = setUp.setPlayer1();
        player2 = setUp.setPlayer2();
        p1 = setPlayer(player1.getValue(), player1.getKey(), 'B');
        p2 = setPlayer(player2.getValue(), player2.getKey(), 'W');
        
        
        GameGrid grid = new GameGrid();
        grid.printGameGrid();
        
        while(true){
            try{
                if(grid.moreAvailableMoves(p1.getMarkörID())){
                    System.out.println("B");
                    GridRow gRP1 = p1.getMove(grid);
                    grid.move(gRP1.getRow(),gRP1.getColumn(),p1.getMarkörID());
                    grid.printGameGrid();
                }
                if(grid.moreAvailableMoves(p2.getMarkörID())){
                    System.out.println("W");
                    GridRow gRP2 = p2.getMove(grid);
                    grid.move(gRP2.getRow(), gRP2.getColumn(),p2.getMarkörID());
                    grid.printGameGrid();
                }
                if(!(grid.moreAvailableMoves(p1.getMarkörID()))&&!(grid.moreAvailableMoves(p2.getMarkörID()))){
                    System.out.println(grid.winner() + " is the Winner"); 
                    System.exit(0);
                }
            }catch(Exception e){
                System.out.println(e.getCause());
                System.exit(0);
            }
                
        }
        
    }
    private Player setPlayer(String type,String name, char markörId){
        if ("Computer".equals(type)){
            return new ComputerPlayer(name, markörId);
        }else
            return new HumanPlayer(name, markörId);
    }
}
   
