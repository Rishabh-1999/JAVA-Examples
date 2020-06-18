import java.io.*;
import java.util.*;
import java.lang.*;

public class RemoveExtraSpace
{
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Text :");
        String s=sc.nextLine();
        StringBuffer sb=new StringBuffer(s);
        int i=0;
        while(i<sb.length()) {
            if(sb.charAt(i)==' ' && sb.charAt(i+1)==' ')
                sb.deleteCharAt(i);
            else
                i++;
        }
        System.out.println("Output : "+sb.toString());
    }
}