package com.spaghettic0der.planedisplay.Logic;

public class Segment
{
    private Letters realLetter;
    private Letters currentLetter = Letters.A;
    private int letterNumber;

    public Segment(Letters realLetter)
    {
        this.realLetter = realLetter;
    }

    public Letters getRealLetter()
    {
        return realLetter;
    }

    public Letters getCurrentLetter()
    {
        return currentLetter;
    }

    public void setCurrentLetter(Letters currentLetter)
    {
        this.currentLetter = currentLetter;
    }

    public void nextLetter()
    {
        currentLetter = currentLetter.getNext();
    }

    public boolean isRightLetter()
    {
        if(realLetter == currentLetter)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
