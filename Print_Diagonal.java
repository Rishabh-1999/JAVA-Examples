import java.util.*;
public class Print_Diagonal {
	public static void main(String agrs[])
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int a[][]=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		int p=1,in=0,i=0;
		//for(int i=in;i<p;i--)
		/*
		while(true)
		{
			i=in;
			for(int j=0;j<p && i>=0;j++,i--)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println(" ");
			in++;
			p++;
			if(in==4 || p==4)
				break;
		}*/
		int out=1;
		in=n-1;
		p=n-1;
		while(true)
		{
			i=in;
			for(int j=out;j<n && i>0;j++,i--)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println(" ");
			p--;
			out++;
		}
	}
}
