import java.util.List;

public class AnimalCommands {
    public static void displayCommands(Animal animal) {
        System.out.println("Команды, которые выполняет " + animal.getName() + ":");
        List<String> commands = animal.getCommands();
        for (String command : commands) {
            System.out.println(command);
        }
    }
}
