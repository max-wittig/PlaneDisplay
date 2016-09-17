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
    U,
    V,
    W,
    X,
    Y,
    Z,
    ZERO
            {
                @Override
                public String toString()
                {
                    return "0";
                }
            },
    MINUS
            {
                @Override
                public String toString()
                {
                    return "-";
                }
            },
    PLUS
            {
                @Override
                public String toString()
                {
                    return "+";
                }
            },
    ONE
            {
                @Override
                public String toString()
                {
                    return "1";
                }
            },
    TWO
            {
                @Override
                public String toString()
                {
                    return "2";
                }
            },
    THREE
            {
                @Override
                public String toString()
                {
                    return "3";
                }
            },
    FOUR
            {
                @Override
                public String toString()
                {
                    return "4";
                }
            },
    FIVE
            {
                @Override
                public String toString()
                {
                    return "5";
                }
            },
    SIX
            {
                @Override
                public String toString()
                {
                    return "6";
                }
            },
    SEVEN
            {
                @Override
                public String toString()
                {
                    return "7";
                }
            },
    EIGHT
            {
                @Override
                public String toString()
                {
                    return "8";
                }
            },
    NINE
            {
                @Override
                public String toString()
                {
                    return "9";
                }
            },
    UNDERSCORE
            {
                @Override
                public String toString()
                {
                    return "_";
                }
            },
    COMMA
            {
        @Override
        public String toString()
        {
            return ",";
        }
    },
    QUESTION_MARK
            {
                @Override
                public String toString()
                {
                    return "?";
                }
            },
    EXCLAMATION_MARK
            {
                @Override
                public String toString()
                {
                    return "!";
                }
            };

    private static Letters[] letters = values();

    public Letters getNext()
    {
        return letters[(this.ordinal() + 1) % letters.length];
    }

    public static Letters fromChar(char c)
    {
        for(Letters currentLetter : letters)
        {
            if(currentLetter.toString().toCharArray()[0] == c)
            {
                return currentLetter;
            }
        }
        return null;
    }

}
