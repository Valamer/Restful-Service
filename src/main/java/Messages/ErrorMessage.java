package Messages;

public enum ErrorMessage {

    ID_NOT_FOUND("Game with such id not found."),
    GAME_NOT_FOUND("Such game was not found."),
    NO_GAMES_FOUND("No games with such parameters were found."),
    INVALID_INPUT("Invalid input.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
