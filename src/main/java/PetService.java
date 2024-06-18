import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PetService {
    private PetSerializer serializer = new PetSerializer();
    private File existingPets = new File("src/main/resources/Pets.json");
    private ArrayList<Pet> pets = (ArrayList<Pet>) getPets();

    public List<Pet> getPets() {
        try {
            if (!existingPets.exists()) {existingPets.createNewFile();}
            return serializer.deserializeList(existingPets);
        } catch (IOException e) {
            System.err.println("Something went wrong when trying to get pets data");
            return new ArrayList<Pet>();
        }
    }

    public  void add(Pet pet) {
        try {
            pets.add(pet);
            serializer.serializeList(pets, existingPets);
        } catch (IOException e) {
            System.err.println("Error during serialization");
        }
    }

    public void remove(int id) {
        try {
            pets.remove(id);
            serializer.serializeList(pets, existingPets);
        } catch (IOException e) {
            System.err.println("Error during serialization");
        }
    }

    public void showAll(){
        for (int i = 0; i < pets.size(); i++) {
            System.out.println("ID " + i + " -> " + pets.get(i));
        }
    }
}
