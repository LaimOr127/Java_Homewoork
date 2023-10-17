package Pr16;

import java.util.Scanner;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Задание № 1");
                    task1();
                    break;
                case 2:
                    System.out.println("Задание № 2");
                    task2();
                    break;
                case 3:
                    System.out.println("Задание № 3");
                    task3();
                    break;
                case 4:
                    System.out.println("Задание № 4");
                    task4();
                    break;
                case 5:
                    System.out.println("Задание № 5");
                    task5();
                    break;
                case 6:
                    System.out.println("Задание № 6");
                    task6();
                    break;
                case 7:
                    System.out.println("Задание № 7");
                    task7();
                    break;
                case 8:
                    System.out.println("Задание № 8");
                    task8();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }

        System.out.println("Программа завершена.");
    }

    private static void task1() {
        System.out.println("Задание № 1");
        try {
            System.out.println(2.0 / 0.0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    private static void task2() {
        System.out.println("Задание № 2");
        Scanner myScanner2 = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        try {
            String intString = myScanner2.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer.");
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    private static void task3() {
        System.out.println("Задание № 3");
        Scanner myScanner3 = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        try {
            String intString = myScanner3.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer.");
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
        }
    }

    private static void task4() {
        System.out.println("Задание № 4");
        Scanner myScanner4 = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        try {
            String intString = myScanner4.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer.");
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        } finally {
            System.out.println("This block always executes.");
        }
    }

    private static void task5() {
        System.out.println("Задание № 5");
        try {
            throw new NullPointerException("null key in getDetails");
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }

    private static void task6() {
        System.out.println("Задание № 6");
        try {
            throw new Exception("Key set to an empty string");
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    private static void task7() {
        System.out.println("Задание № 7");
        Scanner myScanner7 = new Scanner(System.in);
        System.out.print("Enter a key: ");
        String key7 = myScanner7.next();
        try {
            String message = getDetails(key7);
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    private static void task8() {
        System.out.println("Задание № 8");
        Scanner myScanner8 = new Scanner(System.in);
        System.out.print("Enter a key: ");
        String key8 = myScanner8.next();
        try {
            String message = getDetails(key8);
            System.out.println(message);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }

    private static String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        if (key.isEmpty()) {
            throw new IllegalArgumentException("Key set to an empty string");
        }
        return "data for " + key;
    }
}
