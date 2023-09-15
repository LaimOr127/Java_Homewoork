package Pr5;
import java.util.Scanner;

// Абстрактный класс Shape
abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
        this.color = "unknown";
        this.filled = false;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public abstract void display();
}

// Подкласс Circle
class Circle extends Shape {
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void display() {
        System.out.println("Фигура: Круг");
        System.out.println("Радиус: " + radius);
        System.out.println("Цвет: " + color);
        System.out.println("Закрашен: " + filled);
    }
}

// Подкласс Rectangle
class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
        this.width = 1.0;
        this.length = 1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public void display() {
        System.out.println("Фигура: Прямоугольник");
        System.out.println("Ширина: " + width);
        System.out.println("Длина: " + length);
        System.out.println("Цвет: " + color);
        System.out.println("Закрашен: " + filled);
    }
}

// Подкласс Square
class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void display() {
        System.out.println("Фигура: Квадрат");
        System.out.println("Сторона: " + getWidth()); // Мы используем getWidth() или getLength(), так как они равны
        System.out.println("Цвет: " + color);
        System.out.println("Закрашен: " + filled);
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать круг");
            System.out.println("2. Создать прямоугольник");
            System.out.println("3. Создать квадрат");
            System.out.println("4. Выйти");
            System.out.print("Введите номер действия: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Задание: Создание круга");
                    createCircle(scanner);
                    break;
                case 2:
                    System.out.println("Задание: Создание прямоугольника");
                    createRectangle(scanner);
                    break;
                case 3:
                    System.out.println("Задание: Создание квадрата");
                    createSquare(scanner);
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void createCircle(Scanner scanner) {
        System.out.print("Введите радиус круга: ");
        double radius = scanner.nextDouble();
        scanner.nextLine(); // Считываем перевод строки после числа

        System.out.print("Введите цвет круга (на русском): ");
        String color = scanner.nextLine();

        System.out.print("Закрашенный (true/false): ");
        boolean filled = scanner.nextBoolean();

        Shape circle = new Circle(radius, color, filled);
        printShapeInfo(circle);
    }

    private static void createRectangle(Scanner scanner) {
        System.out.print("Введите ширину прямоугольника: ");
        double width = scanner.nextDouble();
        scanner.nextLine(); // Считываем перевод строки после числа

        System.out.print("Введите длину прямоугольника: ");
        double length = scanner.nextDouble();
        scanner.nextLine(); // Считываем перевод строки после числа

        System.out.print("Введите цвет прямоугольника (на русском): ");
        String color = scanner.nextLine();

        System.out.print("Закрашенный (true/false): ");
        boolean filled = scanner.nextBoolean();

        Shape rectangle = new Rectangle(width, length, color, filled);
        printShapeInfo(rectangle);
    }

    private static void createSquare(Scanner scanner) {
        System.out.print("Введите длину стороны квадрата: ");
        double side = scanner.nextDouble();
        scanner.nextLine(); // Считываем перевод строки после числа

        System.out.print("Введите цвет квадрата (на русском): ");
        String color = scanner.nextLine();

        System.out.print("Закрашенный (true/false): ");
        boolean filled = scanner.nextBoolean();

        Shape square = new Square(side, color, filled);
        printShapeInfo(square);
    }

    private static void printShapeInfo(Shape shape) {
        System.out.println("Создана фигура:");
        shape.display();
        System.out.println("Площадь: " + shape.getArea());
        System.out.println("Периметр: " + shape.getPerimeter());
        System.out.println();
    }
}
