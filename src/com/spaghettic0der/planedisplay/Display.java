package com.spaghettic0der.planedisplay;


import java.util.ArrayList;

public class Display
{
    private ArrayList<Segment> segmentArrayList;
    private String realText;

    public Display()
    {
        segmentArrayList = new ArrayList<>();
    }

    public ArrayList<Segment> getSegmentArrayList()
    {
        return segmentArrayList;
    }

    private String getOptimizedText(String text)
    {
        return text.toUpperCase().replace(" ", "_");
    }

    public boolean isRealText()
    {
        for(Segment segment : segmentArrayList)
        {
            if(segment.getRealLetter() != segment.getCurrentLetter())
            {
                return false;
            }
        }
        return true;
    }

    public void setText(String text)
    {
        getSegmentArrayList().clear();
        text = getOptimizedText(text);
        realText = text;
        for(char c : text.toCharArray())
        {
            Letters letter = Letters.fromChar(c);
            Segment segment = new Segment(letter);
            segmentArrayList.add(segment);
        }
    }
}
