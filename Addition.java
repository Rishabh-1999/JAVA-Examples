import java.io.*;
import java.util.*;
import java.lang.*;

public class Addition{
    public static void main(String agrs[]) {
        int a,b,c;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
        String x =br.readLine();
        a=Integer.parseInt(x);
        String x1 =br.readLine();
        b=Integer.parseInt(x1);
        System.out.print(a+" "+b);
        }catch(Exception e) {

        }
    }
}