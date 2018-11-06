package edu.sdu.woz.text;

public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), INVENTORY("inventory"), TAKE("take"), ANSWER("answer"), UNKNOWN("?");

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}
