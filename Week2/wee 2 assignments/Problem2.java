import java.util.*;

public class Problem2 {
    public static int[] analyze(String pass){
        int upper=0,lower=0,digit=0,special=0;
        for(int i=0;i<pass.length();i++){
            char c=pass.charAt(i);
            if(c>='A'&&c<='Z') upper++;
            else if(c>='a'&&c<='z') lower++;
            else if(c>='0'&&c<='9') digit++;
            else special++;
        }
        return new int[]{upper,lower,digit,special};
    }

    public static int score(String pass){
        int[] a=analyze(pass);
        int s=0;
        if(pass.length()>8) s+=(pass.length()-8)*2;
        if(a[0]>0) s+=10;
        if(a[1]>0) s+=10;
        if(a[2]>0) s+=10;
        if(a[3]>0) s+=10;
        String[] weak={"123","abc","qwerty"};
        for(String w:weak) if(pass.contains(w)) s-=10;
        return s;
    }

    public static String strength(int s){
        if(s<=20) return "Weak";
        if(s<=50) return "Medium";
        return "Strong";
    }

    public static String generate(int len){
        String up="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lo="abcdefghijklmnopqrstuvwxyz";
        String di="0123456789";
        String sp="!@#$%^&*";
        String all=up+lo+di+sp;
        Random r=new Random();
        StringBuilder sb=new StringBuilder();
        sb.append(up.charAt(r.nextInt(up.length())));
        sb.append(lo.charAt(r.nextInt(lo.length())));
        sb.append(di.charAt(r.nextInt(di.length())));
        sb.append(sp.charAt(r.nextInt(sp.length())));
        for(int i=4;i<len;i++) sb.append(all.charAt(r.nextInt(all.length())));
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] passes=sc.nextLine().split(" ");
        System.out.println("Password\tLen\tUpper\tLower\tDigit\tSpecial\tScore\tStrength");
        for(String p:passes){
            int[] a=analyze(p);
            int s=score(p);
            System.out.println(p+"\t"+p.length()+"\t"+a[0]+"\t"+a[1]+"\t"+a[2]+"\t"+a[3]+"\t"+s+"\t"+strength(s));
        }
        System.out.println("Generated strong password: "+generate(12));
    }
}
