import java.util.*;
import java.*;

/* Question and Answer
https://www.geeksforgeeks.org/maximum-path-sum-triangle/
*/
public class MaximumPathSumInTriangle {

    static int n;
    static int m;

    static int minPath(int a[][], int m, int n) {

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                a[i][j] += Math.max(a[i + 1][j], a[i + 1][j + 1]);
            }
        }
        return a[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int a[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println(minPath(a, n, m));
    }
}