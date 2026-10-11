package dsa;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU (Least Recently Used) Cache implementation.
 * Combines a HashMap and a custom doubly linked list to achieve O(1) time
 * for both get and put operations.
 */
public class LRUCache {

    /**
     * Custom Doubly Linked List Node to store key-value mappings.
     */
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    /**
     * Initializes LRUCache with given capacity.
     *
     * @param capacity maximum number of items the cache can hold
     */
    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Initialize dummy head and tail sentinel nodes
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    /**
     * Retrieves value associated with key and marks it as most recently used.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param key key to find
     * @return value if present, else -1
     */
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    /**
     * Inserts or updates the value of the given key.
     * If capacity is exceeded, evicts the least recently used entry.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param key key
     * @param value value
     */
    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            // Key already exists, update value and move to head (most recently used)
            node.value = value;
            moveToHead(node);
        } else {
            // New key
            if (map.size() >= capacity) {
                // Evict least recently used (node right before tail)
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addFirst(newNode);
        }
    }

    // --- Internal Doubly Linked List Operations ---

    /**
     * Adds node right after the dummy head (most recently used position).
     */
    private void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * Removes node from the doubly linked list.
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * Moves an existing node to the most recently used position (after dummy head).
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addFirst(node);
    }

    /**
     * Helper method to display current cache content from MRU to LRU.
     */
    public String displayOrder() {
        StringBuilder sb = new StringBuilder("[MRU -> ");
        Node curr = head.next;
        while (curr != tail) {
            sb.append("(").append(curr.key).append(":").append(curr.value).append(")");
            if (curr.next != tail) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }
        sb.append(" <- LRU]");
        return sb.toString();
    }
}
