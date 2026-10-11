package dsa;

import java.util.Arrays;

/**
 * Main class to demonstrate and test all parts of the assignment:
 * - Part 1: Custom Singly Linked List
 * - Part 2: Stack, Queue using two stacks, and isBalanced
 * - Part 3: rotateRight, isAnagram, and twoSumSorted
 * - Part 4: LRUCache demonstration
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println(" WEEK 3 ASSIGNMENT: BUILD YOUR OWN DATA STRUCTURES (DSA I) ");
        System.out.println("============================================================\n");

        demoPart1();
        demoPart2();
        demoPart3();
        demoPart4();

        System.out.println("============================================================");
        System.out.println(" ALL DEMOS AND TEST CASES COMPLETED SUCCESSFULLY! ");
        System.out.println("============================================================");
    }

    private static void demoPart1() {
        System.out.println("--- PART 1: Custom Singly Linked List ---");
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        System.out.println("List after addFirst(5) & addLast(10, 20, 30): " + list);
        System.out.println("Size: " + list.size());
        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("Middle element (even count [5, 10, 20, 30]): " + list.findMiddle());

        list.addLast(40);
        System.out.println("List after adding 40: " + list);
        System.out.println("Middle element (odd count [5, 10, 20, 30, 40]): " + list.findMiddle());

        int removed = list.removeFirst();
        System.out.println("Removed first element: " + removed + ", list now: " + list);

        System.out.println("Reversing list in-place...");
        list.reverse();
        System.out.println("List after reverse(): " + list);
        System.out.println();
    }

    private static void demoPart2() {
        System.out.println("--- PART 2: Stack & Queue ---");

        // 1. MyStack
        System.out.println("[1] MyStack<String> Demo:");
        MyStack<String> stack = new MyStack<>();
        stack.push("Alpha");
        stack.push("Beta");
        stack.push("Gamma");
        System.out.println("Stack size: " + stack.size());
        System.out.println("Peek top: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is stack empty now? " + stack.isEmpty());

        // 2. MyQueue using two stacks
        System.out.println("\n[2] MyQueue<Integer> (using two stacks) Demo:");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        System.out.println("Enqueued 100, 200, 300. Front is: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        queue.enqueue(400);
        System.out.println("Enqueued 400. Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Is queue empty? " + queue.isEmpty());

        // 3. Balanced Parentheses
        System.out.println("\n[3] isBalanced(String expr) Demo:");
        String expr1 = "{[()]}";
        String expr2 = "([)]";
        String expr3 = "{([])}";
        String expr4 = "((())";
        System.out.println("\"" + expr1 + "\" is balanced? " + AlgorithmicProblems.isBalanced(expr1) + " (Expected: true)");
        System.out.println("\"" + expr2 + "\" is balanced? " + AlgorithmicProblems.isBalanced(expr2) + " (Expected: false)");
        System.out.println("\"" + expr3 + "\" is balanced? " + AlgorithmicProblems.isBalanced(expr3) + " (Expected: true)");
        System.out.println("\"" + expr4 + "\" is balanced? " + AlgorithmicProblems.isBalanced(expr4) + " (Expected: false)");
        System.out.println();
    }

    private static void demoPart3() {
        System.out.println("--- PART 3: Arrays & Strings ---");

        // 1. rotateRight
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("Original array: " + Arrays.toString(arr));
        AlgorithmicProblems.rotateRight(arr, k);
        System.out.println("Rotated right by " + k + ": " + Arrays.toString(arr) + " (Expected: [5, 6, 7, 1, 2, 3, 4])");

        // 2. isAnagram
        String s1 = "anagram", s2 = "nagaram";
        String s3 = "rat", s4 = "car";
        System.out.println("isAnagram(\"" + s1 + "\", \"" + s2 + "\"): " + AlgorithmicProblems.isAnagram(s1, s2) + " (Expected: true)");
        System.out.println("isAnagram(\"" + s3 + "\", \"" + s4 + "\"): " + AlgorithmicProblems.isAnagram(s3, s4) + " (Expected: false)");

        // 3. twoSumSorted
        int[] sorted = {2, 7, 11, 15};
        int target = 9;
        int[] indices = AlgorithmicProblems.twoSumSorted(sorted, target);
        System.out.println("twoSumSorted(" + Arrays.toString(sorted) + ", target=" + target + "): indices " +
                Arrays.toString(indices) + " (Values: " + sorted[indices[0]] + " + " + sorted[indices[1]] + " = " + target + ")");
        System.out.println();
    }

    private static void demoPart4() {
        System.out.println("--- PART 4: LRU Cache Demo ---");
        LRUCache cache = new LRUCache(2);
        System.out.println("Created LRUCache with capacity 2");

        System.out.println("put(1, 1)");
        cache.put(1, 1);
        System.out.println("Cache: " + cache.displayOrder());

        System.out.println("put(2, 2)");
        cache.put(2, 2);
        System.out.println("Cache: " + cache.displayOrder());

        System.out.println("get(1) -> " + cache.get(1) + " (1 accessed, becomes MRU)");
        System.out.println("Cache: " + cache.displayOrder());

        System.out.println("put(3, 3) (Capacity exceeded, should evict LRU key 2)");
        cache.put(3, 3);
        System.out.println("Cache: " + cache.displayOrder());

        System.out.println("get(2) -> " + cache.get(2) + " (Expected: -1 because evicted)");
        System.out.println("put(4, 4) (Capacity exceeded, should evict LRU key 1)");
        cache.put(4, 4);
        System.out.println("Cache: " + cache.displayOrder());

        System.out.println("get(1) -> " + cache.get(1) + " (Expected: -1)");
        System.out.println("get(3) -> " + cache.get(3) + " (Expected: 3)");
        System.out.println("get(4) -> " + cache.get(4) + " (Expected: 4)");
        System.out.println();
    }
}
