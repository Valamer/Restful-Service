import java.util.Scanner;

public class UserService {
    private final Scanner scanner = new Scanner(System.in);
    private final PetService petService = new PetService();

    public void getUserResponse () {
        switch (scanner.nextLine()){
            case "add" -> {addPet();}
            case "take" -> {takePet();}
            case "show all" -> {showPets();}
            case "exit" -> {System.exit(0);}
            default -> {System.out.println("Invalid input");}
        }
    }

    private void takePet () {
        System.out.println("Please, enter pet id: ");
        petService.remove(scanner.nextInt());
        System.out.println("Pet taken!");
    }

    private void addPet () {
        Pet newPet = new Pet();

        System.out.println("Please, enter name: ");
        newPet.setName(scanner.next());
        System.out.println("Please, enter kind");
        newPet.setKind(scanner.next());
        System.out.println("Please, enter breed: ");
        newPet.setBreed(scanner.next());
        System.out.println("Please, enter age: ");
        newPet.setAge(scanner.nextInt());

        petService.add(newPet);

        System.out.println("Pet added!");
    }

    private void showPets () {
        System.out.println("----------------------------------------------------");
        petService.showAll();
        System.out.println("----------------------------------------------------");
    }

    public void startMessage () {
        System.out.println("Greetings! This app represent pet shelter. Here you can leave/take animal.");
    }

    public void showCommands () {
        System.out.println("List of commands: \nadd \ntake \nshow all \nexit");
    }


}
