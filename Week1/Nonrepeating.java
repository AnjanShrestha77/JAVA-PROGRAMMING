import java.util.Scanner;
public class Nonrepeating {
     
    public static char firstNonRepeating(String str){
        int[] freq=new int[256];
        int i=0;

        // using loop to find the frequency of the characters
        for( i=0;i<str.length();i++){
            freq[str.charAt(i)]++;
        }

        for( i=0;i<str.length();i++){
            if(freq[str.charAt(i)]==1){
                
                break;
            }

        }
        return  str.charAt(i);
    }
    
    public static void main(String[] args) {
        Scanner input=new Scanner (System.in);
        System.out.println("Enter a string ");
        String str=input.nextLine();
        char firstchar=firstNonRepeating(str);
        System.out.println("The first non repeating character is "+firstchar);
        input.close();
        
    }
    
}
