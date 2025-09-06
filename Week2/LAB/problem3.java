import java.util.Scanner;

public class Problem3 {
    public static long stringConcat(int n) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + "a";
        }
        long end = System.currentTimeMillis();
        System.out.println("String      | Time: " + (end - start) + " ms | Length: " + s.length());
        return end - start;
    }

    public static long stringBuilderConcat(int n) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder | Time: " + (end - start) + " ms | Length: " + sb.length());
        return end - start;
    }

    public static long stringBufferConcat(int n) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer | Time: " + (end - start) + " ms | Length: " + sb.length());
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int n = sc.nextInt();

        stringConcat(n);
        stringBuilderConcat(n);
        stringBufferConcat(n);
    }
}
