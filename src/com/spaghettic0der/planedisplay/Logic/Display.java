package com.spaghettic0der.planedisplay.Logic;


import java.util.ArrayList;

public class Display
{
    private ArrayList<Segment> segmentArrayList;
    private String realText;
    private Style style;
    private float chance = 0.1f;

    public String getRealText()
    {
        return realText;
    }

    public Style getStyle()
    {
        return style;
    }

    public float getChance()
    {
        return chance;
    }

    public void setStyle(Style style)
    {
        this.style = style;
    }

    public void setChance(float chance)
    {
        this.chance = chance;
    }

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
        return text.toUpperCase().replace("ü", "ue").replace("ö", "oe").replace("ä", "ae");
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
