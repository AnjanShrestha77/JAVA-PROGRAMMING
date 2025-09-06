import java.util.Scanner;

public class WordLengthTable {

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return count;
    }

    public static String[] splitIntoWords(String text) {
        int len = findLength(text);
        int spaceCount = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        String[] words = new String[spaceCount + 1];
        StringBuilder currentWord = new StringBuilder();
        int index = 0;

        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            if (c != ' ') {
                currentWord.append(c);
            } else {
                words[index++] = currentWord.toString();
                currentWord.setLength(0);
            }
        }
        words[index] = currentWord.toString();

        return words;
    }

    public static String[][] getWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(findLength(words[i])); 
        }

        return table;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String text = input.nextLine();

        String[] words = splitIntoWords(text);
        String[][] table = getWordLengthTable(words);

        System.out.printf("%-15s %-10s%n", "Word", "Length");
        System.out.println("-----------------------------");
        for (int i = 0; i < table.length; i++) {
            int len = Integer.parseInt(table[i][1]);
            System.out.printf("%-15s %-10d%n", table[i][0], len);
        }
    }
}
