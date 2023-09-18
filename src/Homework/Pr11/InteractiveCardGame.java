import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class InteractiveCardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите структуру данных для организации хранения:");
        System.out.println("1. Stack");
        System.out.println("2. Queue");
        System.out.println("3. Deque");
        System.out.println("4. DoubleList");
        System.out.print("Ваш выбор: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера после ввода числа

        Deque<Integer> firstPlayerDeck = null;
        Deque<Integer> secondPlayerDeck = null;

        switch (choice) {
            case 1:
                firstPlayerDeck = new LinkedList<>();
                secondPlayerDeck = new LinkedList<>();
                break;
            case 2:
                firstPlayerDeck = new LinkedList<>();
                secondPlayerDeck = new LinkedList<>();
                break;
            case 3:
                firstPlayerDeck = new LinkedList<>();
                secondPlayerDeck = new LinkedList<>();
                break;
            case 4:
                firstPlayerDeck = new LinkedList<>();
                secondPlayerDeck = new LinkedList<>();
                break;
            default:
                System.out.println("Некорректный выбор.");
                return;
        }

        int moves = 0;
        while (moves <= 106) {
            System.out.print("Введите карту первого игрока (от 0 до 9): ");
            int firstPlayerCard = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Введите карту второго игрока (от 0 до 9): ");
            int secondPlayerCard = scanner.nextInt();
            scanner.nextLine();

            firstPlayerDeck.addLast(firstPlayerCard);
            secondPlayerDeck.addLast(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.addLast(secondPlayerDeck.pollFirst());
                firstPlayerDeck.addLast(firstPlayerDeck.pollFirst());
            } else {
                secondPlayerDeck.addLast(firstPlayerDeck.pollFirst());
                secondPlayerDeck.addLast(secondPlayerDeck.pollFirst());
            }

            moves++;

            // Проверяем, если один из игроков исчерпал свои карты
            if (firstPlayerDeck.isEmpty()) {
                System.out.println("Выйграл второй игрок! Количество ходов: " + moves);
                return;
            } else if (secondPlayerDeck.isEmpty()) {
                System.out.println("Выйграл первый игрок! Количество ходов: " + moves);
                return;
            }
        }

        // Если игра не закончилась после 106 ходов
        System.out.println("Ботва! Игра завершена после 106 ходов.");
    }
}
