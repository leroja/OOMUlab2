/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.model;

import grupp4.othello.controller.ClickListener;

/**
 *
 * Abstract base class of the players
 */
public abstract class Player implements ClickListener, Runnable{
    protected String  name;
    protected char markörID;

    public abstract GridRow getMove(GameGrid grid);

    public String getName() {
        return name;
    }

    public char getMarkörID() {
        return markörID;
    }
     
    /**
     * Creates a player based on the input
     * @param type the type of player
     * @param name the name of the player
     * @param markörID the "color" of the player's marker
     * @return either a Human- or a ComputerPlayer
     */
    public static Player setPlayer(String type, String name,char markörID){
        if ("Computer".equals(type)){
            return new ComputerPlayer(name, markörID);
        }else{
            return new HumanPlayer(name, markörID);
        }
    }
}
