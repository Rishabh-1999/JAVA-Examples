import java.io.*;
import java.util.*;
import java.lang.*;

public class Filereaderprogram{
    public static void main(String agrs[]) {
        try {
            FileReader fr=new FileReader("Addition.java");
            BufferedReader br = new BufferedReader(fr);
            String a=br.readLine();

            while(a!=null) {
                System.out.println(a);
                a=br.readLine();
            }
            br.close();
        }catch(Exception e) {}
    }
}