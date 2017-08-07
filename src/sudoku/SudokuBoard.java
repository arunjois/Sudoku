/*
The MIT License

Copyright 2017 arun.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
package sudoku;

import javafx.geometry.*;
import javafx.css.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;

public class SudokuBoard  {

    public static Scene display() {
        GridPane board = new GridPane();
	board.setId("board");
	board.setPadding(new Insets(20));
	TextField[][] field = new TextField[15][15];
	Button ok = new Button("Done");
	Button check = new Button("Solve");
	
	//1st SET
	for(int i=0;i<3;i++) {
		for(int j=0;j<3;j++) {
			field[i][j] = new TextField();
			board.add(field[i][j], i, j);
			field[i][j].setId("field");
		}
	
		for(int j=4;j<7;j++) {
			field[i][j] = new TextField();
			board.add(field[i][j], i, j);
			field[i][j].setId("field");
		}
		
		for(int j=8;j<11;j++) {
			field[i][j] = new TextField();
			board.add(field[i][j], i, j);
			field[i][j].setId("field");
		}
	}
	
	//2nd SET
	for(int i=4;i<7;i++) {
	    for(int j=0;j<3;j++) {
			field[i][j] = new TextField();
			board.add(field[i][j], i, j);
			field[i][j].setId("field");
		}
	
		for(int j=4;j<7;j++) {
			field[i][j] = new TextField();
			board.add(field[i][j], i, j);
			field[i][j].setId("field");
		}
		
		for(int j=8;j<11;j++) {
			field[i][j] = new TextField();
			board.add(field[i][j], i, j);
			field[i][j].setId("field");
		}
	    
	}
	
	//3rd SET
	for(int i=8;i<11;i++) {
	    for(int j=0;j<3;j++) {
			field[i][j] = new TextField();
			board.add(field[i][j], i, j);
			field[i][j].setId("field");
		}
	
		for(int j=4;j<7;j++) {
			field[i][j] = new TextField();
			board.add(field[i][j], i, j);
			field[i][j].setId("field");
		}
		
		for(int j=8;j<11;j++) {
			field[i][j] = new TextField();
			board.add(field[i][j], i, j);
			field[i][j].setId("field");
		}
	    
	}
	board.add(ok,30,5);
	board.add(check,30,6);
	
	board.setHgap(5);
	board.setVgap(5);
	
	//Button Event
	ok.setOnAction(e->Solver.solve());
	check.setOnAction(e->Solver.solve());
	
	Scene myScene = new Scene(board,800,500);
	myScene.getStylesheets().add("sudoku/sudoku.css");
	return myScene;
    }    
    

    
}
