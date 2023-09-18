package Homework.Pr2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose a program to run:");
        System.out.println("1. Написать программу, в результате которой массив чисел\n" +
                "создается с помощью инициализации (как в Си) вводится и считается в\n" +
                "цикле сумма элементов целочисленного массива, а также среднее\n" +
                "арифметическое его элементов результат выводится на экран. Использовать\n" +
                "цикл for");
        System.out.println("2. Написать программу, в результате которой массив чисел вводится\n" +
                "пользователем с клавиатуры считается сумма элементов целочисленного\n" +
                "массива с помощью циклов do while, while, также необходимо найти\n" +
                "максимальный и минимальный элемент в массиве, результат выводится на\n" +
                "экран.");
        System.out.println("3. Написать программу, в результате которой выводятся на экран\n" +
                "аргументы командной строки в цикле for.");
        System.out.println("4. Написать программу, в результате работы которой выводятся на\n" +
                "экран первые 10 чисел гармонического ряда (форматировать вывод).");
        System.out.println("5. Написать программу, которая с помощью метода класса,\n" +
                "вычисляет факториал числа (использовать управляющую конструкцию\n" +
                "цикла), проверить работу метода.");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                calculateSumAndAverage();
                break;
            case 2:
                calculateSumMaxMin();
                break;
            case 3:
                printCommandLineArguments(args);
                break;
            case 4:
                printHarmonicSeries();
                break;
            case 5:
                calculateFactorial();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    // Вычисление суммы и среднего арифметического элементов целочисленного массива, созданного с помощью инициализации и цикла for.
    public static void calculateSumAndAverage() {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        double average = (double) sum / numbers.length;
        System.out.println("Сумма: " + sum);
        System.out.println("Сред. ариф: " + average);
    }
    // Вычисление суммы, максимального и минимального элементов целочисленного массива, введенного пользователем с помощью циклов do-while и while
    public static void calculateSumMaxMin() {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int i = 0;
        do {
            System.out.print("Введите номер: ");
            numbers[i] = input.nextInt();
            sum += numbers[i];
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
            i++;
        } while (i < numbers.length);
        i = 0;
        while (i < numbers.length) {
            i++;
        }
        System.out.println("Сумма: " + sum);
        System.out.println("Максимум: " + max);
        System.out.println("Минимум: " + min);
    }
    // Вывод аргументов командной строки в цикле for.
    public static void printCommandLineArguments(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
    // Вывод первых 10 чисел гармонического ряда.
    public static void printHarmonicSeries() {
        double sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += 1.0 / i;
        }
        System.out.printf("Сумма первых 10 чисел гармонического ряда: %.2f", sum);
    }
    // Вычисление факториала числа с помощью цикла.
    public static void calculateFactorial() {
        int n = 5;
        int fact = factorial(n);
        System.out.printf("Факториал числа %d равен %d", n, fact);
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
