package Homework.Pr10;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем массив студентов
        Student[] studentsArray = {
                new Student(1, "Алиса", 3.7),
                new Student(2, "Саня", 3.9),
                new Student(3, "Петя", 3.5),
                new Student(4, "Вова", 4.0)
        };

        // Сортируем массив студентов по iDNumber с использованием сортировки вставками
        insertionSort(studentsArray);

        // Выводим отсортированный массив по iDNumber
        System.out.println("Отсортированный массив по iDNumber:");
        for (Student student : studentsArray) {
            System.out.println("ID: " + student.getIDNumber() + ", Имя: " + student.getName() + ", Успеваемость: " + student.getGPA());
        }

        // Создаем два списка студентов
        List<Student> list1 = new ArrayList<>(Arrays.asList(
                new Student(5, "Ярик", 3.8),
                new Student(6, "Вася", 3.6)
        ));

        List<Student> list2 = new ArrayList<>(Arrays.asList(
                new Student(7, "Гоша", 3.4),
                new Student(8, "Леша", 3.7)
        ));

        // Объединяем два списка студентов и сортируем их слиянием
        List<Student> mergedList = mergeSort(list1, list2, new SortingStudentsByGPA());

        // Выводим отсортированный объединенный список
        System.out.println("\nОтсортированный объединенный список по убыванию успеваемость:");
        for (Student student : mergedList) {
            System.out.println("ID: " + student.getIDNumber() + ", Имя: " + student.getName() + ", Успеваемость: " + student.getGPA());
        }
    }

    // Сортировка вставками
    public static void insertionSort(Student[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Student key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getIDNumber() > key.getIDNumber()) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Сортировка слиянием для списков
    public static List<Student> mergeSort(List<Student> list1, List<Student> list2, Comparator<Student> comparator) {
        List<Student> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (comparator.compare(list1.get(i), list2.get(j)) >= 0) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }
}

