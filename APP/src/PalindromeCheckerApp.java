import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine().toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Insert characters into Queue and Stack
        for (char c : input.toCharArray()) {
            queue.add(c);     // Enqueue
            stack.push(c);    // Push
        }

        boolean isPalindrome = true;

        // Compare Queue and Stack
        while (!queue.isEmpty()) {
            char qChar = queue.remove();   // Dequeue
            char sChar = stack.pop();      // Pop

            if (qChar != sChar) {
                isPalindrome = false;
                break;
            }
        }

        // Result
        if (isPalindrome) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        sc.close();
    }
}