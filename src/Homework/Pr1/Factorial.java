package Homework.Pr1;

public class Factorial {
    public static void main(String[] args) {
        int n = 5; // Здесь указываем число, для которого нужно вычислить факториал
        long result = calculateFactorial(n);
        System.out.println(n + "! = " + result);
    }

    // Метод для вычисления факториала числа n
    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал определен только для неотрицательных чисел.");
        }

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
