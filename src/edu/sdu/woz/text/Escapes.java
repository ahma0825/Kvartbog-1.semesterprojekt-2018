package edu.sdu.woz.text;

@SuppressWarnings({"unused", "WeakerAccess"})
public class Escapes {

    public static final String RESET = modes(0);
    public static final int BOLD = 1;
    public static final int UNDERSCORE = 4;
    public static final int BLINK = 5;
    public static final int REVERSE_VIDEO = 7;
    public static final int CONCEALED = 8;

    public static final int FG_BLACK = 30;
    public static final int FG_RED = 31;
    public static final int FG_GREEN = 32;
    public static final int FG_YELLOW = 33;
    public static final int FG_BLUE = 34;
    public static final int FG_MAGENTA = 35;
    public static final int FG_CYAN = 36;
    public static final int FG_WHITE = 37;

    public static final int BG_BLACK = 40;
    public static final int BG_RED = 41;
    public static final int BG_GREEN = 42;
    public static final int BG_YELLOW = 43;
    public static final int BG_BLUE = 44;
    public static final int BG_MAGENTA = 45;
    public static final int BG_CYAN = 46;
    public static final int BG_WHITE = 47;

    public static final int FG_BR_BLACK = 90;
    public static final int FG_BR_RED = 91;
    public static final int FG_BR_GREEN = 92;
    public static final int FG_BR_YELLOW = 93;
    public static final int FG_BR_BLUE = 94;
    public static final int FG_BR_MAGENTA = 95;
    public static final int FG_BR_CYAN = 96;
    public static final int FG_BR_WHITE = 97;

    public static final int BG_BR_BLACK = 100;
    public static final int BG_BR_RED = 101;
    public static final int BG_BR_GREEN = 102;
    public static final int BG_BR_YELLOW = 103;
    public static final int BG_BR_BLUE = 104;
    public static final int BG_BR_MAGENTA = 105;
    public static final int BG_BR_CYAN = 106;
    public static final int BG_BR_WHITE = 107;

    /* Shorthands */
    public static final String GO_BOLD = modes(BOLD);
    public static final String GO_RED = modes(BOLD);
    public static final String GO_SCARY = modes(BOLD, UNDERSCORE, BLINK, FG_RED);

    public static String modes(int... modes) {
        StringBuilder inner = new StringBuilder();
        for (int flag : modes) {
            inner.append(";").append(flag);
        }
        return "\u001B[" + inner.toString().substring(1) + "m";
    }
}
