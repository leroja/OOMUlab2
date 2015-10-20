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
    Player player1, player2;
    Stage stage;
    GameGrid grid;
    Player activePlayer;
    
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
        activePlayer = player1;
        while(!grid.isGAmeOver()){
            try{
                if(grid.moreAvailableMoves(activePlayer.getMarkörID())){
                    GridRow gr = activePlayer.getMove(grid);
                    grid.move(gr.getRow(),gr.getColumn(),activePlayer.getMarkörID());
                    SetActivePlayer();
                }
                else if(grid.moreAvailableMoves(activePlayer.getMarkörID())== false){
                        NoMoreMovesDialog no = new NoMoreMovesDialog();
                        no.displayNoMoreMovesDialog();
                        SetActivePlayer();
                    }
                    
                                         
               gameOver(grid,player1,player2);
               
            }catch(InvalidMoveException e){
                InvalidMoveDialog in = new InvalidMoveDialog();
                in.DisplayInvalidMoveDialog();
            }
            
        }
    }
    
    private void SetActivePlayer(){
        if (this.activePlayer == this.player1){
            this.activePlayer = this.player2;
           
    }
        else if (this.activePlayer == this.player2){
             this.activePlayer = this.player1;
             
        }
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
    public void initGame(Stage stage){
        GameFrame dd = new GameFrame(stage); 
        dd.addli(player1);
   //   dd.addli(player2);
        GameGrid grid = new GameGrid();
        grid.addUpdtListener(dd.getBoard());
        dd.addListener(grid);
        this.grid = grid;
    }

    /**
     * 
     */
    @Override
    public void run() {
        othelloManager();
    }
}
