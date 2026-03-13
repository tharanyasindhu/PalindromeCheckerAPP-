import java.util.Scanner;

public class PalindromeCheckerAPP{

    // Recursive palindrome checker
    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // If characters do not match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }

    // Normalize string: remove spaces & lowercase
    public static String normalizeString(String input) {
        // Remove spaces and convert to lowercase
        return input.replaceAll("\\s+", "").toLowerCase();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Case-Insensitive & Space-Ignored Palindrome Checker ===");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String normalized = normalizeString(input);

        boolean result = isPalindrome(normalized, 0, normalized.length() - 1);

        if (result) {
            System.out.println("The string is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
