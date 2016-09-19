package com.spaghettic0der.planedisplay;

import com.spaghettic0der.planedisplay.Logic.PlaneDisplay;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{

    public static void main(String[] args)
    {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        PlaneDisplay planeDisplay = new PlaneDisplay(primaryStage);
        planeDisplay.show("It is a long established fact that a reader will be distracted by the readable content", 100);
        //planeDisplay.show("Whatever dude", 100);
    }
}
