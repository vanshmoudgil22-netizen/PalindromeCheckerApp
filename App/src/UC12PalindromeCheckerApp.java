import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

interface PalindromeStrategy {
    boolean checkPalindrome(String word);
}

class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String word) {
        Stack<Character> stack = new Stack<>();
        for (char c : word.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return word.equalsIgnoreCase(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String word) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : word.toCharArray()) {
            deque.add(c);
        }
        while (deque.size() > 1) {
            if (Character.toLowerCase(deque.removeFirst()) != Character.toLowerCase(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

public class UC12PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String word = input.nextLine();

        PalindromeStrategy strategy;

        System.out.println("Choose strategy: 1 for Stack, 2 for Deque");
        int choice = input.nextInt();

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        if (strategy.checkPalindrome(word)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}