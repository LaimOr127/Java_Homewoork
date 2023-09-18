package Homework.Pr3;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("(Введи 1 для)По диаграмме класса UML описывающей сущность Автор. Необходимо\n" +
                    "написать программу, которая состоит из двух классов Author и TestAuthor.\n" +
                    "Класс Author должен содержать реализацию методов, представленных на\n" +
                    "диаграмме класса на рисунке 2.4. \n, (Введи 2 для)По UML диаграмме класса, представленной на рисунке 2.5. написать\n" +
                    "программу, которая состоит из двух классов. Один из них Ball должен\n" +
                    "реализовывать сущность мяч, а другой с названием TestBall тестировать\n" +
                    "работу созданного класса. Класс Ball должен содержать реализацию методов,\n" +
                    "представленных на UML. Диаграмма на рисунке описывает сущность Мяч\n" +
                    "написать программу. :");


            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Ball bl = new Ball(100, 100);
                    System.out.println(bl);
                    bl.move(30, 15);
                    System.out.println(bl);
                    break;
                case 2:
                    Author author1 = new Author("Cristiano Ronaldo", "barcelonaGovno@nalchik.com", 'M');
                    System.out.println(author1);

                    Author author2 = new Author("Motivaciya Podnimatel", "motivaciiNet@nalchik.com", 'M');
                    System.out.println(author2);

                    author2.setEmail("motivaciyunadopodnyat@nalchik.com");
                    System.out.println(author2.getEmail());
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

class Ball {
    private double x = 0.0;
    private double y = 0.0;

    public Ball(){}
    public Ball(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public void setX(double x){
        this.x = x;
    }
    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void move(double xDisp, double yDisp){
        x+=xDisp;
        y+=yDisp;
    }
    @Override
    public String toString(){
        return "Ball () ("+this.x+", "+this.y+").";
    }
}

class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public char getGender(){
        return gender;
    }
    @Override
    public String toString(){
        return "Author @ ("+this.name+", "+this.email+", "+this.gender+").";
    }
}