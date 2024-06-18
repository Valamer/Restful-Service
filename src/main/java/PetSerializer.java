import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PetSerializer {

    private final ObjectMapper mapper;

    public PetSerializer() {
        this.mapper = new JsonMapper();
    }

    public void serialize(Pet pet, File file) throws IOException {
        this.mapper.writeValue(file, pet);
    }

    public void serializeList(ArrayList<Pet> list, File file) throws IOException {
        this.mapper.writeValue(file, list);
    }

    public Pet deserialize(File file) throws IOException {
        return this.mapper.readValue(file, Pet.class);
    }

    public List<Pet> deserializeList(File file) throws IOException {
        return this.mapper.readValue(file, new TypeReference<List<Pet>>() {});
    }
}
