package dsa;

/**
 * Utility algorithms for Part 2 and Part 3:
 * - isBalanced (String expr)
 * - rotateRight (int[] a, int k)
 * - isAnagram (String a, String b)
 * - twoSumSorted (int[] a, int target)
 */
public class AlgorithmicProblems {

    /**
     * Checks if parentheses, brackets, and braces in the expression are balanced.
     * Uses our custom MyStack.
     *
     * Example: "{[()]}" -> true, "([)]" -> false
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param expr input string expression
     * @return true if balanced, false otherwise
     */
    public static boolean isBalanced(String expr) {
        if (expr == null) return true;
        MyStack<Character> stack = new MyStack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            // If opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                // If closing bracket encountered but stack is empty
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (!isMatchingPair(open, ch)) {
                    return false;
                }
            }
        }
        // If stack is empty, all opening brackets had matching closing brackets
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    /**
     * Rotates an array to the right by k steps in-place.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) auxiliary space
     *
     * @param a array to rotate
     * @param k number of positions to rotate right
     */
    public static void rotateRight(int[] a, int k) {
        if (a == null || a.length <= 1) return;

        int n = a.length;
        k = k % n;
        if (k < 0) {
            k += n; // handle negative rotations gracefully
        }
        if (k == 0) return;

        // 3-step reversal algorithm:
        // 1. Reverse entire array
        reverseArray(a, 0, n - 1);
        // 2. Reverse first k elements
        reverseArray(a, 0, k - 1);
        // 3. Reverse remaining n - k elements
        reverseArray(a, k, n - 1);
    }

    private static void reverseArray(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Determines whether two strings are anagrams of each other.
     * Case-sensitive and supports standard ASCII characters using a frequency table.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) (fixed alphabet size 256)
     *
     * @param a first string
     * @param b second string
     * @return true if anagrams, false otherwise
     */
    public static boolean isAnagram(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;

        int[] count = new int[256];

        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }

    /**
     * Finds two indices in a 0-indexed sorted array that add up to target using the two-pointer technique.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param a sorted array of integers
     * @param target desired sum
     * @return int[] array of size 2 containing indices, or empty array if not found
     */
    public static int[] twoSumSorted(int[] a, int target) {
        if (a == null || a.length < 2) return new int[0];

        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            int sum = a[left] + a[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0]; // Not found
    }
}
