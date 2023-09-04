package Homework;

package ru.mirea.lab1;

//Написать программу, в результате которой массив чисел
//создается с помощью инициализации (как в Си) вводится и считается в
//цикле сумма элементов целочисленного массива, а также среднее
//арифметическое его элементов результат выводится на экран. Использовать
//цикл for.

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        double average = (double) sum / numbers.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}

//  Написать программу, в результате которой массив чисел вводится
//  пользователем с клавиатуры считается сумма элементов целочисленного
//  массива с помощью циклов do while, while, также необходимо найти
//  максимальный и минимальный элемент в массиве, результат выводится на
//  экран.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int i = 0;
        do {
            System.out.print("Enter a number: ");
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
        System.out.println("Sum: " + sum);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}

//Написать программу, в результате которой выводятся на экран
//аргументы командной строки в цикле for.

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}

//Написать программу, в результате работы которой выводятся на
//экран первые 10 чисел гармонического ряда (форматировать вывод).

public class Main {
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += 1.0 / i;
        }
        System.out.printf("The sum of the first 10 numbers of the harmonic series is %.2f", sum);
    }
}

//Написать программу, которая с помощью метода класса,
//вычисляет факториал числа (использовать управляющую конструкцию
//цикла), проверить работу метода.

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int fact = factorial(n);
        System.out.printf("The factorial of %d is %d", n, fact);
    }
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}