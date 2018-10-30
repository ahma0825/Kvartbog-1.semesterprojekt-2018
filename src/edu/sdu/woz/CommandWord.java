package edu.sdu.woz;

public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), INVENTORY("inventory"), TAKE("take"), UNKNOWN("?");

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}
