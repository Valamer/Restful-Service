package Messages;

public enum GameMessage {

    ADD_NAME("Enter game name: "),
    ADD_DATE("Enter release date: "),
    ADD_RATING("Enter rating: "),
    ADD_COST("Enter cost: "),
    ADD_DESCRIPTION("Enter description: "),
    SUCCESS_ADD("Game added successfully!"),
    DELETE_ID("Enter id of game, you want to delete: "),
    SEARCH_NAME("Enter name to search: "),
    NAME_EXISTS("A game with same name already exists!"),
    FILTER_MIN_COST("Enter minimum game cost: "),
    FILTER_MAX_COST("Enter maximum game cost: "),
    FILTER_MIN_RATING("Enter minimum game rating: "),
    EXITING("Exiting...");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
