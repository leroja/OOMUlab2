package grupp4.othello;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import grupp4.othello.model.ComputerPlayer;
import grupp4.othello.model.GameGrid;
import grupp4.othello.model.GridRow;
import grupp4.othello.model.Player;
import grupp4.othello.view.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 *
 * @author Lennart
 */
public class Othello extends Application{
    
    
    @Override
    public void start(Stage stage) throws Exception{
        
        Player p1 = new ComputerPlayer("test1",'B');
        Player p2 = new ComputerPlayer("test2",'W');
        
        
        GameGrid grid = new GameGrid();
        grid.printGameGrid();
        
        while(true){
            try{
                GridRow gRP1 = p1.getMove(grid);
                grid.move(gRP1.getRow(),gRP1.getColumn(),'B');
                grid.printGameGrid();
                System.out.println();
            
                GridRow gRP2 = p2.getMove(grid);
                grid.move(gRP2.getRow(), gRP2.getColumn(),'W');
                grid.printGameGrid();
                System.out.println();
            }catch(Exception e){
                System.out.println(e.getCause());
                System.exit(0);
            }
                
        }
       
        
        
        
    }
}
   
