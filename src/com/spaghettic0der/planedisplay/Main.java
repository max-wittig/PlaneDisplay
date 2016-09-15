package com.spaghettic0der.planedisplay;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
                updateAndWait();
            }
        });
        HBox inputHBox = new HBox(textField, showButton);
        letterHBox = new HBox();
        letterHBox.setMinSize(1000, 100);
        root = new VBox(inputHBox, letterHBox);
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
            Thread.sleep(100);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void clearScreen()
    {
        letterHBox.getChildren().clear();
    }

    private void addEmptyLetterButtons()
    {
        for(Letter letter : display.getLetterArrayList())
        {
            Platform.runLater(new Runnable()
            {
                @Override
                public void run()
                {
                    Button button = new Button(Letters.A.toString());
                    button.setPrefSize(100,100);
                    button.setStyle("-fx-background-color: black; -fx-font-size: 50px");
                    letterHBox.getChildren().add(button);
                }
            });
        }
    }

    private void setButtonText(Button button, String text)
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                button.setText(text);
            }
        });
    }

    private void setRealLetters()
    {
        int j=0;
        for(Node currentNode : letterHBox.getChildren())
        {

            Button currentButton = (Button)currentNode;
            for (int i = 0; i < Letters.values().length; i++)
            {
                final String buttonText = Letters.values()[i].toString();
                setButtonText(currentButton, buttonText);
                sleep();
                System.out.println(buttonText.toCharArray()[0]);
                System.out.println(display.getLetterArrayList().get(j).getRealLetter());

                if(display.getLetterArrayList().get(j).getRealLetter() == Letters.values()[i].toString().toCharArray()[0])
                {
                    break;
                }
            }
            j++;
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
