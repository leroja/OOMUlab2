/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
        setStartingPos();
        
        BackgroundImage backImage = new BackgroundImage(new Image(getClass().getResourceAsStream(
        "/resources/reversi_background.jpg")),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, 
        BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        
        grid.setBackground(new Background(backImage));
            
        grid.setFocusTraversable(true);
        grid.requestFocus();
        
        grid.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e) {
                for(Node node: grid.getChildren()){
                    if(node instanceof Circle) {
                        if(node.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
                            System.out.println( "Node: " + node + " at " + GridPane.getRowIndex( node) + "/" + GridPane.getColumnIndex(node));
                        }
                    }
                }
            }
        });
        
        grid.setOnKeyPressed(new EventHandler<KeyEvent>(){
            
            @Override
            public void handle(KeyEvent event) {
                
                
            };
        });
        
        grid.setOnKeyReleased(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent event) {
            
            }
            
        });
        
        
    }
    
    
    public GridPane getGridPane(){
        return grid;
    }
    
    public void setStartingPos(){
        placeMarker(4,3,Color.BLACK);
        placeMarker(3,4,Color.BLACK);
        placeMarker(3,3,Color.WHITE);
        placeMarker(4,4,Color.WHITE);
    }
    
    public void placeMarker(int row, int column, Color col){
        Circle w2 = new Circle(20,20,20,col);
        grid.add(w2, row, column);
        GridPane.setMargin(w2,new Insets(5));
    }
}
    
class WhiteMarker extends Marker{
    
    
    
} 
class BlackMarker extends Marker{
    

}

abstract class Marker{ 
}
    
class Tile{
    
} 
