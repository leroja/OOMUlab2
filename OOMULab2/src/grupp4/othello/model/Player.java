/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.model;

import grupp4.othello.controller.CustomListener;

/**
 *
 * @author alexander
 */
public abstract class Player implements CustomListener, Runnable{
    protected String  name;
    protected char markörID;

    public abstract GridRow getMove(GameGrid grid);

    public String getName() {
        return name;
    }

    public char getMarkörID() {
        return markörID;
    }
     
    
    public static Player setPlayer(String type, String name,char markörID){
        if ("Computer".equals(type)){
            return new ComputerPlayer(name, markörID);
        }else{
            return new HumanPlayer(name, markörID);
        }
    }
}
