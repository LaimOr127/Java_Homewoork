package Pr17;

import java.util.*;

// Класс для представления студента
class Student {
    private String fullName;
    private String inn;
    private double averageScore;

    public Student(String fullName, String inn, double averageScore) {
        this.fullName = fullName;
        this.inn = inn;
        this.averageScore = averageScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    public double getAverageScore() {
        return averageScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", averageScore=" + averageScore +
                '}';
    }
}

// Исключение для отсутствия студента
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Добавление студентов
        students.add(new Student("Иванов Иван Иванович", "1234567890", 4.5));
        students.add(new Student("Петров Петр Петрович", "9876543210", 3.8));
        students.add(new Student("Сидоров Сидор Сидорович", "1357924680", 4.2));

        // Сортировка студентов по среднему баллу
        Collections.sort(students, Comparator.comparingDouble(Student::getAverageScore).reversed());

        // Ввод ФИО для поиска студента
        System.out.println("Введите ФИО студента для поиска:");
        String searchFullName = scanner.nextLine();

        // Поиск студента по ФИО
        try {
            Student foundStudent = findStudentByFullName(students, searchFullName);
            System.out.println("Найден студент: " + foundStudent);
        } catch (StudentNotFoundException e) {
            System.out.println("Студент с таким ФИО не найден.");
        }

        // Ввод ИНН для проверки
        System.out.println("Введите ИНН для проверки:");
        String innToCheck = scanner.nextLine();

        // Проверка ИНН
        if (isValidInn(innToCheck)) {
            System.out.println("ИНН действителен.");
        } else {
            System.out.println("ИНН недействителен.");
        }
    }

    // Поиск студента по ФИО
    private static Student findStudentByFullName(List<Student> students, String fullName) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Студент с ФИО '" + fullName + "' не найден.");
    }

    // Проверка ИНН (простой пример, не учитывающий действительный алгоритм ИНН)
    private static boolean isValidInn(String inn) {
        // Проверка на корректную длину ИНН (пример)
        return inn.length() == 10;
    }
}
