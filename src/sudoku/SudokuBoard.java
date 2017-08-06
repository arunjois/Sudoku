/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SudokuBoard  {

    public static Scene display() {
        GridPane board = new GridPane();
	board.setPadding(new Insets(20.0));
	TextField[][] field = new TextField[9][9];
	
	
	for(int i=0;i<9;i++) {
		for(int j=0;j<9;j++) {
			field[i][j] = new TextField();
			board.add(field[i][j], i, j);
		}
	}
	
	Scene myScene = new Scene(board,800,500);
	return myScene;
    }    
    

    
}
