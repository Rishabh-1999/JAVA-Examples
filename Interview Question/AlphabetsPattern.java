import java.util.*;

public class AlphabetsPattern {

	static void printIt(int k) {
		for (int i = k; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print((char) (j + 'A'));
			}
			for (int y = 0; y < (k - i) * 2 - 1; y++) {
				System.out.print(" ");
			}

			int y;
			if (i == k) {
				y = i - 1;
			} else
				y = i;

			for (; y >= 0; y--) {
				System.out.print((char) (y + 'A'));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		printIt(sc.nextInt());
	}
}