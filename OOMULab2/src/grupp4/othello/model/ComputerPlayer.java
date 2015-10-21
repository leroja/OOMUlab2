/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.model;

import grupp4.othello.controller.CustomEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

/**
 * Calculates the move of an computerPlayer
 * 
 */
public class ComputerPlayer extends Player {
    
    /**
     * Constructor of an ComputerPlayer
     * @param name sets name 
     * @param markorID sets markörID
     */
    public ComputerPlayer(String name, char markorID){
        this.name = name;
        this.markörID = markorID;
    }

    /**
     * Calculates the move and returns it as an GridRow.
     * @param grid for calculating next move
     * @return 
     */
    @Override
    public GridRow getMove(GameGrid grid){
        Random rand = new Random();
        ArrayList<GridRow> arr;
        arr = grid.getAvailableMoves(this.markörID);
        int size = arr.size();
        int drag = rand.nextInt(size);
        try { 
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (arr.get(drag));
        
    }

    /**
     * Not in use in the ComuputerPlayer Class. In use in HumanPlayer Class.
     * @param e 
     */
    @Override
    public void HumanClicked(CustomEvent e) {
        
    }
}
