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
 * 
 * 
 */
public class GameGrid implements UpdtGen, NewGameListener{
    private char[][] grid = new char[8][8];
    private UpdtListener listener;
    
    
    public GameGrid(){
        setStartPositions();
    }
    
    
    private void setStartPositions(){
        grid[3][3]='W';
        grid[4][4]='W';
        grid[4][3]='B';
        grid[3][4]='B';
    }
    
    /**
     * Checks if both players has any more moves 
     * If no one has more moves then the game if over
     * @return true if the game is over
     */
    public boolean isGAmeOver(){
        return !(moreAvailableMoves('W')) && !(moreAvailableMoves('B'));
    }
    
    /**
     * Resets the grid to it's starting pos
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
     * 
     * @param markörID the "Color" of the player's marker
     * @return a ArrayList of all possibles moves
     */
    public ArrayList<GridRow> getAvailableMoves(char markörID){
        ArrayList<GridRow> arr = new ArrayList<>();
        for(int i = 0;i < 8;i++){
            for(int j =0; j < 8;j++){
                if(availableMove(i,j,markörID)){
                    GridRow pair = new GridRow(i,j);
                    arr.add(pair);
                }   
            }
        }
        return arr;
    }
    
    /**
     * Checks if the player can do any more moves
     * @param markörID the "color" of the player's marker
     * @return true if the player can do more moves
     */
    public boolean moreAvailableMoves(char markörID){
        for(int i = 0;i < 8;i++){
            for(int j =0; j < 8;j++){
                if(availableMove(i,j,markörID)){
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
     * @param markörID .....
     * @return true if there is a valid move in any direction
     */
    private boolean availableMove(int row,int column,char markörID){
        if (grid[row][column]!= 0) return (false);
        if (moveCheck(row,column,1,0,markörID))return true;
        else if (moveCheck(row,column,1,1,markörID))return true;
        else if (moveCheck(row,column,0,1,markörID))return true;
        else if (moveCheck(row,column,-1,-1,markörID))return true;
        else if (moveCheck(row,column,-1,0,markörID))return true;
        else if (moveCheck(row,column,0,-1,markörID))return true;
        else if (moveCheck(row,column,-1,1,markörID))return true;
        else if (moveCheck(row,column,1,-1,markörID))return true;
        else return (false);
    }    
    
    /**
     * Places a marker at the spescified location
     * @param row the row that the marker is to be placed at
     * @param column the column that the marker is to be placed at
     * @param markörID the "color" of the marker
     */
    private void uppdateGrid(int row,int column, char markörID){
        grid[row][column] = markörID;
    }
    
    /**
     * Checks if there is a valid move in that direction
     * @param row the row that the marker was placed at
     * @param column the column that the marker was placed at
     * @param dx 
     * @param dy
     * @param markörID 
     * @return true if the move in that direction is valid
     */
    private boolean moveCheck(int x, int y, int dx, int dy, char markörID){
        int i;
        int j;
        for (i = x + dx, j =y + dy; i >= 0 && i < 8 && j>=0 && j< 8 ; i = i + dx, j = j + dy){
            if(i == x + dx && j == y + dy && grid[i][j] == markörID) return false;
            if( grid[i][j] == 0) return (false);
            if (grid[i][j] == markörID) return (true);
        }
        return (false);
    }
    
    /**
     * Checks if the move is valid
     * if the move is valid, the 
     * .......
     * @param row the row that the marker was placed at
     * @param column the column that the marker was placed at
     * @param markörID .......
     * @throws InvalidMoveException 
     */
    public void move(int row, int column, char markörID) throws InvalidMoveException {
        
        if(availableMove(row,column,markörID)){
            uppdateWithMove(row,column,markörID);
            listener.updated(new CustomEvent(grid));
        }
        else
            throw new InvalidMoveException();
    }


    /**
     * .............
     * @param row the row that the marker was placed at
     * @param column the column that the marker was placed at
     * @param markörID .......
     */
    private void uppdateWithMove(int row, int column,char markörID){
        uppdateGrid(row,column,markörID);
        int rowStart = row, columnStart = column;
        if (moveCheck(row,column,1,0,markörID)){
            while(grid[row+1][column] != markörID && grid[row][column] != 0){
                grid[row+1][column] = markörID;
                row = row + 1;
            }
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,1,1,markörID)){
            while(grid[row+1][column+1] != markörID && grid[row][column] != 0){
                grid[row+1][column+1] = markörID;
                row = row + 1;
                column = column + 1;
            }
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,0,1,markörID)){
             while(grid[row][column+1] != markörID && grid[row][column] != 0){
                grid[row][column+1] = markörID;
                column = column + 1;
            }
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,-1,-1,markörID)){
             while(grid[row-1][column-1] != markörID && grid[row][column] != 0){
                grid[row-1][column-1] = markörID;
                row = row -  1;
                column = column -1;
            }
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,-1,0,markörID)){
             while(grid[row - 1][column] != markörID && grid[row][column] != 0){
                grid[row - 1][column] = markörID;
                row = row - 1;
            }
            
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,0,-1,markörID)){
             while(grid[row][column-1] != markörID && grid[row][column] != 0){
                grid[row][column-1] = markörID;
                column = column - 1;
            }
            
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,-1,1,markörID)){
             while(grid[row-1][column+1] != markörID && grid[row][column] != 0){
                grid[row-1][column+1] = markörID;
                row = row - 1;
                column = column + 1;
            }
        }
        row = rowStart;
        column = columnStart;
        if (moveCheck(row,column,1,-1,markörID)){
             while(grid[row+1][column-1] != markörID && grid[row][column] != 0){
                grid[row+1][column-1] = markörID;
                row = row + 1;
                column = column - 1;
            }
        }
    }
    
    /**
     * Calculates which player who has won the game
     * @return ..........
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

    @Override
    public void addUpdtListener(UpdtListener listener) {
        this.listener = listener;
    }

    @Override
    public void newGame(CustomEvent e) {
        resetGrid();
        listener.updated(new CustomEvent(grid));
    }
}
          

