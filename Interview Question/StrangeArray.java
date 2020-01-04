import java.util.*;

public class StrangeArray {

	static void printIt(int arr[], int k, int n) {

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {

			int b[] = arr.clone();

			arr[i] = arr[i] + k;

			for (int j = 0; j < n; j++)
				if (i != j)
					b[j] = b[j] - k;

			int c = 0;
			for (int j = 0; j < n; j++) {
				c = 0;
				for (int o = 0; o < n; o++) {
					if (b[j] == b[o]) {
						c++;
					}
					if (c > max)
						max = c;
				}
			}
		}
		System.out.println("Answer :" + max);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int k = sc.nextInt();

		printIt(arr, k, n);
		sc.close();
	}
}