package dsa;

import java.util.NoSuchElementException;

/**
 * Queue implementation using two stacks (inStack and outStack).
 * Amortized O(1) operations.
 *
 * @param <T> type of elements stored in the queue
 */
public class MyQueue<T> {

    private final MyStack<T> inStack;
    private final MyStack<T> outStack;

    public MyQueue() {
        this.inStack = new MyStack<>();
        this.outStack = new MyStack<>();
    }

    /**
     * Enqueues an item to the rear of the queue.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void enqueue(T item) {
        inStack.push(item);
    }

    /**
     * Dequeues and returns the item from the front of the queue.
     * Time Complexity: Amortized O(1), Worst-case O(n)
     * Space Complexity: O(1)
     *
     * @return front element
     * @throws NoSuchElementException if queue is empty
     */
    public T dequeue() {
        shiftStacks();
        if (outStack.isEmpty()) {
            throw new NoSuchElementException("Cannot dequeue from an empty queue.");
        }
        return outStack.pop();
    }

    /**
     * Returns the front item without removing it.
     * Time Complexity: Amortized O(1), Worst-case O(n)
     * Space Complexity: O(1)
     *
     * @return front element
     * @throws NoSuchElementException if queue is empty
     */
    public T peek() {
        shiftStacks();
        if (outStack.isEmpty()) {
            throw new NoSuchElementException("Cannot peek into an empty queue.");
        }
        return outStack.peek();
    }

    /**
     * Helper to move elements from inStack to outStack when outStack is empty.
     */
    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    /**
     * Checks if the queue is empty.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    /**
     * Returns total number of elements in queue.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int size() {
        return inStack.size() + outStack.size();
    }
}
