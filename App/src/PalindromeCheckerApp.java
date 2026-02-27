/**
 * ============================================================
 * UC13: Performance Comparison of Palindrome Algorithms
 * ============================================================
 *
 * Description:
 * Compares execution time of different palindrome methods.
 */

import java.util.*;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        long startStack = System.nanoTime();
        boolean stackResult = stackPalindrome(normalized);
        long endStack = System.nanoTime();
        long startDeque = System.nanoTime();
        boolean dequeResult = dequePalindrome(normalized);
        long endDeque = System.nanoTime();
        long startTwoPointer = System.nanoTime();
        boolean twoPointerResult = twoPointerPalindrome(normalized);
        long endTwoPointer = System.nanoTime();
        System.out.println("\nResults:");
        System.out.println("Stack Result: " + stackResult);
        System.out.println("Time (ns): " + (endStack - startStack));

        System.out.println("\nDeque Result: " + dequeResult);
        System.out.println("Time (ns): " + (endDeque - startDeque));

        System.out.println("\nTwo Pointer Result: " + twoPointerResult);
        System.out.println("Time (ns): " + (endTwoPointer - startTwoPointer));

        scanner.close();
    }
    public static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
    public static boolean dequePalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
    public static boolean twoPointerPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}