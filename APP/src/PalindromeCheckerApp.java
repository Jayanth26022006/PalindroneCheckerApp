import java.util.*;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based palindrome strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        String str = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// Two-pointer iterative strategy
class IterativeStrategy implements PalindromeStrategy {

        if (word.equals(reversedWord)) {
            System.out.println("The word \"" + word + "\" is a palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is not a palindromee.");
        }
        return true;
    }
}

// Recursive strategy
class RecursiveStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        String str = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        return isPalindromeRecursive(str, 0, str.length() - 1);
    }

    private boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}

// Context class
class PalindromeChecker {
    private PalindromeStrategy strategy;
    public PalindromeChecker(PalindromeStrategy strategy) { this.strategy = strategy; }
    public boolean checkPalindrome(String input) { return strategy.isPalindrome(input); }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to test: ");
        String input = sc.nextLine();

        // List of strategies
        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new IterativeStrategy(),
                new RecursiveStrategy()
        );

        // Names for display
        List<String> strategyNames = Arrays.asList(
                "Stack Strategy",
                "Iterative Strategy",
                "Recursive Strategy"
        );

        System.out.println("\nPerformance Comparison:");

        for (int i = 0; i < strategies.size(); i++) {
            PalindromeChecker checker = new PalindromeChecker(strategies.get(i));

            long startTime = System.nanoTime();
            boolean result = checker.checkPalindrome(input);
            long endTime = System.nanoTime();

            System.out.println(strategyNames.get(i) + ":");
            System.out.println("Result: " + (result ? "Palindrome" : "Not Palindrome"));
            System.out.println("Execution Time: " + (endTime - startTime) + " ns\n");
        }

        sc.close();
    }
}