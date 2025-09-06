import java.util.Scanner;
public class TwoDarrary {
    public static char[] unquieCharacters(String str){
        char[] tempunique=new char[str.length()];
        int uniqueIndex=0;
        for(int i=0;i<str.length();i++){
            int count=0;
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    count++;
                }
            }
            if(count==0){
                tempunique[uniqueIndex]=str.charAt(i);
                uniqueIndex++;
            }
        }
        char[] unique=new char[uniqueIndex];
        for(int i=0;i<uniqueIndex;i++){
            unique[i]=tempunique[i];
            
        }
        return unique;
    }
    public static void freq2D(String str){
        int[] freq=new int[256];
        
        for(int i=0;i<str.length();i++){
       freq[str.charAt(i)]++;
 }

    char[] unique=unquieCharacters(str);
    System.out.println(unique[0]);
    int[][] frequency2D=new int[unique.length][2];
    for(int i=0;i<unique.length;i++){
        frequency2D[i][0]=unique[i];
        frequency2D[i][1]=freq[unique[i]];
    }
     //Displaying the result
    for(int i=0;i<unique.length;i++){
            System.out.println("The frequency of character "+(char)frequency2D[i][0]+" is "+ frequency2D[i][1]);
    }
    }
     

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the string");
        String str=input.nextLine();
        freq2D(str);
        input.close();
    }
    
}