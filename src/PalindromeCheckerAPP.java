import java.util.*;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based palindrome checker
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) stack.push(c);
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// Deque-based palindrome checker
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

// Recursive palindrome checker
class RecursiveStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursive(normalized, 0, normalized.length() - 1);
    }

    private boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}

// Main application
public class PalindromeCheckerAPP {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker Performance Comparison ===");
        System.out.print("Enter a string to test: ");
        String input = scanner.nextLine();

        PalindromeStrategy[] strategies = {
                new StackStrategy(),
                new DequeStrategy(),
                new RecursiveStrategy()
        };

        String[] strategyNames = {"Stack Strategy", "Deque Strategy", "Recursive Strategy"};

        for (int i = 0; i < strategies.length; i++) {
            long startTime = System.nanoTime();
            boolean result = strategies[i].isPalindrome(input);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.printf("%s: %s, Time taken = %d ns%n",
                    strategyNames[i],
                    result ? "Palindrome" : "Not Palindrome",
                    duration);
        }

        scanner.close();
    }
}
