import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IPvalidating {

    public static void main(String[] args)throws IOException
    {
        Scanner sc =new Scanner(System.in);
        
        StringTokenizer st;
        
      String line;                                           // variable to store IP-addresses
      int N = sc.nextInt();             // variable to store number of lines
                 
            
      for(int i=0;i<N;++i)
      {
        line="";                // initializing with empty
        line = sc.next();   // read input
      
        st = new StringTokenizer(line,"."); // ipv4
        
        int val=0;
        boolean ipv4 = false,ipv6 = false;   // variables to indicate whether IP-address is IPv4 or IPv6
        
        while(st.hasMoreTokens())
        {
            try
            {
            val=Integer.parseInt(st.nextToken());   // computing values of every octect
            
            if(val>=0 && val<=255)                  // if value is in range then continue otherwise break
                ipv4=true;
            else
            {
                ipv4=false;
                break;
            }
            }catch(Exception e){
            break;}
        }
        
        if(!ipv4)
        {
            String str = "";
            
            st = new StringTokenizer(line,":"); // ipv6
            while(st.hasMoreTokens())
            {
                str = st.nextToken();
                if(str.matches("^[0-9a-f]{1,4}"))
                    ipv6 = true;
                else
                {
                    ipv6 = false;
                    break;
                }
                    
            }
            
            // displaying appropriate output
            
            if(ipv6)
                System.out.println("IPv6");
            else
                System.out.println("Neither");
        }
        else
        {
            System.out.println("IPv4");
        }
        
      }
    }
}