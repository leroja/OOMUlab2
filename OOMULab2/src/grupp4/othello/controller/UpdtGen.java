/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.controller;

/**
 * interface for the classes that generates UpdateEvents
 * 
 */
public interface UpdtGen {
    /**
     * adds listeners that listens for UpdateEvents
     * @param listener
     */
    public void addUpdtListener(UpdtListener listener);
}
