import java.util.Scanner;
public class FreqencyOfChar {

    public static void frequency(String str){
        int[] freq=new int[256];
         char[] character=new char[str.length()];
        int charindex=0;
        //calculating the frequency for each characters
        for(int i=0;i<str.length();i++){
            freq[str.charAt(i)]++;
            if (freq[str.charAt(i)]==1){
                character[charindex]=str.charAt(i);
                charindex++;
            }
            
        }
        
        for(int i=0;i<charindex;i++){
             System.out.println("Frequency of character "+character[i]+" is "+freq[character[i]]);
        }
       
    }
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Enter a string");
        String str=input.nextLine();
        frequency(str);
      
        input.close();
    }
    
}
