/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.controller;

import grupp4.othello.view.*;

/**
 *
 * @author Lennart
 */

public class GameManager {

    
    
    
 public void notifyGameBoard(char[][] grid){
     GameBoard board = new GameBoard();
     board.onUppdateInGameGrid(grid);
 }
}
