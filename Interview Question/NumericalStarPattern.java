import java.util.*;

public class NumericalStarPattern {

	static void printIt(int k) {
		for(int i=k;i>0;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}

			for(int j=0;j<(k-i)*2;j++) {
				System.out.print("*");
			}

			for(int j=i;j>=1;j--) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);

        printIt(sc.nextInt());
    }
}