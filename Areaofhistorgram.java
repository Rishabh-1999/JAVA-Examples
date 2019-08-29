import java.io.*;
import java.util.*;
import java.lang.*;

public class Areaofhistorgram
{
	public static void main(String[] agrs)
	{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of in array");
        int n=sc.nextInt(),area=0;
        int a[]=new int[n];
        for(int i=0;i<n;i++) {
            System.out.print("Enter : ");
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            int curr=a[i],j=i+1;
            while(j<n && curr<=a[j])
            {
                j++;
            }
            if(area<=(a[i]*(j-i)))
                area=a[i]*(j-i);
        }
        System.out.println(area);
	}
}