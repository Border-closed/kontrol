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


import java.util.Scanner;

public class AnimalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите вид животного: ");
        String species = scanner.nextLine();

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        Animal animal = new Animal(species, name);

        int choice;
        do {
            System.out.println("\nМеню:");
            System.out.println("1. Вывести класс животного");
            System.out.println("2. Вывести список команд");
            System.out.println("3. Обучить новой команде");
            System.out.println("0. Выйти");

            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Считываем перевод строки после ввода числа

            switch (choice) {
                case 1:
                    String animalClass = AnimalClassifier.classifyAnimal(animal);
                    System.out.println("Животное " + animal.getName() + " относится к классу: " + animalClass);
                    break;
                case 2:
                    AnimalCommands.displayCommands(animal);
                    break;
                case 3:
                    System.out.print("Введите новую команду для обучения: ");
                    String newCommand = scanner.nextLine();
                    AnimalTrainer.teachAnimal(animal, newCommand);
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        } while (choice != 0);

        scanner.close();
    }
}

