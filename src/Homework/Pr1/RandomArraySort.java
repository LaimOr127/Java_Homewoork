package Homework.Pr1;

import java.util.Arrays;
import java.util.Random;

public class RandomArraySort {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        // Заполняем массив случайными числами
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // Генерация случайных чисел до 100
        }

        System.out.println("Исходный массив: " + Arrays.toString(array));

        // Сортируем массив
        Arrays.sort(array);

        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}
