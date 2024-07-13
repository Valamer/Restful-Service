package Messages;

public enum MenuMessage {

    HEADER("Here is available options:"),
    OPTION_1("1. Add game"),
    OPTION_2("2. Delete game"),
    OPTION_3("3. Search game by name"),
    OPTION_4("4. Filter games by cost"),
    OPTION_5("5. Filter Games by rating"),
    OPTION_6("6. View all games, sorted by date"),
    OPTION_7("7. View all games"),
    OPTION_8("8. Exit");

    private final String message;

    MenuMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
