import java.util.*;

public class Problem1 {
    // Split words manually without split()
    public static String[] splitWords(String text) {
        String[] temp = new String[text.length()];
        int count = 0, start = 0;

        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == ' ' || text.charAt(i) == '.' || text.charAt(i) == ',') {
                if (i > start) {
                    temp[count++] = text.substring(start, i);
                }
                start = i + 1;
            }
        }

        String[] words = new String[count];
        for (int i = 0; i < count; i++) words[i] = temp[i];
        return words;
    }

    // Very simple distance: count mismatched chars + length difference
    public static int distance(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int diff = Math.abs(a.length() - b.length());
        int d = diff;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) d++;
        }
        return d;
    }

    // Find closest match in dictionary
    public static String suggest(String word, String[] dict) {
        String best = word;
        int minDist = Integer.MAX_VALUE;
        for (String d : dict) {
            int dist = distance(word, d);
            if (dist < minDist) {
                minDist = dist;
                best = d;
            }
        }
        if (minDist <= 2 && !best.equals(word)) return best;
        return "Correct";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] dictionary = {"apple", "banana", "orange", "grape", "mango"};

        System.out.println("Enter a sentence: ");
        String sentence = sc.nextLine();

        String[] words = splitWords(sentence);

        System.out.println("\nWord\t\tSuggestion\tDistance");
        for (String w : words) {
            int minDist = Integer.MAX_VALUE;
            String suggestion = suggest(w, dictionary);
            if (suggestion.equals("Correct")) {
                System.out.println(w + "\t\tCorrect\t\t0");
            } else {
                System.out.println(w + "\t\t" + suggestion + "\t\t" + distance(w, suggestion));
            }
        }
    }
}
