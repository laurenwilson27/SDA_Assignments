package Stack;

import java.util.ArrayList;

// 5. Implement a stack datastructure using LinkedList instead of Arrays
//  I decided to make this class generic
//  Note that this class makes use of Java language version 21 or newer
public class StackList<T> {
    private final ArrayList<T> stack;

    public StackList() {
        stack = new ArrayList<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(T value) {
        stack.add(value);
    }

    public T peek() {
        if (isEmpty())
            return null;
        else
            return stack.getLast();
    }

    public T pop() {
        if (isEmpty())
            return null;
        else {
            T topValue = stack.getLast();
            stack.removeLast();

            return topValue;
        }
    }

    public void delete() {
        stack.clear();
    }
}
