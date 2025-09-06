import java.util.*;

public class Problem5 {
    public static boolean isValid(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        int dot = email.lastIndexOf('.');
        return (at > 0 && at == lastAt && dot > at && dot < email.length() - 1);
    }

    public static void analyzeEmail(String email) {
        if (!isValid(email)) {
            System.out.println(email + " | Invalid");
            return;
        }
        int at = email.indexOf('@');
        int dot = email.lastIndexOf('.');
        String username = email.substring(0, at);
        String domain = email.substring(at + 1);
        String domainName = email.substring(at + 1, dot);
        String ext = email.substring(dot + 1);
        System.out.println(email + " | " + username + " | " + domain + " | " + domainName + " | " + ext + " | Valid");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter emails (comma separated): ");
        String[] emails = sc.nextLine().split(",");

        System.out.println("Email | Username | Domain | DomainName | Extension | Valid/Invalid");
        for (String e : emails) {
            analyzeEmail(e.trim());
        }
    }
}
