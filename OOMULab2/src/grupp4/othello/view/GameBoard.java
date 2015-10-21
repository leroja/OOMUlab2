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
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
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
    private GridPane grid;
    private ArrayList<ClickListener>  listeners = new ArrayList<>();
    private Circle[][] circles;
    
    /**
     * 
     */
    public GameBoard(){
        grid = new GridPane();
        grid.setGridLinesVisible(true);
        circles = new Circle[8][8];
        
        for(int i=0;i<8; i++){
            for(int j = 0;j<8; j++){
                StackPane tile= new StackPane();
                tile.setMinSize(50, 50);
                tile.setFocusTraversable(true);
                tile.setOnKeyPressed((KeyEvent event) -> {
                    if(event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.SPACE){
                        Pair<Integer,Integer> cord = new Pair<>(GridPane.getRowIndex(tile),GridPane.getColumnIndex(tile));
                        fireEvent(new CustomEvent(cord));
                    }
                });
                tile.focusedProperty().addListener(new ChangeListener<Boolean>(){
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        if(tile.isFocused()){
                            tile.setStyle("-fx-border-color: yellow;");
                        }
                        if(!tile.isFocused()){
                            tile.setStyle("-fx-border-color: transparent;");
                        }
                    }
                });
                               
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
                            Pair<Integer,Integer> cord = new Pair<>(GridPane.getRowIndex( node),GridPane.getColumnIndex(node));
                            fireEvent(new CustomEvent(cord));
                            break;
                        }
                    }
                }
            }
        });
    
    }
    
    /**
     * 
     * @return 
     */
    public GridPane getGameBoard(){
        return grid;
    }
    
    
    private void setStartingPos(){
        circles[4][3].setFill(Color.BLACK);
        circles[3][4].setFill(Color.BLACK);
        circles[4][4].setFill(Color.WHITE);
        circles[3][3].setFill(Color.WHITE);
    }
    
    /**
     * 
     * @param row
     * @param column
     * @param col 
     */
    private void updateMarker(int row, int column, Color col){
        
        circles[row][column].setFill(col);
    }
    
    /**
     * Fires the event to all listeners
     * @param e the information about the event
     */
    private void fireEvent(CustomEvent e){
        int j = listeners.size();
        if (j == 0){
            return;
        }
        for(int i = 0; i < j; i++) {
            listeners.get(i).HumanClicked(e);
        }
    }

    /**
     * Adds the listener to the listener ArrayList
     * @param listener 
     */
    @Override
    public void addListener(ClickListener listener) {
        
        listeners.add(listener);
    }

    
    /**
     * 
     * @param e 
     */
    @Override
    public void updated(CustomEvent e) { 
        
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
    }
}
 
