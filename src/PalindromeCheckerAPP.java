import java.util.Scanner;

// Palindrome service class
class PalindromeChecker {

    // Check palindrome (ignoring case & spaces)
    public boolean checkPalindrome(String input) {

        if (input == null || input.isEmpty()) {
            return false;
        }

        // Normalize string: remove spaces and lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Call internal recursive method
        return isPalindromeRecursive(normalized, 0, normalized.length() - 1);
    }

    // Internal recursive method
    private boolean isPalindromeRecursive(String str, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}

// Main application
public class PalindromeCheckerAPP {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("=== Object-Oriented Palindrome Checker ===");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
