package Homework.Pr1;

public class HarmonicSeries {
    public static void main(String[] args) {
        System.out.println("Первые 10 чисел гармонического ряда:");
        for (int i = 1; i <= 10; i++) {
            double harmonicNumber = 1.0 / i;
            System.out.println(harmonicNumber);
        }
    }
}
