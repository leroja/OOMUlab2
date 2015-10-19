/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.model;

import grupp4.othello.controller.CustomEvent;
import javafx.util.Pair;

/**
 *
 * @author alexander
 */
public class HumanPlayer extends Player{

    private GridRow gr;
    
     public HumanPlayer(String name, char markorID){
        this.name = name;
        this.markörID = markorID;
        
    }
     
    @Override
    public GridRow getMove(GameGrid grid){
        
        //return gr;
         return null;
        
    }    

    @Override
    public void HumanClicked(CustomEvent e) {
        Pair<Integer,Integer> cord = (Pair)e.getSource();
        gr = new GridRow(cord.getKey(), cord.getValue());
        System.out.println(cord);
    }

    @Override
    public void run() {
    
    }
}

