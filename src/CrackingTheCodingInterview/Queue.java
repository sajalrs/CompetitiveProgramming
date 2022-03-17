package CrackingTheCodingInterview;

public interface Queue<T> {
    void add(T item);
    T remove();
    T peek();
    boolean isEmpty();
}
