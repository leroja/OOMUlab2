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
 *
 * @author alexander
 */
public class HumanPlayer extends Player{
    private GridRow gr;
    
     public HumanPlayer(String name, char markorID){
         gr = new GridRow(-1,-1);
        this.name = name;
        this.markörID = markorID;
     }
     
    @Override
    public GridRow getMove(GameGrid grid){
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
        GridRow result = new GridRow(gr.row,gr.column);
        gr.row = -1;
        gr.column = -1;
        return (result);
        
        
        
    }    

    @Override
    public void HumanClicked(CustomEvent e) {
        Pair<Integer,Integer> cord = (Pair)e.getSource();
        gr = new GridRow(cord.getKey(),cord.getValue());
        System.out.println(cord);
    }
    private boolean newMove(){
        if(gr.column > -1&& gr.row > -1){
            return (true);
        }
        else return(false);
    }

    @Override
    public void run() {
    
    }
}

