package controller;

import javafx.application.Application;
import javafx.stage.Stage;


public class mainController extends Application {
    private UserInterface userInterface;

    public static void main (String[] args) throws Exception {

        parser.parserXml("gridInput.xml");

        launch(args);
    }

    @Override
    public void start (Stage s) throws Exception {
        // create our UI
        userInterface = new UserInterface(s, this);
    }

    public void startSimulation () {
        // TODO Auto-generated method stub

    }

    public void stopSimulation () {
        // TODO Auto-generated method stub

    }

    public void stepSimulation () {
        // TODO Auto-generated method stub

    }

}