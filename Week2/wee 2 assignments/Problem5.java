import java.util.Scanner;

public class Problem5 {
    static String[][] parse(String data){
        String[][] table=new String[50][50];
        int r=0,c=0,start=0;boolean inq=false;
        for(int i=0;i<data.length();i++){
            char ch=data.charAt(i);
            if(ch=='"') inq=!inq;
            else if(ch==','&&!inq){
                table[r][c++]=data.substring(start,i).trim();start=i+1;
            }
            else if(ch=='\n'&&!inq){
                table[r][c]=data.substring(start,i).trim();r++;c=0;start=i+1;
            }
        }
        table[r][c]=data.substring(start).trim();
        return table;
    }

    static void display(String[][] t){
        for(int i=0;i<t.length&&t[i][0]!=null;i++){
            for(int j=0;t[i][j]!=null;j++){
                System.out.print(t[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        while(sc.hasNextLine()){
            String line=sc.nextLine();
            if(line.equals("")) break;
            sb.append(line).append("\n");
        }
        String[][] t=parse(sb.toString());
        display(t);
    }
}
