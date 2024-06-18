public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.startMessage();
        while (true) {
            userService.showCommands();
            userService.getUserResponse();
        }
    }
}
