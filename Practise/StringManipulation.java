public class StringManipulation {

    public static void main(String[] args) {
        //String literals
        String str1="Anjan";

        //Using new keyword
        String str2=new String("Anjan");

        //using character array
        char[] str3={'N','E','P','A','L'};
      
        //comparing the strings using == and .eqauls()

        if(str1==str2){
            System.out.println("str1 and str2 is  equal and stored in same memory address");

        }
        else{
            System.err.println("str1 and str2  are not equal(== compares the memory address)");
        }
        if (str1.equals(str2)){
            System.out.println("str1 and str2 are equal(.equals()compares the actual value)");
        }
        else{
        System.err.println("str1 and str2 are not equal");}



    }
}