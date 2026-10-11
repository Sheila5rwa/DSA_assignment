package dsa;

import java.util.EmptyStackException;

/**
 * Generic Stack implementation backed by our custom Singly Linked List.
 * No java.util collections used.
 *
 * @param <T> type of elements stored in the stack
 */
public class MyStack<T> {

    private final MyLinkedList<T> list;

    public MyStack() {
        this.list = new MyLinkedList<>();
    }

    /**
     * Pushes an item onto the top of the stack.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void push(T item) {
        list.addFirst(item);
    }

    /**
     * Removes and returns the top item of the stack.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return top element
     * @throws EmptyStackException if stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }

    /**
     * Returns the top item of the stack without removing it.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return top element
     * @throws EmptyStackException if stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(0);
    }

    /**
     * Checks if the stack is empty.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of elements in the stack.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
