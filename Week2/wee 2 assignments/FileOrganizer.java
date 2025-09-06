import java.util.Scanner;

public class FileOrganizer {
    static String[] categories = {"Document", "Image", "Audio", "Video", "Unknown"};
    static String[] docExt = {".txt", ".doc", ".docx", ".pdf"};
    static String[] imgExt = {".jpg", ".png", ".gif"};
    static String[] audioExt = {".mp3", ".wav"};
    static String[] videoExt = {".mp4", ".avi"};
    static int[] counts = new int[categories.length];
    static int fileCounter = 1;

    public static boolean isValidFileName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int ascii = (int) c;
            if (!((ascii >= 48 && ascii <= 57) || (ascii >= 65 && ascii <= 90) ||
                  (ascii >= 97 && ascii <= 122) || c == '.' || c == '_')) {
                return false;
            }
        }
        return true;
    }

    public static String getExtension(String file) {
        int dot = file.lastIndexOf('.');
        if (dot == -1) return "";
        return file.substring(dot).toLowerCase();
    }

    public static String getNameWithoutExt(String file) {
        int dot = file.lastIndexOf('.');
        if (dot == -1) return file;
        return file.substring(0, dot);
    }

    public static String categorize(String ext) {
        for (String e : docExt) if (ext.equals(e)) { counts[0]++; return "Document"; }
        for (String e : imgExt) if (ext.equals(e)) { counts[1]++; return "Image"; }
        for (String e : audioExt) if (ext.equals(e)) { counts[2]++; return "Audio"; }
        for (String e : videoExt) if (ext.equals(e)) { counts[3]++; return "Video"; }
        counts[4]++;
        return "Unknown";
    }

    public static String analyzeContent(String fileName, String content) {
        if (!getExtension(fileName).equals(".txt")) return "";
        String lower = content.toLowerCase();
        if (lower.contains("resume")) return "Resume";
        if (lower.contains("report")) return "Report";
        if (lower.contains("class") || lower.contains("public")) return "Code";
        return "GeneralText";
    }

    public static String generateNewName(String category, String extension) {
        StringBuilder sb = new StringBuilder();
        sb.append(category).append("_").append(fileCounter).append(extension);
        fileCounter++;
        return sb.toString();
    }

    public static void printReport(String[][] files) {
        System.out.println("\n--- File Organization Report ---");
        System.out.printf("%-20s %-12s %-20s %-12s\n", "Original", "Category", "New Name", "Subcategory");
        for (int i = 0; i < files.length; i++) {
            System.out.printf("%-20s %-12s %-20s %-12s\n",
                    files[i][0], files[i][1], files[i][2], files[i][3]);
        }

        System.out.println("\n--- Category Counts ---");
        for (int i = 0; i < categories.length; i++) {
            System.out.println(categories[i] + ": " + counts[i]);
        }
    }

    public static void generateBatchCommands(String[][] files) {
        System.out.println("\n--- Batch Rename Commands ---");
        for (int i = 0; i < files.length; i++) {
            System.out.println("rename " + files[i][0] + " -> " + files[i][2]);
        }
        System.out.println("Total files: " + files.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of files: ");
        int n = Integer.parseInt(sc.nextLine());
        String[][] files = new String[n][4];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter file name: ");
            String file = sc.nextLine();
            if (!isValidFileName(file)) {
                files[i][0] = file;
                files[i][1] = "Invalid";
                files[i][2] = "N/A";
                files[i][3] = "N/A";
                continue;
            }
            String ext = getExtension(file);
            String category = categorize(ext);
            String newName = generateNewName(category, ext);
            String content = "";
            if (ext.equals(".txt")) {
                System.out.print("Enter content of " + file + ": ");
                content = sc.nextLine();
            }
            String subcat = analyzeContent(file, content);
            files[i][0] = file;
            files[i][1] = category;
            files[i][2] = newName;
            files[i][3] = subcat;
        }

        printReport(files);
        generateBatchCommands(files);
    }
}
