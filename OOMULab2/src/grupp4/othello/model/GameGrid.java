/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.model;

/**
 *
 * @author alexander
 */
public class GameGrid {
    char[][] grid = new char[8][8];
    
    
    public GameGrid(){
        grid[3][3]='W';
        grid[4][4]='W';
        grid[4][3]='B';
        grid[3][4]='B';
    }
    
    private boolean availableMove(int x,int y,char markörID){
            return false;
    }    

    private void uppdateGrid(int x,int y, char markörID){
        grid[x][y]=markörID;
    }
}

