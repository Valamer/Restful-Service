import Messages.ErrorMessage;
import Messages.GameMessage;
import Messages.MenuMessage;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GameShop {
    private final Scanner scanner = new Scanner(System.in);
    private final DataBaseManipulations dataBase = new DataBaseManipulations();

    public static void main(String[] args) {
        GameShop gameShop = new GameShop();
        while (true) {
            gameShop.printMenu();
            gameShop.userResponse();
        }
    }

    public void userResponse() {
        String input = scanner.nextLine();
        switch (Integer.parseInt(input)) {
            case 1-> {addGame();}
            case 2 -> {deleteGame();}
            case 3 -> {searchGameByName();}
            case 4 -> {filterGamesByCost();}
            case 5 -> {filterGamesByRating();}
            case 6 -> {getAllGamesSortedByCreationDate();}
            case 7 -> {getAllGames();}
            case 8 -> {System.exit(0);}
            default -> {System.out.println(ErrorMessage.INVALID_INPUT.getMessage());}
        }
    }

    public void printMenu() {
        for (MenuMessage value : MenuMessage.values()) {
            System.out.println(value.getMessage());
        }
    }

    public void addGame() {
        System.out.print(GameMessage.ADD_NAME.getMessage());
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return;
        }
        if (dataBase.searchGameByName(name) != null) {
            System.out.println(GameMessage.NAME_EXISTS.getMessage());
            return;
        }

        System.out.print(GameMessage.ADD_DATE.getMessage());
        String date = scanner.nextLine();
        if (date.isEmpty()) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return;
        }
        Date releaseDate = Date.valueOf(date);

        System.out.print(GameMessage.ADD_RATING.getMessage());
        String ratingInput = scanner.nextLine();
        if (ratingInput.isEmpty()) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return;
        }
        float rating = Float.parseFloat(ratingInput);

        System.out.print(GameMessage.ADD_COST.getMessage());
        String costInput = scanner.nextLine();
        if (costInput.isEmpty()) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return;
        }
        double cost = Double.parseDouble(costInput);

        System.out.print(GameMessage.ADD_DESCRIPTION.getMessage());
        String description = scanner.nextLine();
        if (description.isEmpty()) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return;
        }
        Date creationDate = Date.valueOf(LocalDate.now());

        Game game = new Game(0, name, releaseDate, rating, cost, description, creationDate);
        dataBase.addGame(game);
        System.out.println(GameMessage.SUCCESS_ADD.getMessage());
    }

    public void deleteGame() {
        System.out.print(GameMessage.DELETE_ID.getMessage());
        String id = scanner.nextLine();
        if (id.isEmpty()) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return;
        }
        Game game = dataBase.searchGameById(Integer.parseInt(id));
        if (game != null) {
            printGameDetails(game);
        } else {
            System.out.println(ErrorMessage.ID_NOT_FOUND.getMessage());
        }
    }

    public void searchGameByName() {
        System.out.print(GameMessage.SEARCH_NAME.getMessage());
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return;
        }
        Game game = dataBase.searchGameByName(name);
        if (game != null) {
            printGameDetails(game);
        } else {
            System.out.println(ErrorMessage.GAME_NOT_FOUND.getMessage());
        }
    }

    public void filterGamesByCost() {
        System.out.print(GameMessage.FILTER_MIN_COST.getMessage());
        String minCostInput = scanner.nextLine();
        if (minCostInput == null || minCostInput.isEmpty()) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return;
        }
        double minCost = Double.parseDouble(minCostInput);

        System.out.print(GameMessage.FILTER_MAX_COST.getMessage());
        String maxCostInput = scanner.nextLine();
        if (maxCostInput == null || maxCostInput.isEmpty()) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return;
        }
        double maxCost = Double.parseDouble(maxCostInput);

        List<Game> games = dataBase.filterGamesByCost(minCost, maxCost);
        printGameList(games);
    }

    public void filterGamesByRating() {
        System.out.print(GameMessage.FILTER_MIN_RATING.getMessage());
        String minRatingInput = scanner.nextLine();
        if (minRatingInput == null || minRatingInput.isEmpty()) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return;
        }
        float minRating = Float.parseFloat(minRatingInput);

        List<Game> games = dataBase.filterGamesByRating(minRating);
        printGameList(games);
    }

    public void getAllGamesSortedByCreationDate() {
        List<Game> games = dataBase.getAllGamesSortedByCreationDate();
        printGameList(games);
    }

    private void getAllGames() {
        List<Game> games = dataBase.getAllGames();
        printGameList(games);
    }

    public void printGameDetails(Game game) {
        if (game == null) {
            System.out.println(ErrorMessage.INVALID_INPUT.getMessage());
            return;
        }
        System.out.println("ID: " + game.getId());
        System.out.println("Name: " + game.getName());
        System.out.println("Release Date: " + game.getReleaseDate());
        System.out.println("Rating: " + game.getRating());
        System.out.println("Cost: " + game.getCost());
        System.out.println("Description: " + game.getDescription());
        System.out.println("Creation Date: " + game.getCreationDate());
        System.out.println();
    }

    public void printGameList(List<Game> games) {
        if (games.isEmpty()) {
            System.out.println(ErrorMessage.NO_GAMES_FOUND.getMessage());
        } else {
            for (Game game : games) {
                printGameDetails(game);
            }
        }
    }
}
