import java.util.List;

public class AnimalTrainer {
    public void teachAnimal(Animal animal, List<String> newCommands) {
        animal.getCommands().addAll(newCommands);
    }
}
