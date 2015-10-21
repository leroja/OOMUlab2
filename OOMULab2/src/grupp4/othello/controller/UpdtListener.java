/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.controller;

import java.util.EventListener;

/**
 *
 * interface for the classes that listens for UpdateEvents
 */
public interface UpdtListener extends EventListener{
    /**
     * methods that listens for UpdateEvents
     * @param e information about the event
     */
    public void updated(CustomEvent e);
}
