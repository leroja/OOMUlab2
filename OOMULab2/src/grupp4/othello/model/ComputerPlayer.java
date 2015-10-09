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
public class ComputerPlayer extends Player {
    
    public ComputerPlayer(String name, int markorID){
        this.name = name;
        this.markörID = markorID;
    }

    @Override
    public void getMove() {
    }
}
