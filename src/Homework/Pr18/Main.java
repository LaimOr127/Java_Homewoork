package Homework.Pr18;

import java.io.Serializable;

class ThreeParams<T extends Comparable<T>, V extends Serializable, K> {
    private T t;
    private V v;
    private K k;

    public ThreeParams(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void printClassNames() {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("V: " + v.getClass().getName());
        System.out.println("K: " + k.getClass().getName());
    }
}

class MinMax<T extends Comparable<T>> {
    private T[] array;

    public MinMax(T[] array) {
        this.array = array;
    }

    public T findMin() {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        T min = array[0];
        for (T item : array) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }

    public T findMax() {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        T max = array[0];
        for (T item : array) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
}

class Calculator {
    public static <T extends Number, U extends Number> double sum(T a, U b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number, U extends Number> double multiply(T a, U b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number, U extends Number> double divide(T a, U b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <T extends Number, U extends Number> double subtract(T a, U b) {
        return a.doubleValue() - b.doubleValue();
    }
}

class Matrix<T> {
    private T[][] matrix;

    public Matrix(T[][] matrix) {
        this.matrix = matrix;
    }

    public T getElement(int row, int col) {
        return matrix[row][col];
    }

    public void setElement(int row, int col, T value) {
        matrix[row][col] = value;
    }

    // Другие методы для операций с матрицами
}

public class Main {
    public static void main(String[] args) {
        // Пример использования класса ThreeParams
        ThreeParams<Integer, Serializable, String> threeParams = new ThreeParams<>(5, 10, "Hello");
        threeParams.printClassNames();

        // Пример использования класса MinMax
        Integer[] intArray = {3, 7, 1, 9, 2};
        MinMax<Integer> minMax = new MinMax<>(intArray);
        System.out.println("Min: " + minMax.findMin());
        System.out.println("Max: " + minMax.findMax());

        // Пример использования класса Calculator
        System.out.println("Sum: " + Calculator.sum(5.5, 3));
        System.out.println("Multiply: " + Calculator.multiply(2, 4.5));
        System.out.println("Divide: " + Calculator.divide(10, 2));
        System.out.println("Subtract: " + Calculator.subtract(7, 3.5));

        // Пример использования класса Matrix
        Double[][] matrixData = {{1.0, 2.0}, {3.0, 4.0}};
        Matrix<Double> matrix = new Matrix<>(matrixData);
        System.out.println("Element at (1, 1): " + matrix.getElement(1, 1));
    }
}
