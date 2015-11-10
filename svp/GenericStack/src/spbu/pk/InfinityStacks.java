package spbu.pk;

import java.util.ArrayList;

/**
 **
 * @param <T>
 */
public class InfinityStacks<T> implements Stacks<T> {
    ArrayList<T> values ;
    private int index;

    public InfinityStacks(){
        index = -1;
        values =  new ArrayList();
    }
    @Override
    public T pop() {
        T a = values.get(index);
        values.remove(index);
        index--;
        return a;
    }

    @Override
    public void push(T ob) {
        values.add(ob);
        index++;
    }

    @Override
    public boolean empty() {
        return values.isEmpty();
    }

    @Override
    public T peek() {
        return values.get(index);
    }
}
