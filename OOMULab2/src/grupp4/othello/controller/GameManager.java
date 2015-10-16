/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.controller;

import grupp4.othello.model.GameGrid;
import grupp4.othello.model.Player;
import grupp4.othello.view.*;
import javafx.util.Pair;

/**
 *  
 * @author Lennart
 */

public class GameManager {
    
    public void othelloManager(Player p1, Player p2){
        
    }

    
    private void gameOver(GameGrid grid,Player p1, Player p2){
        if(!(grid.moreAvailableMoves(p1.getMarkörID())) && !(grid.moreAvailableMoves(p2.getMarkörID()))){
                    WinnerDialog winner = new WinnerDialog();
                    if (grid.winner() == 'B'){
                        winner.displayWinnerDialog(p1.getName());
                        System.exit(0);
                }
                    else if(grid.winner() == 'W'){
                         winner.displayWinnerDialog(p2.getName());
                         System.exit(0);
                    }
                    else{
                        DrawnDialog draw = new DrawnDialog();
                        draw.DisplayDrawDialog();
                        System.exit(0);
                    }
                   
                }
    }
}
