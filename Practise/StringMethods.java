import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter your full name (first and last): ");
        String fullName = scanner.nextLine();

       
        System.out.print("Enter your favorite programming language: ");
        String favLang = scanner.nextLine();

        System.out.print("Write a sentence about your programming experience: ");
        String sentence = scanner.nextLine();

        String[] nameParts = fullName.trim().split(" ", 2);
        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[1] : "";

        String sentenceNoSpaces = sentence.replace(" ", "");
        int charCount = sentenceNoSpaces.length();

        String favLangUpper = favLang.toUpperCase();

        System.out.println("\n--- Summary ---");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Language: " + favLangUpper);
        System.out.println("Sentence Character Count (no spaces): " + charCount);
        System.out.println("Your Sentence: " + sentence);

        scanner.close();
    }
}
