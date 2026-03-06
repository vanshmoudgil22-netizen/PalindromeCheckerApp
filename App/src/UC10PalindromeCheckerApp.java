import java.util.Scanner;

public class UC10PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String word = input.nextLine();

        String normalized = word.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = true;
        for (int i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a palindrome (ignoring case and spaces).");
        } else {
            System.out.println(word + " is not a palindrome (ignoring case and spaces).");
        }
    }
}