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
    private VBox root;
    private Scene scene;
    private FlowPane letterFlowPane;
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
                updateAndWait();
            }
        });
        HBox inputHBox = new HBox(textField, showButton);
        letterFlowPane = new FlowPane();
        letterFlowPane.setMinSize(1800, 500);
        root = new VBox(inputHBox, letterFlowPane);
        root.setStyle("-fx-background-color: black");
        scene = new Scene(root);
    }

    private void updateAndWait()
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                updateUI();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private void sleep()
    {
        try
        {
            Thread.sleep(10);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void clearScreen()
    {
        letterFlowPane.getChildren().clear();
    }

    private void addEmptyLetterButtons()
    {
        for(Segment segment : display.getSegmentArrayList())
        {
            Platform.runLater(new Runnable()
            {
                @Override
                public void run()
                {
                    LetterButton button = new LetterButton(segment);
                    button.setPrefSize(100, 100);
                    button.setStyle("-fx-background-color: black; -fx-font-size: 40px");
                    letterFlowPane.getChildren().add(button);
                }
            });
        }
    }

    private void setRealLetters()
    {
        while(!display.isRealText())
        {
            for(int i=0; i < letterFlowPane.getChildren().size(); i++)
            {

                LetterButton currentButton = (LetterButton) letterFlowPane.getChildren().get(i);
                Segment currentSegment = currentButton.getSegment();

                currentButton.updateText();
                if (!currentSegment.isRightLetter())
                {
                    currentSegment.nextLetter();
                    sleep();
                }

            }
        }
    }

    private void updateUI()
    {
        addEmptyLetterButtons();
        sleep();
        setRealLetters();
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

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
