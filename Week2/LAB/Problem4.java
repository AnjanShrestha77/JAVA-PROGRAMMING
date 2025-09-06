import java.util.Scanner;

public class Problem4 {
    public static String encrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append((char) ((c - 'A' + shift) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                sb.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        String enc = encrypt(text, shift);
        String dec = decrypt(enc, shift);

        System.out.println("Original : " + text);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}
