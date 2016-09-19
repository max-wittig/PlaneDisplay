package com.spaghettic0der.planedisplay.UI;


import com.spaghettic0der.planedisplay.Logic.Letters;
import com.spaghettic0der.planedisplay.Logic.Segment;
import javafx.application.Platform;
import javafx.scene.control.Button;

public class LetterButton extends Button
{
    private Segment segment;

    public LetterButton(Segment segment)
    {
        setText(Letters.A.toString());
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
