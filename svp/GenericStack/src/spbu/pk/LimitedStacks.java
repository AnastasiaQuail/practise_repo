package spbu.pk;

/**
 * Created by user on 27.10.2015.
 */
public class LimitedStacks<T> implements Stacks<T> {
    private Class<T> clazz;
    private final int size = 5;
    private T[] values;
    private int index;

    public LimitedStacks() {
        index = -1;
        values = (T[]) new Object[size];
    }

    public int getsize()
    {
        return size;
    }
    @Override
    public T pop() {

        T a = values[index];
        values[index] = null;
        index--;
        return a;
    }

    @Override
    public void push(T object) {
        index++;
        if(index>=size) {
            index-=1;
            throw new ArrayIndexOutOfBoundsException();
        }
        values[index] = object;
    }

    @Override
    public boolean empty() {
        if (index < 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T peek()  {
        return values[index];
    }
}
