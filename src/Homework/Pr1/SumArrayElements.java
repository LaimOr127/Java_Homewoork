package Homework.Pr1;

public class SumArrayElements {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;

        // Используем цикл for
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Сумма (for): " + sum);

        // Используем цикл while
        sum = 0;
        int index = 0;
        while (index < array.length) {
            sum += array[index];
            index++;
        }
        System.out.println("Сумма (while): " + sum);

        // Используем цикл do-while
        sum = 0;
        index = 0;
        do {
            sum += array[index];
            index++;
        } while (index < array.length);
        System.out.println("Сумма (do-while): " + sum);
    }
}
