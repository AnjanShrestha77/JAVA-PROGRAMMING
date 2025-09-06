import java.util.Scanner;
public class UnquieCharacter {
    public static int findLength(String str){
        int i=0;
      try{
        while(true){

            str.charAt(i);
            i++;
        }
      }
      catch(IndexOutOfBoundsException e)
      {
      }
      return i;
    }
    
    public static char[] findUnique(String str){
        int len=findLength(str);
        char[] uniqueArray=new char[len];
        int uniqueindex=0;
        for(int i=0;i<len;i++){
            int count=0;
            for(int j=0;j<len;j++){
                if(str.charAt(i)==str.charAt(j)){
                    count++;
                }
            }
            if (count==1){
                uniqueArray[uniqueindex]=str.charAt(i);
                uniqueindex++;
            }
        }
        return uniqueArray;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the string");
        String str=input.nextLine();
        char[] result=findUnique(str);
     System.out.println("Unique characters in the string is ");
     for(char re:result){
        System.out.println(re);
     }
     input.close();
    }
}
