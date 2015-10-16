/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.model;

import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

/**
 *
 * @author alexander
 */
public class ComputerPlayer extends Player {
    
    public ComputerPlayer(String name, char markorID){
        this.name = name;
        this.markörID = markorID;
    }

    @Override
    public GridRow getMove(GameGrid grid){
        //GameGrid grid = new GameGrid();
        Random rand = new Random();
        ArrayList<GridRow> arr;
        arr = grid.getAvailableMoves(this.markörID);
        int size = arr.size();
        int drag = rand.nextInt(size);
        return (arr.get(drag));
        
    }
}
