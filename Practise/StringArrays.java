public class StringArrays {

    // Method to find the longest name
    public static String findLongestName(String[] names) {
        String longest = names[0];
        for (String name : names) {
            if (name.length() > longest.length()) {
                longest = name;
            }
        }
        return longest;
    }

    // Method to count names starting with a given letter (case-insensitive)
    public static int countNamesStartingWith(String[] names, char letter) {
        int count = 0;
        char lowerLetter = Character.toLowerCase(letter);
        for (String name : names) {
            if (!name.isEmpty() && Character.toLowerCase(name.charAt(0)) == lowerLetter) {
                count++;
            }
        }
        return count;
    }

    // Method to format names to "Last, First" format
    public static String[] formatNames(String[] names) {
        String[] formatted = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ", 2);
            if (parts.length == 2) {
                formatted[i] = parts[1] + ", " + parts[0];
            } else {
                formatted[i] = names[i]; 
            }
        }
        return formatted;
    }

    public static void main(String[] args) {
        String[] students = {
            "John Smith",
            "Alice Johnson",
            "Bob Brown",
            "Carol Davis",
            "David Wilson"
        };

        
        System.out.println("Longest name: " + findLongestName(students));

        System.out.println("Names starting with 'A': " + countNamesStartingWith(students, 'A'));

        String[] formatted = formatNames(students);
        System.out.println("Formatted names:");
        for (String name : formatted) {
            System.out.println(name);
        }
    }
}
