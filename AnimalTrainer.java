public class AnimalTrainer {
    public static void teachAnimal(Animal animal, String newCommand) {
        animal.addCommand(newCommand);
        System.out.println("Животное " + animal.getName() + " выучило новую команду: " + newCommand);
    }
}
