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
public class HumanPlayer extends Player{

     public HumanPlayer(String name, char markorID){
        this.name = name;
        this.markörID = markorID;
    }
     
    @Override
    public void getMove(){
    }
}
