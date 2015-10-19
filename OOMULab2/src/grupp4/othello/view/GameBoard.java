/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp4.othello.view;

import grupp4.othello.controller.ClickGenerator;
import grupp4.othello.controller.CustomEvent;
import grupp4.othello.controller.ClickListener;
import grupp4.othello.controller.UpdtListener;
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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Pair;

/**
 *
 * @author Lennart
 */
public class GameBoard implements ClickGenerator, UpdtListener{
    GridPane grid;
    ClickListener list;
    Circle[][] circles;
    
    
    public GameBoard(){
        // Temp kod, ta bort
        grid = new GridPane();
        grid.setGridLinesVisible(true);
        circles = new Circle[8][8];
        
        for(int i=0;i<8; i++){
            for(int j = 0;j<8; j++){
                StackPane tile= new StackPane();
                tile.setMinSize(50, 50);
                Circle c = new Circle(20,Color.TRANSPARENT);
                grid.add(tile, i, j);
                circles[i][j] = c;
                grid.add(c, j, i);
                GridPane.setMargin(c,new Insets(5));
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
                    if(node instanceof StackPane) {
                        if(node.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
                            //temp
                            Pair<Integer,Integer> cord = new Pair<>(GridPane.getRowIndex( node),GridPane.getColumnIndex(node));
                            list.HumanClicked(new CustomEvent(cord));
                            //placeMarker(GridPane.getRowIndex( node),GridPane.getColumnIndex(node), Color.BLACK);
                            //System.out.println( "Node: " + node + " at " + GridPane.getRowIndex( node) + "/" + GridPane.getColumnIndex(node));
                            break;
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
//        placeMarker(4,3,Color.BLACK);
//        placeMarker(3,4,Color.BLACK);
//        placeMarker(3,3,Color.WHITE);
//        placeMarker(4,4,Color.WHITE);
        circles[4][3].setFill(Color.BLACK);
        circles[3][4].setFill(Color.BLACK);
        circles[4][4].setFill(Color.WHITE);
        circles[3][3].setFill(Color.WHITE);
    }
    
    public void placeMarker(int row, int column, Color col){
        Circle w2 = new Circle(20,col);
        w2.setStroke(col);
        grid.add(w2, column, row);
        
        GridPane.setMargin(w2,new Insets(5));
    }
    
    public void onUppdateInGameGrid(char[][] grid){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (grid[i][j]== 'B'){
                    placeMarker(i,j,Color.BLACK);
                }
                else if (grid[i][j]== 'W'){
                    placeMarker(i,j,Color.WHITE); 
                }

            }
        }
    }

    @Override
    public void addListener(ClickListener listener) {
        
        list = listener;
    }

    @Override
    public void updated(CustomEvent e) {
//        char[][] grid = (char[][])e.getSource();
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (grid[i][j]== 'B'){
//                    placeMarker(i,j,Color.BLACK);
//                }
//                else if (grid[i][j]== 'W'){
//                    placeMarker(i,j,Color.WHITE); 
//                }
//            }
//        }
//        
        
        char[][] test = (char[][])e.getSource();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (test[i][j]== 'B'){
                    circles[i][j].setFill(Color.BLACK);
                }else if (test[i][j]== 'W'){
                    circles[i][j].setFill(Color.WHITE);
                }else if(test[i][j] == 0){
                    circles[i][j].setFill(Color.TRANSPARENT);
                }
                
            }
        }
        
//        Pair<Pair<Integer, Integer>,Character> test = (Pair)e.getSource();
//        if(test.getValue() == 'B'){
//            placeMarker(test.getKey().getKey(),test.getKey().getValue(),Color.BLACK);
//        }else if(test.getValue() == 'W'){
//            placeMarker(test.getKey().getKey(),test.getKey().getValue(),Color.WHITE);
//        }
//        
    }
}
 
