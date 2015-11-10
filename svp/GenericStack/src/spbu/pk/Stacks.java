package spbu.pk;


/**
 * @param <T>
 */
public interface Stacks<T> {
    T pop();

    void push(T ob);

    boolean empty();

    T peek();
}
