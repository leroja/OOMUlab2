/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.controller;

import grupp4.othello.view.*;
import javafx.util.Pair;

/**
 *
 * @author Lennart
 */

public class GameManager {

    public void manage(){

        
    }
    
    
    public void notifyGameBoard(char[][] grid){
        GameBoard board = new GameBoard();
        board.onUppdateInGameGrid(grid);
    }
}
