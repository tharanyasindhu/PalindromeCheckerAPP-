// File: UseCase8PalindromeCheckerApp.java
import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerAPP {

    // Method to check if a linked list is palindrome
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle using fast & slow pointers
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverseList(slow.next);
        Node firstHalf = head;

        // Step 3: Compare first half and reversed second half
        Node temp = secondHalf;
        boolean palindrome = true;
        while (temp != null) {
            if (firstHalf.data != temp.data) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        // Step 4: Restore the second half (optional)
        slow.next = reverseList(secondHalf);

        return palindrome;
    }

    // Helper method to reverse a linked list
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Convert string to linked list
    public static Node stringToLinkedList(String str) {
        Node head = null;
        Node tail = null;
        for (char c : str.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== Linked List Based Palindrome Checker ====");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        Node head = stringToLinkedList(input);
        if (isPalindrome(head)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }
}

