/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.model;

import grupp4.othello.model.exception.InvalidMoveException;
import java.util.ArrayList;

/**
 *
 * @author alexander
 */
public class GameGrid{
    char[][] grid = new char[8][8];
    
    
    public GameGrid(){
        setStartPositions();
    }
    
    private void setStartPositions(){
        grid[3][3]='W';
        grid[4][4]='W';
        grid[4][3]='B';
        grid[3][4]='B';
    }
    
    public void resetGrid(){
       
        for (int i=0;i <= 7;i++){
            for (int j = 0;j<= 7;j++){
                grid[i][j]=0;
            }
        }
        setStartPositions();
    }
    
     public void printGameGrid(){
         for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(grid[i][j] + " ");
            }
         System.out.print("\n");
        }
     }
     
   
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
    
    
    
    public boolean availableMove(int row,int column,char markörID){
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

    private void uppdateGrid(int x,int y, char markörID){
        grid[x][y]=markörID;
    }
    
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
    
    
    public void move(int row, int column, char markörID) throws InvalidMoveException {
        
        if(availableMove(row,column,markörID)){
        uppdateWithMove(row,column,markörID);
        }
        else
            throw new InvalidMoveException();
    }



    public void uppdateWithMove(int row, int colum,char markörID){
        uppdateGrid(row,colum,markörID);
        if (moveCheck(row,colum,1,0,markörID)){
            while(grid[row+1][colum] != markörID && grid[row][colum]!= 0){
                grid[row+1][colum] = markörID;
                row = row +1;
            }
        }
        else if (moveCheck(row,colum,1,1,markörID)){
            while(grid[row+1][colum+1] != markörID && grid[row][colum]!= 0){
                grid[row+1][colum+1] = markörID;
                row = row +1;
            }
            
        }
        else if (moveCheck(row,colum,0,1,markörID)){
             while(grid[row][colum+1] != markörID && grid[row][colum]!= 0){
                grid[row][colum+1] = markörID;
                colum = colum +1;
            }
        }
        else if (moveCheck(row,colum,-1,-1,markörID)){
             while(grid[row-1][colum-1] != markörID && grid[row][colum]!= 0){
                grid[row-1][colum-1] = markörID;
                row = row -1;
                colum = colum -1;
            }
        }
        else if (moveCheck(row,colum,-1,0,markörID)){
             while(grid[row - 1][colum] != markörID && grid[row][colum]!= 0){
                grid[row - 1][colum] = markörID;
                row = row- 1;
            }
            
        }
        else if (moveCheck(row,colum,0,-1,markörID)){
             while(grid[row][colum-1] != markörID && grid[row][colum]!= 0){
                grid[row][colum-1] = markörID;
                colum = colum -1;
            }
            
        }
        else if (moveCheck(row,colum,-1,1,markörID)){
             while(grid[row-1][colum+1] != markörID && grid[row][colum]!= 0){
                grid[row-1][colum+1] = markörID;
                row = row -1;
                colum = colum +1;
            }
        }
        else if (moveCheck(row,colum,1,-1,markörID)){
             while(grid[row+1][colum-1] != markörID && grid[row][colum]!= 0){
                grid[row+1][colum-1] = markörID;
                row = row +1;
                colum = colum -1;
            }
        }
    }
    
    public char winner(){
        int black=0;
        int white=0;
          for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (grid[i][j]== 'B'){
                    black ++;
                }
                if (grid[i][j]=='W'){
                    white++;
                }
            }
        
        }
        if(black > white) return ('B');
        else if(black < white) return ('W');
        else return('D');
    }
}
          

