package Pr23;


import java.util.*;

// Задание 2: Интерфейс Item
interface Item {
    double getCost();
    String getName();
    String getDescription();
}

// Задание 1: Класс Drink
final class Drink implements Item {
    private final double cost;
    private final String name;
    private final String description;

    public static final double DEFAULT_COST = 0.0;

    public Drink(String name, String description) {
        this(DEFAULT_COST, name, description);
    }

    public Drink(double cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

// Задание 3: Класс Dish
final class Dish implements Item {
    private final double cost;
    private final String name;
    private final String description;

    public static final double DEFAULT_COST = 0.0;

    public Dish(String name, String description) {
        this(DEFAULT_COST, name, description);
    }

    public Dish(double cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

// Задание 4: Класс Order
class Order {
    private final List<Item> items;

    public Order() {
        items = new ArrayList<>();
    }

    public boolean addItem(Item item) {
        return items.add(item);
    }

    public boolean removeItem(String name) {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public int removeAll(String name) {
        int count = 0;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    public int getTotalCount() {
        return items.size();
    }

    public Item[] getItems() {
        return items.toArray(new Item[0]);
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.getCost();
        }
        return totalCost;
    }

    public int getItemCount(String name) {
        int count = 0;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                count++;
            }
        }
        return count;
    }

    public String[] getItemNames() {
        Set<String> uniqueNames = new HashSet<>();
        for (Item item : items) {
            uniqueNames.add(item.getName());
        }
        return uniqueNames.toArray(new String[0]);
    }

    public Item[] getSortedItemsByCost() {
        Item[] sortedItems = items.toArray(new Item[0]);
        Arrays.sort(sortedItems, Comparator.comparingDouble(Item::getCost).reversed());
        return sortedItems;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить напиток");
            System.out.println("2. Добавить блюдо");
            System.out.println("3. Удалить позицию");
            System.out.println("4. Посчитать общую стоимость");
            System.out.println("5. Вывести все позиции");
            System.out.println("6. Вывести уникальные наименования");
            System.out.println("7. Вывести отсортированные по стоимости");
            System.out.println("8. Выйти");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после считывания числа

            switch (choice) {
                case 1:
                    System.out.print("Введите название напитка: ");
                    String drinkName = scanner.nextLine();
                    System.out.print("Введите описание напитка: ");
                    String drinkDescription = scanner.nextLine();
                    System.out.print("Введите стоимость напитка: ");
                    double drinkCost = scanner.nextDouble();
                    scanner.nextLine(); // Очистка буфера после считывания числа
                    Drink drink = new Drink(drinkCost, drinkName, drinkDescription);
                    order.addItem(drink);
                    System.out.println("Напиток добавлен в заказ.");
                    break;
                case 2:
                    System.out.print("Введите название блюда: ");
                    String dishName = scanner.nextLine();
                    System.out.print("Введите описание блюда: ");
                    String dishDescription = scanner.nextLine();
                    System.out.print("Введите стоимость блюда: ");
                    double dishCost = scanner.nextDouble();
                    scanner.nextLine(); // Очистка буфера после считывания числа
                    Dish dish = new Dish(dishCost, dishName, dishDescription);
                    order.addItem(dish);
                    System.out.println("Блюдо добавлено в заказ.");
                    break;
                case 3:
                    System.out.print("Введите название позиции для удаления: ");
                    String itemToRemove = scanner.nextLine();
                    if (order.removeItem(itemToRemove)) {
                        System.out.println("Позиция удалена из заказа.");
                    } else {
                        System.out.println("Позиция не найдена в заказе.");
                    }
                    break;
                case 4:
                    System.out.println("Общая стоимость заказа: $" + order.getTotalCost());
                    break;
                case 5:
                    Item[] items = order.getItems();
                    if (items.length == 0) {
                        System.out.println("Заказ пуст.");
                    } else {
                        System.out.println("Позиции в заказе:");
                        for (Item item : items) {
                            System.out.println(item.getName() + " - " + item.getDescription() + " - $" + item.getCost());
                        }
                    }
                    break;
                case 6:
                    String[] uniqueNames = order.getItemNames();
                    if (uniqueNames.length == 0) {
                        System.out.println("Заказ пуст.");
                    } else {
                        System.out.println("Уникальные наименования в заказе:");
                        for (String name : uniqueNames) {
                            System.out.println(name);
                        }
                    }
                    break;
                case 7:
                    Item[] sortedItems = order.getSortedItemsByCost();
                    if (sortedItems.length == 0) {
                        System.out.println("Заказ пуст.");
                    } else {
                        System.out.println("Позиции в заказе, отсортированные по стоимости (по убыванию):");
                        for (Item item : sortedItems) {
                            System.out.println(item.getName() + " - " + item.getDescription() + " - $" + item.getCost());
                        }
                    }
                    break;
                case 8:
                    System.out.println("Выход из программы.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }
}