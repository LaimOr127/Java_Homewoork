package Homework.Pr14;

public class BoundedWaitList<E> extends WaitList<E> implements BoundedWaitListInterface<E> {
    private int capacity;

    public BoundedWaitList(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void add(E element) {
        if (super.isEmpty() || super.size() < capacity) {
            super.add(element);
        } else {
            System.out.println("The waitlist is full. Cannot add more elements.");
        }
    }

    // Implement other methods as needed
}

