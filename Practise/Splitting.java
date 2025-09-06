import java.util.Scanner;

public class Splitting {

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

    public static String[] customSplit(String str) {
        int len = findLength(str);
        int[] spaceIndexes = new int[len];
        int spaceCount = 0;

        // Find all space positions
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[spaceCount++] = i;
            }
        }

        int wordCount = spaceCount + 1;
        String[] words = new String[wordCount];

        int start = 0;
        int wordIndex = 0;
        for (int i = 0; i < spaceCount; i++) {
            int end = spaceIndexes[i];
            words[wordIndex++] = str.substring(start, end);
            start = end + 1;
        }
        words[wordIndex] = str.substring(start, len);

        return words;
    }

    
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a string:");
        String str = input.nextLine();

      
        int n = findLength(str);
        System.out.println("Length (custom method): " + n);
        System.out.println("Length (built-in): " + str.length());

        
        String[] customWords = customSplit(str);

        
        String[] builtInWords = str.split(" ");

     
        boolean same = compareArrays(customWords, builtInWords);

       
        System.out.println("\nCustom split result:");
        for (String word : customWords) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in split result:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("\nAre both results the same? " + same);

        input.close();
    }
}
