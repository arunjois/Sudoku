/*
The MIT License

Copyright 2017 arun.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
getStyle
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

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Sudoku extends Application {
    Scene level;
    @Override
    public void start(Stage primaryStage) {
        Button play = new Button("Game");
        Button solver = new Button("Solver");
        Pane myPane = new Pane();
        play.setLayoutX(350);
        play.setLayoutY(200);
        solver.setLayoutX(350);
        solver.setLayoutY(250);
        play.setPrefSize(80 ,30 );
        solver.setPrefSize(80 ,30 );
        play.setOnAction(e->{
		primaryStage.setScene(level);
	}); 
        solver.setOnAction(e->{
		primaryStage.setScene(SudokuBoard.display());		
	});
        myPane.getChildren().add(play);
        myPane.getChildren().add(solver);
        Scene myScene = new Scene(myPane,800,500);
        RadioButton easy,medium,hard;
        ToggleGroup radioGroup = new ToggleGroup();
        
        
        HBox hbox = new HBox(10);
        hbox.getChildren().add(easy = new RadioButton("Easy"));
        hbox.getChildren().add(medium = new RadioButton("Medium"));
        hbox.getChildren().add(hard = new RadioButton("Hard"));
        level = new Scene(hbox,800,500);
        easy.setToggleGroup(radioGroup);
        medium.setToggleGroup(radioGroup);
        hard.setToggleGroup(radioGroup);
        hbox.setAlignment(Pos.CENTER);
	easy.setUserData("Easy");
	medium.setUserData("Medium");
	hard.setUserData("Hard");
	
	
	
	//Event
	radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		public void changed(ObservableValue<? extends Toggle> ov,
		Toggle old_toggle, Toggle new_toggle) {
                if (radioGroup.getSelectedToggle() != null) {
			String tmp = radioGroup.getSelectedToggle().getUserData().toString();
			GeneratePuzzle puzzle = new GeneratePuzzle(tmp);
			primaryStage.setScene(puzzle.display());
            }                
        }
        });
	
        

        
	myPane.setStyle("-fx-background-color:  #6495ed");
	hbox.setStyle("-fx-background-color:  #6495ed");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
	primaryStage.setScene(myScene);
        primaryStage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
