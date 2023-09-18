import java.util.*;

// Перечисление для мастей на русском
enum Масть {
    ПИКИ("Пики"),
    ТРЕФЫ("Трефы"),
    БУБНЫ("Бубны"),
    ЧЕРВИ("Черви");

    private final String название;

    Масть(String название) {
        this.название = название;
    }

    @Override
    public String toString() {
        return название;
    }
}

// Перечисление для карт на русском
enum Карта {
    ДВА("2"),
    ТРИ("3"),
    ЧЕТЫРЕ("4"),
    ПЯТЬ("5"),
    ШЕСТЬ("6"),
    СЕМЬ("7"),
    ВОСЕМЬ("8"),
    ДЕВЯТЬ("9"),
    ДЕСЯТЬ("10"),
    ВАЛЕТ("Валет"),
    ДАМА("Дама"),
    КОРОЛЬ("Король"),
    ТУЗ("Туз");

    private final String название;

    Карта(String название) {
        this.название = название;
    }

    @Override
    public String toString() {
        return название;
    }
}

// Класс, представляющий упражнение 1
class Exercise1 {
    private Stack<Карта> stack = new Stack<>();

    public void run(Scanner scanner) {
        System.out.println("Упражнение 1: Используйте для организации хранения структуры данных Stack.");

        while (true) {
            System.out.print("Введите карту для добавления или 'exit' для завершения: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("EXIT")) {
                System.out.println("Игра завершена.");
                break;
            }

            try {
                Карта card = Карта.valueOf(input);
                stack.push(card);
                System.out.println("Карта добавлена: " + card);
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректная карта. Попробуйте снова.");
                System.out.println("Примеры корректных карт: " + Arrays.toString(Карта.values()));
            }
        }
    }
}

// Класс, представляющий упражнение 2
class Exercise2 {
    private Queue<Карта> queue = new LinkedList<>();

    public void run(Scanner scanner) {
        System.out.println("Упражнение 2: Используйте для организации хранения структуры данных Queue.");

        while (true) {
            System.out.print("Введите карту для добавления или 'exit' для завершения: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("EXIT")) {
                System.out.println("Игра завершена.");
                break;
            }

            try {
                Карта card = Карта.valueOf(input);
                queue.add(card);
                System.out.println("Карта добавлена: " + card);
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректная карта. Попробуйте снова.");
                System.out.println("Примеры корректных карт: " + Arrays.toString(Карта.values()));
            }
        }
    }
}

// Класс, представляющий упражнение 3
class Exercise3 {
    private Deque<Карта> deque = new ArrayDeque<>();

    public void run(Scanner scanner) {
        System.out.println("Упражнение 3: Используйте для организации хранения структуры данных Dequeue.");

        while (true) {
            System.out.print("Введите карту для добавления (front/back) или 'exit' для завершения: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("EXIT")) {
                System.out.println("Игра завершена.");
                break;
            }

            try {
                Карта card = Карта.valueOf(input);
                System.out.print("Введите место для добавления (front/back): ");
                String position = scanner.nextLine().toLowerCase();

                if (position.equals("front")) {
                    deque.addFirst(card);
                } else if (position.equals("back")) {
                    deque.addLast(card);
                } else {
                    System.out.println("Некорректное место для добавления. Используйте 'front' или 'back'.");
                    continue;
                }

                System.out.println("Карта добавлена: " + card);
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректная карта. Попробуйте снова.");
                System.out.println("Примеры корректных карт: " + Arrays.toString(Карта.values()));
            }
        }
    }
}

// Класс, представляющий упражнение 4
class Exercise4 {
    private Stack<Карта> stack = new Stack<>();
    private int moves = 0;

    public void run(Scanner scanner) {
        System.out.println("Упражнение 4: Интерактивный интерфейс для взаимодействия с пользователем.");
        System.out.println("Введите команду: (push/pop/exit)");

        while (true) {
            String command = scanner.nextLine().toLowerCase();
            switch (command) {
                case "push":
                    System.out.print("Введите карту для добавления: ");
                    String cardInput = scanner.nextLine().toUpperCase();

                    try {
                        Карта card = Карта.valueOf(cardInput);
                        stack.push(card);
                        moves++;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Некорректная карта. Попробуйте снова.");
                        System.out.println("Примеры корректных карт: " + Arrays.toString(Карта.values()));
                    }
                    break;
                case "pop":
                    if (!stack.isEmpty()) {
                        System.out.println("Извлеченная карта: " + stack.pop());
                        moves++;
                    } else {
                        System.out.println("Стек пуст.");
                    }
                    break;
                case "exit":
                    System.out.println("Игра завершена.");
                    System.out.println("Количество ходов: " + moves);
                    return;
                default:
                    System.out.println("Некорректная команда. Используйте 'push', 'pop' или 'exit'.");
                    break;
            }
        }
    }
}

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardGameEngine gameEngine = new CardGameEngine();

        while (true) {
            System.out.println("Выберите упражнение (1-4) или 0 для выхода:");
            int exercise = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после считывания числа

            if (exercise == 0) {
                System.out.println("Игра завершена.");
                break;
            }

            switch (exercise) {
                case 1:
                    gameEngine.runExercise(new Exercise1(), scanner);
                    break;
                case 2:
                    gameEngine.runExercise(new Exercise2(), scanner);
                    break;
                case 3:
                    gameEngine.runExercise(new Exercise3(), scanner);
                    break;
                case 4:
                    gameEngine.runExercise(new Exercise4(), scanner);
                    break;
                default:
                    System.out.println("Некорректный выбор упражнения.");
                    break;
            }

            System.out.println("Хотите продолжить? (да/нет):");
            String choice = scanner.nextLine().toLowerCase();
            if (!choice.equals("да")) {
                break;
            }
        }
    }
}

class CardGameEngine {
    public void runExercise(Упражнения exercise, Scanner scanner) {
        exercise.run(scanner);
    }
}
