package Pr24;


import java.util.*;

// Задание 1: Интерфейс Item
interface Item {
    double getCost();
    String getName();
    String getDescription();
}

// Задание 1: Класс Drink
class Drink implements Item {
    private final double cost;
    private final String name;
    private final String description;

    public Drink(String name, String description) {
        this.cost = 0;
        this.name = name;
        this.description = description;
    }

    public Drink(double cost, String name, String description) {
        if (cost < 0 || name.isEmpty() || description.isEmpty()) {
            throw new IllegalArgumentException("Invalid Drink parameters");
        }
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

// Задание 1: Класс Dish
class Dish implements Item {
    private final double cost;
    private final String name;
    private final String description;

    public Dish(String name, String description) {
        this.cost = 0;
        this.name = name;
        this.description = description;
    }

    public Dish(double cost, String name, String description) {
        if (cost < 0 || name.isEmpty() || description.isEmpty()) {
            throw new IllegalArgumentException("Invalid Dish parameters");
        }
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

// Задание 1: Интерфейс Order
interface Order {
    boolean addItem(Item item);
    boolean removeItem(String name);
    int removeAll(String name);
    int getTotalCount();
    Item[] getItems();
    double getTotalCost();
    int getItemCount(String name);
    String[] getItemNames();
    Item[] getSortedItemsByCost();
}

// Задание 3: Исключение OrderAlreadyAddedException
class OrderAlreadyAddedException extends RuntimeException {
    public OrderAlreadyAddedException(String message) {
        super(message);
    }
}

// Задание 3: Исключение IllegalTableNumber
class IllegalTableNumber extends IllegalArgumentException {
    public IllegalTableNumber(String message) {
        super(message);
    }
}

// Задание 1: Реализация интерфейса Order - RestaurantOrder
class RestaurantOrder implements Order {
    private final List<Item> items;

    public RestaurantOrder() {
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
        Arrays.sort(sortedItems, (item1, item2) -> Double.compare(item2.getCost(), item1.getCost()));
        return sortedItems;
    }
}

// Задание 1: Реализация интерфейса Order - InternetOrder
class InternetOrder implements Order {
    private final List<Item> items;

    public InternetOrder() {
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
        Arrays.sort(sortedItems, (item1, item2) -> Double.compare(item2.getCost(), item1.getCost()));
        return sortedItems;
    }
}

// Задание 2: Интерфейс Item
interface Itemm {
    double getCost();
    String getName();
    String getDescription();
}

// Задание 2: Интерфейс Order
interface Orders {
    boolean addItem(Item item);
    boolean removeItem(String name);
    int removeAll(String name);
    int getTotalCount();
    Item[] getItems();
    double getTotalCost();
    int getItemCount(String name);
    String[] getItemNames();
    Item[] getSortedItemsByCost();
}

// Задание 2: Класс OrderManager
class OrderManager {
    private final Map<String, Order> orders;

    public OrderManager() {
        orders = new HashMap<>();
    }

    public void addOrder(String address, Order order) {
        if (orders.containsKey(address)) {
            throw new OrderAlreadyAddedException("Order already added for address: " + address);
        }
        orders.put(address, order);
    }

    public Order getOrder(String address) {
        if (!orders.containsKey(address)) {
            throw new IllegalArgumentException("No order found for address: " + address);
        }
        return orders.get(address);
    }

    public void removeOrder(String address) {
        if (!orders.containsKey(address)) {
            throw new IllegalArgumentException("No order found for address: " + address);
        }
        orders.remove(address);
    }

    public void addItemToOrder(String address, Item item) {
        if (!orders.containsKey(address)) {
            throw new IllegalArgumentException("No order found for address: " + address);
        }
        orders.get(address).addItem(item);
    }

    public String[] getAddresses() {
        return orders.keySet().toArray(new String[0]);
    }

    public double getTotalOrdersCost() {
        double totalCost = 0;
        for (Order order : orders.values()) {
            totalCost += order.getTotalCost();
        }
        return totalCost;
    }

    public int getTotalItemCount(String itemName) {
        int count = 0;
        for (Order order : orders.values()) {
            count += order.getItemCount(itemName);
        }
        return count;
    }

    public Order[] getOrders() {
        return orders.values().toArray(new Order[0]);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Создать заказ по адресу");
            System.out.println("2. Добавить позицию к заказу");
            System.out.println("3. Удалить заказ по адресу");
            System.out.println("4. Вывести все адреса заказов");
            System.out.println("5. Вывести общую стоимость всех заказов");
            System.out.println("6. Вывести общее количество заказанных позиций по названию");
            System.out.println("7. Вывести все заказы по адресу");
            System.out.println("8. Вывести интернет-заказы");
            System.out.println("9. Вывести общее количество интернет-заказов");
            System.out.println("10. Выйти");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после считывания числа

            switch (choice) {
                case 1:
                    System.out.print("Введите адрес для создания заказа: ");
                    String address = scanner.nextLine();
                    Order newOrder = new RestaurantOrder();
                    orderManager.addOrder(address, newOrder);
                    System.out.println("Заказ создан по адресу: " + address);
                    break;
                case 2:
                    System.out.print("Введите адрес заказа для добавления позиции: ");
                    String orderAddress = scanner.nextLine();
                    if (Arrays.asList(orderManager.getAddresses()).contains(orderAddress)) {
                        System.out.print("Введите тип позиции (Dish/Drink): ");
                        String itemType = scanner.nextLine();
                        System.out.print("Введите название позиции: ");
                        String itemName = scanner.nextLine();
                        System.out.print("Введите описание позиции: ");
                        String itemDescription = scanner.nextLine();
                        System.out.print("Введите стоимость позиции: ");
                        double itemCost = scanner.nextDouble();
                        scanner.nextLine(); // Очистка буфера после считывания числа

                        Item item;
                        if ("Dish".equalsIgnoreCase(itemType)) {
                            item = new Dish(itemCost, itemName, itemDescription);
                        } else if ("Drink".equalsIgnoreCase(itemType)) {
                            item = new Drink(itemCost, itemName, itemDescription);
                        } else {
                            System.out.println("Неверный тип позиции. Допустимые значения: Dish, Drink.");
                            continue;
                        }

                        orderManager.addItemToOrder(orderAddress, item);
                        System.out.println("Позиция добавлена к заказу по адресу: " + orderAddress);
                    } else {
                        System.out.println("Заказ с таким адресом не существует.");
                    }
                    break;
                case 3:
                    System.out.print("Введите адрес заказа для удаления: ");
                    String orderToRemove = scanner.nextLine();
                    if (Arrays.asList(orderManager.getAddresses()).contains(orderToRemove)) {
                        orderManager.removeOrder(orderToRemove);
                        System.out.println("Заказ по адресу " + orderToRemove + " удален.");
                    } else {
                        System.out.println("Заказ с таким адресом не существует.");
                    }
                    break;
                case 4:
                    String[] addresses = orderManager.getAddresses();
                    if (addresses.length == 0) {
                        System.out.println("Нет активных заказов.");
                    } else {
                        System.out.println("Адреса заказов:");
                        for (String addr : addresses) {
                            System.out.println(addr);
                        }
                    }
                    break;
                case 5:
                    double totalCost = orderManager.getTotalOrdersCost();
                    System.out.println("Общая стоимость всех заказов: $" + totalCost);
                    break;
                case 6:
                    System.out.print("Введите название позиции: ");
                    String itemToCount = scanner.nextLine();
                    int itemCount = orderManager.getTotalItemCount(itemToCount);
                    System.out.println("Общее количество заказанных позиций " + itemToCount + ": " + itemCount);
                    break;
                case 7:
                    System.out.print("Введите адрес заказа для вывода: ");
                    String orderToPrint = scanner.nextLine();
                    if (Arrays.asList(orderManager.getAddresses()).contains(orderToPrint)) {
                        Order selectedOrder = orderManager.getOrder(orderToPrint);
                        Item[] itemsInOrder = selectedOrder.getItems();
                        if (itemsInOrder.length == 0) {
                            System.out.println("Заказ пуст.");
                        } else {
                            System.out.println("Заказ по адресу " + orderToPrint + ":");
                            for (Item item : itemsInOrder) {
                                System.out.println("Название: " + item.getName() + ", Стоимость: $" + item.getCost());
                            }
                        }
                    } else {
                        System.out.println("Заказ с таким адресом не существует.");
                    }
                    break;
                case 8:
                    System.out.println("Интернет-заказы:");
                    for (Order order : orderManager.getOrders()) {
                        if (order instanceof InternetOrder) {
                            Item[] internetItems = order.getItems();
                            if (internetItems.length > 0) {
                                System.out.println("Адрес: " + orderManager.getAddresses()[Arrays.asList(orderManager.getAddresses()).indexOf(order)]);
                                for (Item item : internetItems) {
                                    System.out.println("Название: " + item.getName() + ", Стоимость: $" + item.getCost());
                                }
                            } else {
                                System.out.println("Заказ по адресу " + orderManager.getAddresses()[Arrays.asList(orderManager.getAddresses()).indexOf(order)] + " пуст.");
                            }
                        }
                    }
                    break;
                case 9:
                    int internetOrderCount = 0;
                    for (Order order : orderManager.getOrders()) {
                        if (order instanceof InternetOrder) {
                            internetOrderCount++;
                        }
                    }
                    System.out.println("Общее количество интернет-заказов: " + internetOrderCount);
                    break;
                case 10:
                    System.out.println("Выход из программы.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }
}
