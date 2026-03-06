import java.util.Scanner;

public class UC9PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String word = input.nextLine();

        if (isPalindrome(word, 0, word.length() - 1)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }

    private static boolean isPalindrome(String word, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }
        return isPalindrome(word, start + 1, end - 1);
    }
}