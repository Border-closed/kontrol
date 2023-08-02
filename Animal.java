import java.util.List;

public class Animal {
    private String name;
    private List<String> commands;
    private AnimalType type;

    public Animal(String name, List<String> commands, AnimalType type) {
        this.name = name;
        this.commands = commands;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public AnimalType getType() {
        return type;
    }

    public void addCommand(String newCommand) {
        commands.add(newCommand);
    }
}
