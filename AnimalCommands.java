import java.util.ArrayList;
import java.util.List;

public class AnimalCommands {
    private List<String> commands = new ArrayList<>();

    public void addCommand(String command) {
        commands.add(command);
    }

    public List<String> getCommands() {
        return commands;
    }
}
