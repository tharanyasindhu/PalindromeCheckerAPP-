import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeCheckerAPP {

    // Method to check palindrome using deque
    public static boolean isPalindrome(String input) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize deque
        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (char c : cleanInput.toCharArray()) {
            deque.addLast(c);
        }

        // Compare front and rear until deque is empty or mismatch found
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();
            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Deque-Based Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("The string is a palindrome!");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        scanner.close();
    }
}


