package com.spaghettic0der.planedisplay.Logic;


import com.spaghettic0der.planedisplay.UI.LetterButton;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class PlaneDisplay
{

    private VBox root;
    private Scene scene;
    private FlowPane letterFlowPane;
    private Display display;
    private final int BUTTON_WIDTH = 70;
    private final int BUTTON_HEIGHT = 100;
    private int delay = 10;
    private Random random;


    public PlaneDisplay(Stage primaryStage)
    {
        random = new Random();
        initUI();
        display = new Display();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void show(String text, int delay, Style style)
    {
        display.setText(text);
        display.setStyle(style);
        this.delay = delay;
        updateAndWait();

    }

    private void initUI()
    {

        letterFlowPane = new FlowPane();
        letterFlowPane.setMinSize(1800, 500);
        root = new VBox(letterFlowPane);
        root.setStyle("-fx-background-color: lightgrey");
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
            Thread.sleep(delay);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void clearScreen()
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                letterFlowPane.getChildren().clear();
            }
        });

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
                    button.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
                    button.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
                    button.setMaxSize(BUTTON_WIDTH, BUTTON_HEIGHT);
                    button.getStylesheets().addAll(getClass().getResource("../css/letterButton.css").toExternalForm());
                    letterFlowPane.getChildren().add(button);
                    FlowPane.setMargin(button, new Insets(8, 1, 1, 1));
                }
            });
        }
    }

    private void setLetter(int i)
    {
        if(display.getStyle() != Style.RANDOM || random.nextFloat() < display.getChance())
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

    private void setRealLetters()
    {
        while(!display.isRealText())
        {
            for(int i=0; i < letterFlowPane.getChildren().size(); i++)
            {
                if(display.getStyle() == Style.SINGLE)
                {
                    for(int j=0; j < Letters.values().length; j++)
                    {
                        setLetter(i);
                    }
                }
                else
                {
                    setLetter(i);
                }

            }
        }
    }

    private void updateUI()
    {
        clearScreen();
        addEmptyLetterButtons();
        sleep();
        setRealLetters();
    }
}
