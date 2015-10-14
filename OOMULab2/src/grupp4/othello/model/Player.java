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
public abstract class Player {
    protected String  name;
    protected char markörID;

    public abstract GridRow getMove();
}
