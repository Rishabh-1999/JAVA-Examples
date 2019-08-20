import java.util.*;
import java.lang.Math.*;

public class PallindromeNo
{
    static int is_Pallandrome(int n)
    {
        int dup = n;
        int p=0;
        while(dup>0)
        {
            p = p*10 + dup%10;
            dup/=10;
        }
        if(n==p)
        {return 1;}
        return 0;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
	System.out.println("Enter No For checking Pallinrome");
        int n = scanner.nextInt();
        if(is_Pallandrome(n)==1)
        {
            System.out.println("Yes, given input is pallindrome");
        }
        else
        {
            System.out.println("No, given no is not in pallindrome");
        }
    }
}