public class StringBuiltInMethods{
 
    public static void main(String[] args) {
        String sampleText="  Java programming is Fun and  Challenging!  ";
        // Displaying orginal  string length including spaces
        System.out.println("Original string length including spaces is "+sampleText.length());

        //removing leading and trailing spaces , showing new length
         sampleText=sampleText.trim();
        System.out.println("New length  after removing leading and trailing zeros: "+sampleText.length());



        //displaying the character at index 5
        System.out.println("Character at index 5 is "+sampleText.charAt(5));

        // Extracting the substring programming form the text
        System.out.println(sampleText.substring(5,16 ));

        //finding the index of the word
        System.out.println(sampleText.indexOf("Fun"));

        //checking if the string contains java  
        if(sampleText.contains("Java")){
            System.out.println(sampleText+" contains Java");
        }
        else{
            System.out.println(sampleText+" donot contain Java");
        }

        //checking if the string starts with java
        if(sampleText.startsWith("Java")){
            System.out.println(sampleText+" starts with Java");
        }
        else{
            System.out.println(sampleText+" does not starts with Java");
        }

        //Checking if the string ends with ! sign
        if(sampleText.endsWith("!")){
            System.out.println(sampleText+" ends with ! sign ");
        }
        else{
            System.out.println(sampleText+" does not ends with ! sign");
        }

        //converting the entire string to uppercase
        System.out.println(sampleText+" in uppercase : "+sampleText.toUpperCase());

        //Converting the entire string  to lowercase
        System.out.println(sampleText+" in lowercase :"+sampleText.toLowerCase());

        //methods to count vowel
        System.out.println("Number of vowels in the string is "+counvowels(sampleText));
          
        //mmethods to find the occurence of text a
        findAllOccurrences(sampleText,'a');
    

    }

    public static int counvowels(String text){
        int count=0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)=='a'||text.charAt(i)=='e'||text.charAt(i)=='i'||text.charAt(i)=='o'||
            text.charAt(i)=='u'||text.charAt(i)=='A'||text.charAt(i)=='E'||text.charAt(i)=='I'||text.charAt(i)=='O'||text.charAt(i)=='U'){
count++;
            }
        }
        return count;

    }

    public static void findAllOccurrences(String text,char target){
        int count=0;
        
        for(int i=0;i<text.length();i++){
            if(target==text.charAt(i)){
                count++;
                System.out.println(target+" occurs at index"+i);
                
            }
            
        }
        if(count==0){
            System.out.println(target+" cannot be found");
        }

    }

}