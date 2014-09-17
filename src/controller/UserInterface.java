package controller;

import java.io.File;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class UserInterface {
    private MainController myMainController;
    private Pane rootPane;
    private Stage myStage;

    public UserInterface (Stage s, MainController mainController) {
        myMainController = mainController;
        Stage myStage = s;
        myStage.setTitle("Cell Society Team 4");

        rootPane = new Pane();
        Scene myScene = new Scene(rootPane, 500, 540);
        myStage.setScene(myScene);
        myStage.show();
        makeBottomPanel();
    }

    private void makeBottomPanel () {
        //buttons
        rootPane.getChildren().add(createButton("Start", 0, 510, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                myMainController.startSimulation();
            }
        }));
        rootPane.getChildren().add(createButton("Stop", 60, 510, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                myMainController.stopSimulation();
            }
        }));
        rootPane.getChildren().add(createButton("Step", 120, 510, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                myMainController.stepSimulation();
            }
        }));
        rootPane.getChildren().add(createButton("Choose File", 200, 510, new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                // show file dialog
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open XML File");
                final File XMLData = fileChooser.showOpenDialog(myStage);
                myMainController.initializeSimulationWithData(XMLData);
            }
        }));
        //slider
        rootPane.getChildren().add(createSlider(0,1,.1,320,515, new ChangeListener<Number>(){
            public void changed (ObservableValue<? extends Number> ov,
                                 Number old_val, Number new_val) {
                myMainController.setSimulationSpeed((double) new_val);
            }
        }));
    }

    private Button createButton (String title, int posX, int posY, EventHandler<ActionEvent> handler) {
        Button button = new Button(title);
        button.setLayoutX(posX);
        button.setLayoutY(posY);
        button.setOnAction(handler);
        return button;
    }
    
    private Slider createSlider (int start, int stop, double startVal, int posX, int posY, ChangeListener<Number> listener){
        Slider slider = new Slider(start, stop, startVal);
        slider.setLayoutX(posX);
        slider.setLayoutY(posY);
        slider.valueProperty().addListener(listener);
        return slider;
    }

    public Pane getRootPane () {
        return rootPane;
    }
}
