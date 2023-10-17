package Pr19;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Метод для конвертации массива строк/чисел в список.
        String[] stringArray = {"apple", "banana", "cherry", "date", "elderberry"};
        List<String> stringList = arrayToList(stringArray);
        System.out.println("List of strings: " + stringList);

        Integer[] intArray = {1, 2, 3, 4, 5};
        List<Integer> intList = arrayToList(intArray);
        System.out.println("List of integers: " + intList);

        // 2. Класс, который умеет хранить в себе массив любых типов данных.
        Solution<Integer, String, Double> solution = new Solution<>(intArray);

        // 3. Реализация метода, который возвращает любой элемент массива по индексу.
        int index = 2;
        Integer element = solution.getElementByIndex(index);
        System.out.println("Element at index " + index + ": " + element);

        // 4. Функция, которая сохраняет содержимое каталога в список и выведет первые 5 элементов на экран.
        List<String> directoryContents = new ArrayList<>();
        directoryContents.add("File1");
        directoryContents.add("File2");
        directoryContents.add("File3");
        directoryContents.add("File4");
        directoryContents.add("File5");
        directoryContents.add("File6");

        List<String> firstFiveItems = directoryContents.subList(0, Math.min(5, directoryContents.size()));
        System.out.println("First 5 items in directory: " + firstFiveItems);

        // 5. * Реализация вспомогательных методов в классе Solution.
        List<String> stringArrayList = Solution.newArrayList("A", "B", "C");
        System.out.println("Created ArrayList of strings: " + stringArrayList);

        Set<Integer> integerHashSet = Solution.newHashSet(1, 2, 3, 4, 5);
        System.out.println("Created HashSet of integers: " + integerHashSet);

        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        Map<String, Integer> stringIntegerHashMap = Solution.newHashMap(map);
        System.out.println("Created HashMap of string to integer: " + stringIntegerHashMap);
    }

    // Метод для конвертации массива любых типов в список
    public static <T> List<T> arrayToList(T[] array) {
        return Arrays.asList(array);
    }
}

class Solution<T, K, V> {
    private T[] dataArray;
    private Map<K, V> dataMap;

    public Solution(T[] dataArray) {
        this.dataArray = dataArray;
    }

    public T getElementByIndex(int index) {
        if (index >= 0 && index < dataArray.length) {
            return dataArray[index];
        }
        throw new IndexOutOfBoundsException("Index is out of bounds");
    }

    // Вспомогательный метод для создания ArrayList
    public static <T> List<T> newArrayList(T... elements) {
        return Arrays.asList(elements);
    }

    // Вспомогательный метод для создания HashSet
    public static <T> Set<T> newHashSet(T... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }

    // Вспомогательный метод для создания HashMap
    public static <K, V> Map<K, V> newHashMap(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }
}
