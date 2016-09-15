package com.spaghettic0der.planedisplay;


public enum Letters
{
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H,
    I,
    J,
    K,
    L,
    M,
    N,
    O,
    P,
    Q,
    R,
    S,
    T,
    X,
    Y,
    Z,
    ZERO,
    MINUS,
    PLUS,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN;

    private static Letters[] letters = values();

    public Letters getNext()
    {
        return letters[(this.ordinal() + 1) % letters.length];
    }

}
