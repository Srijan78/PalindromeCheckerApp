import java.util.*;

// Step 1: Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
    String getStrategyName();
}

// Step 2: Stack-based Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        // push all characters
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // compare by popping
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getStrategyName() {
        return "Stack Strategy";
    }
}

// Step 3: Deque-based Strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        // add characters to deque
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        // compare from both ends
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getStrategyName() {
        return "Deque Strategy";
    }
}

// Step 4: Context Class
class PalindromeChecker {

    private PalindromeStrategy strategy;

    // inject strategy via constructor
    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    // change strategy at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }

    public String getStrategyName() {
        return strategy.getStrategyName();
    }
}

// Step 5: Main Driver
public class PalindromeApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("\nChoose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        // runtime selection
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        // inject selected strategy
        PalindromeChecker checker = new PalindromeChecker(strategy);

        boolean result = checker.check(input);

        System.out.println("\nUsing: " + checker.getStrategyName());
        System.out.println("Is Palindrome? " + result);

        sc.close();
    }
}