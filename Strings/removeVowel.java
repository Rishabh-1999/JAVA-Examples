import java.io.*;
import java.util.*;
import java.lang.*;

public class removeVowel
{
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Text :");
        String s=sc.nextLine();
        StringBuffer sb=new StringBuffer(s);
        int i=0;
        while(i<sb.length()) {
            if(sb.charAt(i)=='A' || sb.charAt(i)=='a' 
            || sb.charAt(i)=='E' || sb.charAt(i)=='e' 
            || sb.charAt(i)=='I' || sb.charAt(i)=='i' 
            || sb.charAt(i)=='O' || sb.charAt(i)=='o' 
            || sb.charAt(i)=='U' || sb.charAt(i)=='u')
                sb.deleteCharAt(i);
            else
                i++;
        }
        System.out.println("Output : "+sb.toString());
    }
}