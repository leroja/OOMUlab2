/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.model;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author alexander
 */
public class GameGrid {
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
     
   
    public ArrayList<Pair<Integer,Integer>> getAvailableMoves(char markörID){
        ArrayList<Pair<Integer,Integer>> arr = new ArrayList<Pair<Integer,Integer>>();
        for(int i = 0;i < 8;i++){
            for(int j =0; j < 8;j++){
                if(availableMove(i,j,markörID)){
                    Pair pair = new Pair<>(i,j);
                    arr.add(pair);
                }   
            }
        }
        return arr;
    }
    
    
    
    private boolean availableMove(int x,int y,char markörID){
        if (grid[x][y]!= 0) return (false);
        if (moveCheak(x,y,1,0,markörID))return true;
        else if (moveCheak(x,y,1,1,markörID))return true;
        else if (moveCheak(x,y,0,1,markörID))return true;
        else if (moveCheak(x,y,-1,-1,markörID))return true;
        else if (moveCheak(x,y,-1,0,markörID))return true;
        else if (moveCheak(x,y,0,-1,markörID))return true;
        else if (moveCheak(x,y,-1,1,markörID))return true;
        else if (moveCheak(x,y,1,-1,markörID))return true;
        else return (false);
    }    

    public void uppdateGrid(int x,int y, char markörID){
        grid[x][y]=markörID;
    }
    
    private boolean moveCheak(int x, int y, int dx, int dy, char markörID){
       int i;
       int j;
      for (i = x + dx, j =y + dy; i >= 0 && i < 8 && j>=0 && j< 8 ; i = i + dx, j = j + dy){
            if(i == x + dx && j == y + dy && grid[i][j] == markörID) return false;
            if( grid[i][j] == 0) return (false);
            if (grid[i][j] == markörID) return (true);
       }
       return (false);
    }
}




