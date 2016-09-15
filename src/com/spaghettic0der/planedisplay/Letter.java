package com.spaghettic0der.planedisplay;

public class Letter
{
    private char realLetter;
    private char currentLetter = Letters.A.toString().toCharArray()[0];
    private int letterNumber;

    public Letter(char realLetter)
    {
        this.realLetter = realLetter;
    }

    public char getRealLetter()
    {
        return realLetter;
    }

    public char getCurrentLetter()
    {
        return currentLetter;
    }

    public void setCurrentLetter(char currentLetter)
    {
        this.currentLetter = currentLetter;
    }
}
