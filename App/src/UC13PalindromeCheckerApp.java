import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class UC13PalindromeCheckerApp {

    public static boolean checkWithStack(String word) {
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

    public static boolean checkWithDeque(String word) {
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

    public static boolean checkWithTwoPointer(String word) {
        String normalized = word.toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String word = input.nextLine();

        long startTime, endTime;

        startTime = System.nanoTime();
        boolean stackResult = checkWithStack(word);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean dequeResult = checkWithDeque(word);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean twoPointerResult = checkWithTwoPointer(word);
        endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;

        System.out.println("Stack Strategy: " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Deque Strategy: " + dequeResult + " | Time: " + dequeTime + " ns");
        System.out.println("Two-Pointer Strategy: " + twoPointerResult + " | Time: " + twoPointerTime + " ns");
    }
}