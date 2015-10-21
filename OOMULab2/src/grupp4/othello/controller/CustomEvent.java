/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.controller;

import java.util.EventObject;

/**
 * the event object class that is contains the
 * information that is send from the event generators to the listeners
 */
public class CustomEvent extends EventObject {
    /**
     * 
     * @param source the information about the event
     */
    public CustomEvent(Object source) {
        super(source);
    }
}
