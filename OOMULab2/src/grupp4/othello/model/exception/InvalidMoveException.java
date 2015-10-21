/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.model.exception;

/**
 * This exception is thrown when a player makes an invalid move
 * 
 */
public class InvalidMoveException extends Exception{
    
    /**
     * This exception is thrown when a player makes an invalid move
     */
    public InvalidMoveException(){
        super("InvalidMoveException");
    }
    
}
