import java.util.*;

public class Problem3 {
    public static char[] uniqueChars(String text){
        char[] temp=new char[text.length()];
        int count=0;
        for(int i=0;i<text.length();i++){
            char c=text.charAt(i); boolean found=false;
            for(int j=0;j<count;j++) if(temp[j]==c) found=true;
            if(!found) temp[count++]=c;
        }
        char[] res=new char[count];
        for(int i=0;i<count;i++) res[i]=temp[i];
        return res;
    }

    public static int[] freq(String text,char[] chars){
        int[] f=new int[chars.length];
        for(int i=0;i<text.length();i++){
            char c=text.charAt(i);
            for(int j=0;j<chars.length;j++) if(chars[j]==c) f[j]++;
        }
        return f;
    }

    public static String compress(String text,char[] chars,String[] codes){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<text.length();i++){
            char c=text.charAt(i);
            for(int j=0;j<chars.length;j++) if(c==chars[j]) sb.append(codes[j]);
        }
        return sb.toString();
    }

    public static String decompress(String comp,char[] chars,String[] codes){
        StringBuilder sb=new StringBuilder();
        String temp="";
        for(int i=0;i<comp.length();i++){
            temp+=comp.charAt(i);
            for(int j=0;j<codes.length;j++){
                if(temp.equals(codes[j])){sb.append(chars[j]);temp="";}
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        char[] chars=uniqueChars(text);
        int[] f=freq(text,chars);
        String[] codes=new String[chars.length];
        for(int i=0;i<chars.length;i++) codes[i]=Integer.toBinaryString(i+1);
        String comp=compress(text,chars,codes);
        String decomp=decompress(comp,chars,codes);
        System.out.println("Char\tFreq\tCode");
        for(int i=0;i<chars.length;i++) System.out.println(chars[i]+"\t"+f[i]+"\t"+codes[i]);
        System.out.println("Original: "+text);
        System.out.println("Compressed: "+comp);
        System.out.println("Decompressed: "+decomp);
    }
}
