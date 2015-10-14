package grupp4.othello;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import grupp4.othello.model.GameGrid;
import grupp4.othello.view.*;
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
    public void start(Stage stage) throws Exception {
        
//        ArrayList<Pair<Integer,Integer>> arr = new ArrayList<Pair<Integer,Integer>>();
//        GameGrid grid = new GameGrid();
//        arr=grid.getAvailableMoves('B');
//        for (int i=0;i<arr.size();i++){
//            System.out.println(arr.get(i));
//        }
       
       
        GameFrame game = new GameFrame();
        game.displayGameFrame(stage);
    }
    
}
