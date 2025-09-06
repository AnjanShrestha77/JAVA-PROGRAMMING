import java.util.Scanner;

public class Bmi {
    public static String[][] bmiStatus(double[][] member) {
        String[][] output = new String[member.length][2];
        for (int i = 0; i < member.length; i++) {
            double heightInMeters = member[i][1] / 100.0; 
            double bmi = member[i][0] / (heightInMeters * heightInMeters);

            String status;
            if (bmi <= 18.4) {
                status = "Underweight";
            } else if (bmi <= 24.9) {
                status = "Normal";
            } else if (bmi <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            output[i][0] = String.format("%.2f", bmi); 
            output[i][1] = status;
        }
        return output;
    }

    public static void display(String[][] output,double[][] member) {
System.out.printf("%-12s %-12s %-12s %-12s%n", "Weight(kg)", "Height(cm)", "BMI", "Status");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-12.2f %-12.2f %-12s %-12s%n",
                    member[i][0], member[i][1], output[i][0], output[i][1]);
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] member = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter the weight (kg) of member [" + (i + 1) + "]: ");
            member[i][0] = input.nextDouble();
            System.out.println("Enter the height (cm) of member [" + (i + 1) + "]: ");
            member[i][1] = input.nextDouble();
        }

        String[][] output = bmiStatus(member);
        display(output, member);
        
        input.close();
    }
}
