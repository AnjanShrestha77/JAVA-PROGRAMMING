import java.util.Scanner;
public class StringManipulation {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a sentence with mixed formatting");
        String sentence=scanner.nextLine();
        //removing extra spaces from sentence
         sentence=sentence.trim();
         System.out.println("After removing the spaces"+sentence);
          
         // replacing all the spaces with underscore
         sentence=sentence.replace(" ", "_");
         System.out.println("After replacing spaces with  underscore"+sentence);

         //removing all the digits using regex
         sentence=sentence.replaceAll("\\d", "");
         System.out.println("After removing all the digits"+sentence);

         //spliting into word array 
         String[] WordArray=sentence.split("_");
       System.out.println("words array");
       for(String word:WordArray){
        System.out.println(word);
       }

       //rejoining using | 
       sentence=String.join("|",WordArray);
       System.out.println("Sentence after joining with |"+sentence);

       //






    }
    public static String  removePunctuation( String text){
        if (text==null)return null;
        StringBuilder sb=new StringBuilder();
        for(char c:text.toCharArray()){
            if(Character.isLetterOrDigit(c)||Character.isWhitespace(c)){
                sb.append(c);
            }

        }
        return sb.toString();
    }

    public static String capitalizeWords(String text){
        StringBuilder sb=new StringBuilder();
        for(char c:text.toCharArray()){
            if(c>97&&c<122){
                sb.append(c-32);
            }
            else
            sb.append(c);
        }
        return sb.toString();
        
    }

    public static String reverseWordOrder(String text){
        StringBuilder sb=new StringBuilder();
        String[] wordArray=text.split("|");
        for(int i=wordArray.length-1;i>=0;i--){
            sb.append(wordArray[i]);
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();

    }
    public static void countWordFrequency(String text){
        String[] Words=text.split("|");
        int freq[]=new int[Words.length];
        for(int i=0;i<=Words.length-2;i++){
            for(int j=i+1;j<=Words.length-1;i++){
                if(Words[i]==Words[j]){
                    freq[i]++;
                }
            }

            

        }
    }


}
