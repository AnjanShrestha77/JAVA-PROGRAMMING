import java.util.Scanner;

public class Problem4 {
    static boolean valid(String exp){
        int p=0;
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(!((c>='0'&&c<='9')||c=='+'||c=='-'||c=='*'||c=='/'||c=='('||c==')'||c==' '))
                return false;
            if(c=='(') p++;
            if(c==')') p--;
            if(p<0) return false;
        }
        return p==0;
    }

    static int evaluate(String exp){
        while(exp.indexOf("(")!=-1){
            int end=exp.indexOf(")");
            int start=exp.lastIndexOf("(",end);
            int val=evaluate(exp.substring(start+1,end));
            exp=exp.substring(0,start)+val+exp.substring(end+1);
        }
        return calc(exp);
    }

    static int calc(String exp){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<exp.length();i++)
            if(exp.charAt(i)!=' ') sb.append(exp.charAt(i));
        exp=sb.toString();
        int n=0;String num="";char[] ops=new char[exp.length()];int[] vals=new int[exp.length()];int oi=0,vi=0;
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(c>='0'&&c<='9') num+=c;
            else{
                vals[vi++]=Integer.parseInt(num);num="";
                ops[oi++]=c;
            }
        }
        vals[vi++]=Integer.parseInt(num);
        for(int i=0;i<oi;i++){
            if(ops[i]=='*'||ops[i]=='/'){
                if(ops[i]=='*') vals[i]=vals[i]*vals[i+1];
                else vals[i]=vals[i]/vals[i+1];
                for(int j=i+1;j<vi-1;j++) vals[j]=vals[j+1];
                for(int j=i;j<oi-1;j++) ops[j]=ops[j+1];
                vi--;oi--;i--;
            }
        }
        int res=vals[0];
        for(int i=0;i<oi;i++){
            if(ops[i]=='+') res+=vals[i+1];
            else res-=vals[i+1];
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String exp=sc.nextLine();
        if(valid(exp)) System.out.println(evaluate(exp));
        else System.out.println("Invalid Expression");
    }
}
