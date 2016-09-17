package com.spaghettic0der.planedisplay;


import java.util.ArrayList;

public class Display
{
    private ArrayList<Letter> letterArrayList;

    public Display()
    {
        letterArrayList = new ArrayList<>();
    }

    public ArrayList<Letter> getLetterArrayList()
    {
        return letterArrayList;
    }

    private String getOptimizedText(String text)
    {
        return text.toUpperCase().replace(" ", "_");
    }

    public void setText(String text)
    {
        getLetterArrayList().clear();
        text = getOptimizedText(text);
        for(char c : text.toCharArray())
        {
            Letter letter = new Letter(c);
            letterArrayList.add(letter);
        }
    }
}
