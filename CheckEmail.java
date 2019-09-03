import java.io.*;
import java.util.*;
import java.lang.*;

public class CheckEmail
{
	public static void main(String[] agrs)
	{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter email id : ");
        String str=sc.next();
        if(str.matches("^(.+)@(.+)\\.(.+)"))
            System.out.println("Valid");
        else
          System.out.println("Invalid");
	}
}