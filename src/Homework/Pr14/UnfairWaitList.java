package Homework.Pr14;

import java.util.LinkedList;

public class UnfairWaitList<E> extends WaitList<E> implements UnfairWaitListInterface<E> {
    public UnfairWaitList() {
        super();
    }

    @Override
    public void remove(E element) {
        if (super.contains(element)) {
            super.remove(element);
        }
    }

    @Override
    public void moveToBack(E element) {
        if (super.contains(element)) {
            super.remove(element);
            super.add(element);
        }
    }

    // Implement other methods as needed
}
