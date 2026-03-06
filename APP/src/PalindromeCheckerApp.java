import java.util.Scanner;

// Service class encapsulating palindrome logic
class PalindromeChecker {

    // Method to check palindrome
    public boolean checkPalindrome(String input) {
        // Normalize string: lowercase + remove non-alphanumeric characters
        String str = input.toLowerCase().replaceAll("[^a-z0-9]", "");

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

// Main application class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        sc.close();
    }
}