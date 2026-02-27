import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);   // Insert at rear
        }
        boolean isPalindrome = true;
        while (deque.size() > 1) {
            char front = deque.removeFirst();  // Remove from front
            char rear = deque.removeLast();    // Remove from rear
            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}