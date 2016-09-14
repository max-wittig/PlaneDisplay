package com.spaghettic0der.planedisplay;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    private VBox root;
    private Scene scene;
    private HBox letterHBox;
    private Display display;

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    private void initUI()
    {

        TextField textField = new TextField();
        Button showButton = new Button("SHOW");
        showButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                display.setText(textField.getText());
                updateUI();
            }
        });
        HBox inputHBox = new HBox(textField, showButton);
        letterHBox = new HBox();
        letterHBox.setMinSize(1000, 100);
        root = new VBox(inputHBox, letterHBox);
        scene = new Scene(root);
    }

    private void updateUI()
    {
        for(Letter letter : display.getLetterArrayList())
        {
            Platform.runLater(new Runnable()
            {
                @Override
                public void run()
                {
                    Button button = new Button(String.valueOf(letter.getLetter()));
                    letterHBox.getChildren().add(button);
                }
            });

        }
    }

    private void initDisplay()
    {
        display = new Display();
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        initDisplay();
        initUI();
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                updateUI();
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
