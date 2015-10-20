/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.controller;

import java.util.EventListener;

/**
 *
 * @author Lennart
 */
public interface NewGameListener extends EventListener{
    /**
     * 
     * @param e 
     */
    void newGame(CustomEvent e);
}
