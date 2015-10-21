/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.model;

import grupp4.othello.controller.CustomEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

/**
 * Class for getting the next move from an HummanPlayer
 * @author alexander
 */
public class HumanPlayer extends Player{
    private GridRow gr;
    
    /**
     * Constructor for humanPlayer
     * @param name name Of player 
     * @param markorID the "color" of the marker
     */
     public HumanPlayer(String name, char markorID){
         gr = new GridRow(-1,-1);
        this.name = name;
        this.markörID = markorID;
     }
     
     /**
      * gets Move of humanPlayer
      * @param grid
      * @return GrdRow whit move
      */
    @Override
    public GridRow getMove(GameGrid grid){
        gr.setRow(-1);
        gr.setColumn(-1);
        while (true){
            try {
                Thread.currentThread().sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(HumanPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (newMove()){
                break;
            }
            
        }
        GridRow result = new GridRow(gr.getRow(),gr.getColumn());
        gr.setRow(-1);
        gr.setColumn(-1);
        return (result);
        
        
        
    }    
    
    /**
     * 
     * @param e 
     */
    @Override
    public void HumanClicked(CustomEvent e) {
        Pair<Integer,Integer> cord = (Pair)e.getSource();
        gr = new GridRow(cord.getKey(),cord.getValue());
    }
    /**
     * 
     * @return 
     */
    private boolean newMove(){
        if(gr.getColumn() > -1 && gr.getRow() > -1){
            return (true);
        }
        else return(false);
    }
}

