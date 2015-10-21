/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.model;

/**
 * Class for remembering positions in the game board
 * 
 */
public class GridRow {
    private int row;
    private int column;

    /**
     * gets the value of row 
     * @return row
     */
    public int getRow() {
        return row;
    }
    /**
     * Sets the value of row
     * @param row 
     */
    public void setRow(int row) {
        this.row = row;
    }
    /**
     * gets value of column
     * @return column
     */
    public int getColumn() {
        return column;
    }
    /**
     * set value of column
     * @param column 
     */
    public void setColumn(int column) {
        this.column = column;
    }
    
    /**
     * constructor for GridRow
     * @param row
     * @param column 
     */
    public GridRow(int row,int column){
        this.row = row;
        this.column = column;
    }
    
}
