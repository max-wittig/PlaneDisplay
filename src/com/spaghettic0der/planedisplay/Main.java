package com.spaghettic0der.planedisplay;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        new PlaneDisplay(primaryStage);
    }
}
