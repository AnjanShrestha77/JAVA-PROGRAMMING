import java.util.*;

public class Problem6 {
    public static List<String> splitWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (start < i) words.add(text.substring(start, i));
                start = i + 1;
            }
        }
        if (start < text.length()) words.add(text.substring(start));
        return words;
    }

    public static List<String> justify(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int count = 0, start = 0;

        for (int i = 0; i < words.size(); i++) {
            if (count + words.get(i).length() + (i - start) <= width) {
                count += words.get(i).length();
            } else {
                int spaces = width - count;
                int gaps = i - start - 1;
                StringBuilder sb = new StringBuilder();
                for (int j = start; j < i; j++) {
                    sb.append(words.get(j));
                    if (j < i - 1) {
                        int extra = spaces / gaps + (j - start < spaces % gaps ? 1 : 0);
                        for (int k = 0; k <= extra; k++) sb.append(" ");
                    }
                }
                lines.add(sb.toString());
                start = i;
                count = words.get(i).length();
            }
        }
        StringBuilder last = new StringBuilder();
        for (int i = start; i < words.size(); i++) {
            if (i > start) last.append(" ");
            last.append(words.get(i));
        }
        lines.add(last.toString());
        return lines;
    }

    public static List<String> center(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (String w : words) {
            if (len + w.length() + (sb.length() == 0 ? 0 : 1) > width) {
                int pad = (width - sb.length()) / 2;
                lines.add(" ".repeat(pad) + sb.toString());
                sb = new StringBuilder();
                len = 0;
            }
            if (sb.length() > 0) sb.append(" ");
            sb.append(w);
            len += w.length();
        }
        if (sb.length() > 0) {
            int pad = (width - sb.length()) / 2;
            lines.add(" ".repeat(pad) + sb.toString());
        }
        return lines;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        System.out.print("Enter width: ");
        int width = sc.nextInt();

        List<String> words = splitWords(text);
        List<String> justified = justify(words, width);
        List<String> centered = center(words, width);

        System.out.println("\nJustified:");
        for (String l : justified) System.out.println(l);

        System.out.println("\nCentered:");
        for (String l : centered) System.out.println(l);
    }
}
