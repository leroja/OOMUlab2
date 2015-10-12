/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Lennart
 */
public class GameBoard {
    GridPane grid;
    
    public GameBoard(){
        // Temp kod, ta bort
        grid = new GridPane();
        grid.setGridLinesVisible(true);
        
        
        for(int i=0;i<8; i++){
            for(int j = 0;j<8; j++){
                Circle ci = new Circle(20,20,20,Color.TRANSPARENT);
                grid.add(ci, i, j);
                GridPane.setMargin(ci,new Insets(5));
            }
        }
        
        BackgroundImage backImage = new BackgroundImage(new Image(getClass().getResourceAsStream(
        "/resources/reversi_background.jpg")),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, 
        BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        
        grid.setBackground(new Background(backImage));
        
    }
    
    
    public GridPane getGridPane(){
        
        
        return grid;
    }
}
