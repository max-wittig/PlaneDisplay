package com.spaghettic0der.planedisplay;


import javafx.application.Platform;
import javafx.scene.control.Button;

public class LetterButton extends Button
{
    private Segment segment;

    public LetterButton(Segment segment)
    {
        this.segment = segment;
    }

    public void updateText()
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                setText(segment.getCurrentLetter().toString());
            }
        });

    }

    public Segment getSegment()
    {
        return segment;
    }
}
