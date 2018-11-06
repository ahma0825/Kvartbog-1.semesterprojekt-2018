package edu.sdu.woz.text;

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

    public static String modes(int... modes) {
        StringBuilder inner = new StringBuilder();
        for (int flag : modes) {
            inner.append(";").append(flag);
        }
        return "\u001B[" + inner.toString().substring(1) + "m";
    }
}
