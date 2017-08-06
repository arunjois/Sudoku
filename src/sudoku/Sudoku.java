
package sudoku;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
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
        

        
	 
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
	primaryStage.setScene(myScene);
        primaryStage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
