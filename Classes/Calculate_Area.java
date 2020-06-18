import java.util.*;
class Area
{
	int r,l,b,a;
	double area;
	Area()
	{
		r=l=b=a=0;
		area=0;
	}
	Area(int i)
	{
		a=i;
	}
	Area(int m,int m1)
	{
		l=m;
		b=m1;
	}
	Area(float m)
	{
		r=(int)m;
	}
	void calarea(int m)
	{
		a=m*m;
	}
	void calarea(int m,int m1)
	{
		l=m;
		b=m1;
		area=l*b;
	}
	void calarea(float m)
	{
		r=(int) m;
		area=Math.PI*r*r;
	}
	void display()
	{
		System.out.println("\nin");
	}
}
public class Calculate_Area {
	public static void main(String agrs[]) {
		Area a;
		float abc=(float) (1.1+2.3+6.9);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for Square , 2 for Rectangle , 3 for Circle");
		int n =sc.nextInt(),p,o;
		float p1;
		switch(n)
		{
		case 1:
			System.out.println("Enter Input");
			p=sc.nextInt();
			a=new Area(p);
			a.calarea(p);
			a.display();
			break;
		case 2:
			System.out.println("Enter lenght");
			p=sc.nextInt();
			System.out.println("Enter breadth");
			o=sc.nextInt();
			a=new Area(p,o);
			a.calarea(p,o);
			a.display();
			break;
		case 3:
			System.out.println("Enter raduis");
			p1=sc.nextFloat();
			a=new Area(p1);
			a.calarea(p1);
			a.display();
			break;
		}
	}
}
