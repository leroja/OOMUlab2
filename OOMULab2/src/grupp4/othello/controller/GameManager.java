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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *  
 * @author Lennart
 */

public class GameManager implements Runnable,NewGameListener {
    private Player player1, player2;
    private Stage stage;
    private GameFrame gameframe;
    private GameGrid grid;
    private Player activePlayer;
    private StringProperty currentPlayer = new SimpleStringProperty("");
    
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
    private void othelloManager(){
        activePlayer = player1;
        setText(activePlayer);
        while(!grid.isGAmeOver()){
            try{
                if(grid.moreAvailableMoves(activePlayer.getMarkörID())){
                    GridRow gr = activePlayer.getMove(grid);
                    grid.move(gr.getRow(),gr.getColumn(),activePlayer.getMarkörID());
                    setActivePlayer();
                }
                else if(grid.moreAvailableMoves(activePlayer.getMarkörID())== false){
                        NoMoreMovesDialog no = new NoMoreMovesDialog();
                        no.displayNoMoreMovesDialog();
                        setActivePlayer();
                    }
                    
                                         
               gameOver(grid,player1,player2);
               
            }catch(InvalidMoveException e){
                InvalidMoveDialog in = new InvalidMoveDialog();
                in.DisplayInvalidMoveDialog();
            }
            
        }
    }
    private void setText(Player activePlayer){
        this.currentPlayer = new SimpleStringProperty("Current Player: " + activePlayer.getName() + ", Marker: " + activePlayer.getMarkörID());
        this.gameframe.setCurrentPlayer(currentPlayer);
    }
    
    private void setActivePlayer(){
        if (this.activePlayer == this.player1){
            this.activePlayer = this.player2;
        }
        else if (this.activePlayer == this.player2){
             this.activePlayer = this.player1;
             
        }
        setText(activePlayer);
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
        this.gameframe = new GameFrame(stage); 
        this.gameframe.addli(player1);
        this.gameframe.addli(player2);
        this.gameframe.addListener(this);
        GameGrid grid = new GameGrid();
        grid.addUpdtListener(this.gameframe.getBoard());
        this.gameframe.addListener(grid);
        this.grid = grid;
    }

    /**
     * 
     */
    @Override
    public void run() {
        othelloManager();
    }

    @Override
    public void newGame(CustomEvent e) {
       System.out.println("java");
       activePlayer = player1;
    }
}
