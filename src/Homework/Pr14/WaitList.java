package Homework.Pr14;

public interface WaitList<E> {
    void add(E element);
    E remove();
    boolean contains(E element);
    boolean isEmpty();
}

