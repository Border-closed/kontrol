// Создать программу, в которой можно:
// 1. Создать животное
// 2. Определить животное в правильный класс
// 3. Увидеть список команд, которые выполняет животное
// 4. Обучить животное новым командам
// 5. Навигация по меню
// 6. Создать класс счетчик с методом add(), увеличивающий счетчик на 1 при нажатии 
// "Завести новое животное". Сделайте так, чтобы с объектом такого типа можно было работать в
// блоке try-with-resources. Нужно бросить исключение, если работа с объектом
// типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
// считать в ресурсе try, если при заведения животного заполнены все поля.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AnimalClassifier classifier = new AnimalClassifier();
        AnimalTrainer trainer = new AnimalTrainer();

        initAnimals(classifier);
        showMenu(classifier, trainer);
    }

    private static void initAnimals(AnimalClassifier classifier) {
        List<String> catCommands = new ArrayList<>();
        catCommands.add("Мяукать");
        catCommands.add("Ловить мышей");
        Animal cat = new Animal("Кот", catCommands, AnimalType.DOMESTIC);
        classifier.addAnimal(cat);

        List<String> horseCommands = new ArrayList<>();
        horseCommands.add("Игнать");
        horseCommands.add("Тянуть плуг");
        Animal horse = new Animal("Лошадь", horseCommands, AnimalType.DRAFT);
        classifier.addAnimal(horse);
    }

    private static void showMenu(AnimalClassifier classifier, AnimalTrainer trainer) {
        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Создать животное");
            System.out.println("2. Просмотреть список животных");
            System.out.println("3. Просмотреть команды животного");
            System.out.println("4. Обучить животное новым командам");
            System.out.println("5. Вывести количество животных");
            System.out.println("0. Выход");
            System.out.print("Введите номер пункта меню: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Animal newAnimal = createAnimal();
                        classifier.addAnimal(newAnimal);
                        break;
                    case 2:
                        displayAnimals(classifier);
                        break;
                    case 3:
                        displayCommands(classifier);
                        break;
                    case 4:
                        teachAnimal(classifier, trainer);
                        break;
                    case 5:
                        System.out.println("Количество животных: " + classifier.getAnimalCount());
                        break;
                    case 0:
                        System.out.println("Выход...");
                        return;
                    default:
                        System.out.println("Неверный ввод. Попробуйте снова.");
                }
            } else {
                String invalidInput = scanner.next();
                System.out.println("Неверный ввод: " + invalidInput);
                System.out.println("Пожалуйста, введите номер пункта меню (целое число).");
            }
        }
    }

    private static Animal createAnimal() {
        scanner.nextLine();
        System.out.print("Введите название животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите тип животного (DOMESTIC или DRAFT): ");
        String typeStr = scanner.nextLine();
        AnimalType type = AnimalType.valueOf(typeStr.toUpperCase());
        System.out.print("Введите команды через запятую: ");
        String commandsInput = scanner.nextLine();
        String[] commandsArray = commandsInput.split(",");
        List<String> commands = new ArrayList<>();
        for (String command : commandsArray) {
            commands.add(command.trim());
        }
        return new Animal(name, commands, type);
    }

    private static void displayAnimals(AnimalClassifier classifier) {
        List<Animal> animals = classifier.getAnimals();
        if (animals.isEmpty()) {
            System.out.println("Список животных пуст.");
        } else {
            System.out.println("Список животных:");
            for (int i = 0; i < animals.size(); i++) {
                Animal animal = animals.get(i);
                System.out.println((i + 1) + ". " + animal.getName() + " - " + animal.getType());
            }
        }
    }

    private static void displayCommands(AnimalClassifier classifier) {
        List<Animal> animals = classifier.getAnimals();
        if (animals.isEmpty()) {
            System.out.println("Список животных пуст.");
            return;
        }
        System.out.print("Введите номер животного: ");
        int animalIndex = scanner.nextInt();
        if (animalIndex < 1 || animalIndex > animals.size()) {
            System.out.println("Неверный номер животного.");
            return;
        }
        Animal selectedAnimal = animals.get(animalIndex - 1);
        System.out.println("Команды животного " + selectedAnimal.getName() + ":");
        for (String command : selectedAnimal.getCommands()) {
            System.out.println("- " + command);
        }
    }

    private static void teachAnimal(AnimalClassifier classifier, AnimalTrainer trainer) {
        List<Animal> animals = classifier.getAnimals();
        if (animals.isEmpty()) {
            System.out.println("Список животных пуст.");
            return;
        }
        System.out.print("Введите номер животного: ");
        int animalIndex = scanner.nextInt();
        if (animalIndex < 1 || animalIndex > animals.size()) {
            System.out.println("Неверный номер животного.");
            return;
        }
        scanner.nextLine();
        Animal selectedAnimal = animals.get(animalIndex - 1);
        System.out.print("Введите новые команды через запятую: ");
        String commandsInput = scanner.nextLine();
        String[] commandsArray = commandsInput.split(",");
        List<String> newCommands = new ArrayList<>();
        for (String command : commandsArray) {
            newCommands.add(command.trim());
        }
        trainer.teachAnimal(selectedAnimal, newCommands);
        System.out.println("Животное " + selectedAnimal.getName() + " обучено новым командам.");
    }
}
