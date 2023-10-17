package Pr21;



import java.util.NoSuchElementException;
import java.util.Scanner;

// Интерфейс Queue
interface Queue<T> {
    void enqueue(T element);   // Добавить элемент в очередь
    T element();               // Первый элемент в очереди
    T dequeue();               // Удалить и вернуть первый элемент в очереди
    int size();                // Текущий размер очереди
    boolean isEmpty();         // Является ли очередь пустой
    void clear();              // Удалить все элементы из очереди
}

// Абстрактный класс AbstractQueue
abstract class AbstractQueue<T> implements Queue<T> {
    @Override
    public void enqueue(T element) {
        if (element != null) {
            enqueueImpl(element);
        }
    }

    @Override
    public T element() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elementImpl();
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return dequeueImpl();
    }

    protected abstract void enqueueImpl(T element);
    protected abstract T elementImpl();
    protected abstract T dequeueImpl();
}

// Класс ArrayQueue
class ArrayQueue<T> extends AbstractQueue<T> {
    private Object[] elements = new Object[10];
    private int size = 0;
    private int head = 0;

    @Override
    protected void enqueueImpl(T element) {
        ensureCapacity(size + 1);
        elements[(head + size) % elements.length] = element;
        size++;
    }

    @Override
    protected T elementImpl() {
        return (T) elements[head];
    }

    @Override
    protected T dequeueImpl() {
        T removedElement = (T) elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return removedElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        elements = new Object[10];
        size = 0;
        head = 0;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            int newCapacity = Math.max(2 * elements.length, capacity);
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(head + i) % elements.length];
            }
            elements = newElements;
            head = 0;
        }
    }
}

// Класс LinkedQueue
class LinkedQueue<T> extends AbstractQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    protected void enqueueImpl(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    protected T elementImpl() {
        return head.value;
    }

    @Override
    protected T dequeueImpl() {
        T removedElement = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return removedElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = null;

        while (true) {
            System.out.println("Выберите тип очереди:");
            System.out.println("1. Очередь на массиве");
            System.out.println("2. Очередь на связанном списке");
            System.out.println("3. Выход");
            int choice = scanner.nextInt();

            if (choice == 1) {
                queue = new ArrayQueue<>();
                System.out.println("Вы выбрали очередь на массиве.");
            } else if (choice == 2) {
                queue = new LinkedQueue<>();
                System.out.println("Вы выбрали очередь на связанном списке.");
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Неверный выбор, попробуйте снова.");
            }

            if (queue != null) {
                processQueue(scanner, queue);
            }
        }
    }

    private static void processQueue(Scanner scanner, Queue<Integer> queue) {
        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Добавить элемент в очередь");
            System.out.println("2. Показать первый элемент в очереди");
            System.out.println("3. Удалить и показать первый элемент в очереди");
            System.out.println("4. Показать размер очереди");
            System.out.println("5. Проверить, пуста ли очередь");
            System.out.println("6. Очистить очередь");
            System.out.println("7. Вернуться к выбору типа очереди");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите элемент: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    System.out.println("Элемент " + element + " добавлен в очередь.");
                    break;
                case 2:
                    try {
                        int firstElement = queue.element();
                        System.out.println("Первый элемент в очереди: " + firstElement);
                    } catch (NoSuchElementException e) {
                        System.out.println("Очередь пуста.");
                    }
                    break;
                case 3:
                    try {
                        int removedElement = queue.dequeue();
                        System.out.println("Удален и возвращен первый элемент: " + removedElement);
                    } catch (NoSuchElementException e) {
                        System.out.println("Очередь пуста.");
                    }
                    break;
                case 4:
                    int size = queue.size();
                    System.out.println("Размер очереди: " + size);
                    break;
                case 5:
                    boolean isEmpty = queue.isEmpty();
                    System.out.println("Очередь " + (isEmpty ? "пуста." : "не пуста."));
                    break;
                case 6:
                    queue.clear();
                    System.out.println("Очередь очищена.");
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
                    break;
            }
        }
    }
}



