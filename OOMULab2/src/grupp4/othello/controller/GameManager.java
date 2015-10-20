/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.controller;

import grupp4.othello.model.GameGrid;
import grupp4.othello.model.GridRow;
import grupp4.othello.model.Player;
import grupp4.othello.model.exception.InvalidMoveException;
import grupp4.othello.view.*;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 *  
 * @author Lennart
 */

public class GameManager implements Runnable {
    private Player player1, player2;
    private Stage stage;
    
    /**
     * 
     * @param player1
     * @param player2
     * @param stage 
     */
    public GameManager(Player player1, Player player2, Stage stage){
        this.player1 = player1;
        this.player2 = player2;
        this.stage = stage;
    }
    
    /**
     * 
     */
    public void othelloManager(){
        GameFrame dd = new GameFrame(stage);
        dd.addli(player1);
        
        GameGrid grid = new GameGrid();
        grid.addUpdtListener(dd.getBoard());
        dd.addListener(grid);
        
//        grid.printGameGrid();
//        
//        while(!grid.isGAmeOver()){
//            try{
//                
//                if(grid.moreAvailableMoves(player1.getMarkörID())){
//                    System.out.println("W");
//                    GridRow gRP1 = player1.getMove(grid);
//                    grid.move(gRP1.getRow(),gRP1.getColumn(),player1.getMarkörID());
//                    grid.printGameGrid();
//                }
//                if(grid.moreAvailableMoves(player2.getMarkörID())){
//                    System.out.println("B");
//                    GridRow gRP2 = player2.getMove(grid);
//                    grid.move(gRP2.getRow(), gRP2.getColumn(),player2.getMarkörID());
//                    grid.printGameGrid();
//                }
//                gameOver(grid,player1,player2);
//            }catch(InvalidMoveException e){
//                System.out.println(e.getMessage());
//                System.exit(0);
//            }
//        }
    }

    
    /**
     * 
     * @param grid
     * @param p1
     * @param p2 
     */
    private void gameOver(GameGrid grid,Player p1, Player p2){
        if(grid.isGAmeOver()){
            WinnerDialog winnerDialog = new WinnerDialog();
            char winner = grid.winner();
            if (winner == 'W'){
                winnerDialog.displayWinnerDialog(p1.getName());
                //System.exit(0);
            }
            else if(winner == 'B'){
                 winnerDialog.displayWinnerDialog(p2.getName());
                 //System.exit(0);
            }
            else{
                DrawnDialog draw = new DrawnDialog();
                draw.DisplayDrawDialog();
                //System.exit(0);
            }
        }
    }

    /**
     * 
     */
    @Override
    public void run() {
        othelloManager();
    }
}
