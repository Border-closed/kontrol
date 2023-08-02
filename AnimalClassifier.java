public class AnimalClassifier {
    public static String classifyAnimal(Animal animal) {
        String species = animal.getSpecies().toLowerCase();
        if (species.contains("птиц"))
            return "Птицы";
        else if (species.contains("млекопит"))
            return "Млекопитающие";
        else
            return "Неопределенный класс";
    }
}
