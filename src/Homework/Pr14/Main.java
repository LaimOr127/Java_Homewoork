package Homework.Pr14;

public class Main {
    public static void main(String[] args) {
        // Создание ожидаемого списка с ограничением на 5 элементов
        BoundedWaitList<String> boundedWaitList = new BoundedWaitList<>(5);

        // Добавление элементов
        boundedWaitList.add("Element 1");
        boundedWaitList.add("Element 2");
        boundedWaitList.add("Element 3");

        // Удаление элемента
        String removedElement = boundedWaitList.remove();
        System.out.println("Removed element: " + removedElement);

        // Проверка на наличие элемента
        boolean containsElement = boundedWaitList.contains("Element 2");
        System.out.println("Contains Element 2: " + containsElement);

        // Создание нечестного ожидаемого списка
        UnfairWaitList<String> unfairWaitList = new UnfairWaitList<>();
        unfairWaitList.add("Element A");
        unfairWaitList.add("Element B");

        // Перемещение элемента в конец
        unfairWaitList.moveToBack("Element A");

        // Удаление элемента
        unfairWaitList.remove("Element B");
    }
}

