import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String species;
    private String name;
    private List<String> commands;

    //создание животного
    public Animal(String species, String name) {
        this.species = species;
        this.name = name;
        this.commands = new ArrayList<>();
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }
}
