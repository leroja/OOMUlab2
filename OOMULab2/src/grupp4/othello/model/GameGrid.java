/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.model;

import grupp4.othello.controller.CustomEvent;
import grupp4.othello.controller.NewGameListener;
import grupp4.othello.controller.UpdtGen;
import grupp4.othello.controller.UpdtListener;
import grupp4.othello.model.exception.InvalidMoveException;
import java.util.ArrayList;

/**
 * Controls the grid of the game. has functions for check moves and check winner.
 * 
 */
public class GameGrid implements UpdtGen, NewGameListener{
    private char[][] grid = new char[8][8];
    private UpdtListener listener;
    
    /**
     * Constructor for the GameGrid.
     */
    public GameGrid(){
        setStartPositions();
    }
    
    /**
     * Sets the starting positions of reversi.
     */
    private void setStartPositions(){
        grid[3][3]='W';
        grid[4][4]='W';
        grid[4][3]='B';
        grid[3][4]='B';
    }
    
    /**
     * Checks if both players has any more moves 
     * If no one has more moves then the game is over
     * @return true if the game is over
     */
    public boolean isGAmeOver(){
        return !(moreAvailableMoves('W')) && !(moreAvailableMoves('B'));
    }
    
    /**
     * Resets the grid to its starting positions
     */
    private void resetGrid(){
        for (int i=0;i <= 7;i++){
            for (int j = 0;j<= 7;j++){
                grid[i][j]=0;
            }
        }
        setStartPositions();
    }
    
