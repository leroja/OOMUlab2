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
 * Controls the flow of the game.
 */
public class GameManager implements Runnable,NewGameListener {
    private Player player1, player2;
    private Stage stage;
    private GameFrame gameframe;
    private GameGrid grid;
    private Player activePlayer;
    private StringProperty currentPlayer = new SimpleStringProperty("");
    
    /**
     * Constructor of the GameManager
     * @param player1 sets Player 1
     * @param player2 sets player 2
     * @param stage  sets the stage
     */
    public GameManager(Player player1, Player player2, Stage stage){
        this.player1 = player1;
        this.player2 = player2;
        this.stage = stage;
    }
    
    /**
     * Controls the game. decides activePlayer.
     * Displays dialogs for Invalid Move And lets the active player redo move.
     */
    private void othelloManager(){
        activePlayer = player1;
        setText(activePlayer);
        while(true){
            while(!grid.isGAmeOver()){
                try{
                    if(grid.moreAvailableMoves(activePlayer.getMarkorID())){
                        GridRow gr = activePlayer.getMove(grid);
                        grid.move(gr.getRow(),gr.getColumn(),activePlayer.getMarkorID());
                        setActivePlayer();
                    }
                    else if(!grid.moreAvailableMoves(activePlayer.getMarkorID())){
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
    }
    /**
     * Sets the ActivePlayer string On the GameFrame to the current Players name and marker.
     * @param activePlayer For getting the name and marker of activePlayer
     */
    private void setText(Player activePlayer){
        this.currentPlayer = new SimpleStringProperty("Current Player: " + activePlayer.getName() + ", Marker: " + activePlayer.getMarkorID());
        this.gameframe.setCurrentPlayer(currentPlayer);
    }
    /**
     * method changes the activePlayer to next player.
     */
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
     * Check if the game is over.
     * @param grid for checking if the game is over.
     * @param p1 for controlling who won the game.
     * @param p2 for controlling who won the game.
     */
    private void gameOver(GameGrid grid,Player p1, Player p2){
        if(grid.isGAmeOver()){
            WinnerDialog winnerDialog = new WinnerDialog();
            char winner = grid.winner();
            if (winner == 'W'){
                winnerDialog.displayWinnerDialog(p1.getName());
            }
            else if(winner == 'B'){
                 winnerDialog.displayWinnerDialog(p2.getName());
            }
            else{
                DrawnDialog draw = new DrawnDialog();
                draw.DisplayDrawDialog();
            }
        }
    }
    
    /**
     * initializes the game Starts the GameFrame and addsListener.
     * @param stage 
     */
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
     * Overrides the run method in the Runnable Interface.
     */
    @Override
    public void run() {
        othelloManager();
    }
    
    /**
     * Activates when user press the newGame button on the gameFrame.
     * @param e 
     */
    @Override
    public void newGame(CustomEvent e) {
       activePlayer = player1;
    }
}
