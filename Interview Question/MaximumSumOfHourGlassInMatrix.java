import java.util.*;

class MaximumSumOfHourGlassInMatrix {

    static int findMaxSum(int[][] mat, int r, int c) {
        if (r < 3 || c < 3)
            return -1;

        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < r - 2; i++) {
            for (int j = 0; j < c - 2; j++) {
                int sum = (mat[i][j] + mat[i][j + 1] + mat[i][j + 2]) + (mat[i + 1][j + 1])
                        + (mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2]);

                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }

    static public void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        // TestCase 1 : { { 1, 2, 3, 0, 0 }, { 0, 0, 0, 0, 0 }, { 2, 1, 4, 0, 0 }, { 0,
        // 0, 0, 0, 0 }, { 1, 1, 0, 1, 0 } }

        int[][] mat = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int res = findMaxSum(mat, r, c);
        if (res == -1)
            System.out.println("Not possible");
        else
            System.out.println("Maximum sum of hour glass = " + res);
    }

}