    /**
     * Prints the current state of the grid
     */
    public void printGameGrid(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(grid[i][j] + " ");
            }
        System.out.print("\n");
        }
     }
     
   
    /**
     * Gets all possible moves.
     * @param markorID the "Color" of the player's marker
     * @return a ArrayList of all possibles moves
     */
    public ArrayList<GridRow> getAvailableMoves(char markorID){
        ArrayList<GridRow> arr = new ArrayList<>();
        for(int i = 0;i < 8;i++){
            for(int j =0; j < 8;j++){
                if(availableMove(i,j,markorID)){
                    GridRow pair = new GridRow(i,j);
                    arr.add(pair);
                }   
            }
        }
        return arr;
    }
    
    /**
     * Checks if the player can do any more moves
     * @param markorID the "color" of the player's marker
     * @return true if the player can do more moves
     */
    public boolean moreAvailableMoves(char markorID){
        for(int i = 0;i < 8;i++){
            for(int j =0; j < 8;j++){
                if(availableMove(i,j,markorID)){
                    return true;
                }   
            }
        }
        return false;
    }
    
    /**
     * Checks if there is a valid move in any direction
     * @param row the row that the marker was placed at
     * @param column the column that the marker was placed at
     * @param markorID the "color" of the marker
     * @return true if there is a valid move in any direction
     */
    private boolean availableMove(int row,int column,char markorID){
        if (grid[row][column]!= 0) return (false);
        if (moveCheck(row,column,1,0,markorID))return true;
        else if (moveCheck(row,column,1,1,markorID))return true;
        else if (moveCheck(row,column,0,1,markorID))return true;
        else if (moveCheck(row,column,-1,-1,markorID))return true;
        else if (moveCheck(row,column,-1,0,markorID))return true;
        else if (moveCheck(row,column,0,-1,markorID))return true;
        else if (moveCheck(row,column,-1,1,markorID))return true;
        else if (moveCheck(row,column,1,-1,markorID))return true;
        else return (false);
    }    
    
    /**
     * Places a marker at the spescified location
     * @param row the row that the marker is to be placed at
     * @param column the column that the marker is to be placed at
     * @param markorID the "color" of the marker
     */
    private void uppdateGrid(int row,int column, char markorID){
        grid[row][column] = markorID;
    }
    
    /**
     * Checks if there is a valid move in that direction
     * @param row the row that the marker was placed at
     * @param column the column that the marker was placed at
     * @param dRow The change in rows from the placed marker.
     * @param dColumn the change in column from the placed marker.
     * @param markorID  the "color" of the marker
     * @return true if the move in that direction is valid
     */
    private boolean moveCheck(int row, int Column, int dRow, int dColumn, char markorID){
        int i;
        int j;
        for (i = row + dRow, j =Column + dColumn; i >= 0 && i < 8 && j>=0 && j< 8 ; i = i + dRow, j = j + dColumn){
            if(i == row + dRow && j == Column + dColumn && grid[i][j] == markorID) return false;
            if( grid[i][j] == 0) return (false);
            if (grid[i][j] == markorID) return (true);
        }
        return (false);
    }
    
    /**
     * Checks if the move is valid
     * if the move is valid, the 
     * method Places an marker else
     * throws invalidMoveExeption
     * @param row the row that the marker was placed at
     * @param column the column that the marker was placed at
     * @param markorID the "color" of the marker
     * @throws InvalidMoveException is thrown when the user makes an invalid move
     */
    public void move(int row, int column, char markorID) throws InvalidMoveException {
        
        if(availableMove(row,column,markorID)){
            uppdateWithMove(row,column,markorID);
            listener.updated(new CustomEvent(grid));
        }
        else
            throw new InvalidMoveException();
    }


    /**
     * Checks every direction from placed marker. if valid move
     * is found method changes every other brick between the two valid bricks
     * @param row the row that the marker was placed at
     * @param column the column that the marker was placed at
     * @param markorID the "color" of the marker
     */
    private void uppdateWithMove(int row, int column,char markorID){
        uppdateGrid(row,column,markorID);
        int rowStart = row, columnStart = column;
        if (moveCheck(row,column,1,0,markorID)){
            while(grid[row+1][column] != markorID && grid[row][column] != 0){
                grid[row+1][column] = markorID;
                row = row + 1;
            }
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,1,1,markorID)){
            while(grid[row+1][column+1] != markorID && grid[row][column] != 0){
                grid[row+1][column+1] = markorID;
                row = row + 1;
                column = column + 1;
            }
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,0,1,markorID)){
             while(grid[row][column+1] != markorID && grid[row][column] != 0){
                grid[row][column+1] = markorID;
                column = column + 1;
            }
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,-1,-1,markorID)){
             while(grid[row-1][column-1] != markorID && grid[row][column] != 0){
                grid[row-1][column-1] = markorID;
                row = row -  1;
                column = column -1;
            }
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,-1,0,markorID)){
             while(grid[row - 1][column] != markorID && grid[row][column] != 0){
                grid[row - 1][column] = markorID;
                row = row - 1;
            }
            
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,0,-1,markorID)){
             while(grid[row][column-1] != markorID && grid[row][column] != 0){
                grid[row][column-1] = markorID;
                column = column - 1;
            }
            
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,-1,1,markorID)){
             while(grid[row-1][column+1] != markorID && grid[row][column] != 0){
                grid[row-1][column+1] = markorID;
                row = row - 1;
                column = column + 1;
            }
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,1,-1,markorID)){
             while(grid[row+1][column-1] != markorID && grid[row][column] != 0){
                grid[row+1][column-1] = markorID;
                row = row + 1;
                column = column - 1;
            }
        }
    }
    
    /**
     * Calculates which player who has won the game
     * @return B if black wins,W if White wins, D i drawn;
     */
    public char winner(){
        int black = 0;
        int white = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (grid[i][j] == 'B'){
                    black ++;
                }
                if (grid[i][j] == 'W'){
                    white++;
                }
            }
        }
        if(black > white) return ('B');
        else if(black < white) return ('W');
        else return('D');
    }
    
    /**
    * this function adds a listener to the listerner ArrayList
    * the listeners are listening for uppdates on the GameGrid
    * @param listener
    */
    @Override
    public void addUpdtListener(UpdtListener listener) {
        this.listener = listener;
    }
    
    /**
     * a listener for the newGame Event
     * resets the grid and notifies the gameBoard
     * @param e the information about the event
     */
    @Override
    public void newGame(CustomEvent e) {
        resetGrid();
        listener.updated(new CustomEvent(grid));
    }
}
          

