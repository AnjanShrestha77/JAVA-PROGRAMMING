import java.util.Scanner;

public class CalendarProgram {

    public static String[] getMonths() {
        return new String[]{
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
    }

    public static int[] getDaysArray() {
        return new int[]{31, 28, 31, 30, 31, 30,
                         31, 31, 30, 31, 30, 31};
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static int getDaysInMonth(int month, int year) {
        int[] days = getDaysArray();
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    public static int getFirstDay(int month, int year) {
        int d = 1; // first day of month
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31*m0)/12) % 7;
        return d0; // 0=Sunday, 1=Monday, ... 6=Saturday
    }

    // Method to print calendar
    public static void printCalendar(int month, int year) {
        String[] months = getMonths();
        int days = getDaysInMonth(month, year);
        int firstDay = getFirstDay(month, year);

        // Print header
        System.out.println("     " + months[month - 1] + " " + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= days; day++) {
            System.out.printf("%4d", day);
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        printCalendar(month, year);
        sc.close();
    }
}
