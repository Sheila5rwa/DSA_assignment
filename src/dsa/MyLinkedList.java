package dsa;

/**
 * Custom generic singly linked list implementation without using java.util collections.
 *
 * @param <T> the type of elements held in this collection
 */
public class MyLinkedList<T> {

    /**
     * Internal node class representing an element in the linked list.
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an element to the front of the list.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the first element of the list.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return the removed element
     * @throws IllegalStateException if the list is empty
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty linked list.");
        }
        T removedData = head.data;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return removedData;
    }

    /**
     * Retrieves the element at the specified 0-based index.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param index 0-based position
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Returns the number of elements in the list.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the list contains no elements.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Reverses the singly linked list in place.
     * Time Complexity: O(n)
     * Space Complexity: O(1) auxiliary space
     */
    public void reverse() {
        if (size <= 1) {
            return;
        }
        Node<T> prev = null;
        Node<T> current = head;
        tail = head; // The current head becomes the new tail

        while (current != null) {
            Node<T> nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev; // The last non-null node becomes the new head
    }

    /**
     * Finds and returns the middle element using slow and fast pointers in a single pass.
     * For even lengths, returns the second middle element (standard slow/fast pointer convention).
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @return middle element
     * @throws IllegalStateException if list is empty
     */
    public T findMiddle() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot find middle of an empty list.");
        }
        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> curr = head;
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
