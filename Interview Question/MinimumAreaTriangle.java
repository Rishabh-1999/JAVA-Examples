import java.util.*;
import java.*;

/* Question and Answer
https://www.programcreek.com/2016/11/leetcode-minimum-area-rectangle-java/
https://www.geeksforgeeks.org/find-minimum-area-of-rectangle-with-given-set-of-coordinates/
*/
public class MinimumAreaTriangle {

    static int minAreaRect(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });

        HashMap<Integer, HashSet<Integer>> xMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> yMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            HashSet<Integer> setX = xMap.get(x);
            if (setX == null) {
                setX = new HashSet<>();
                xMap.put(x, setX);
            }
            setX.add(y);

            HashSet<Integer> setY = yMap.get(y);
            if (setY == null) {
                setY = new HashSet<>();
                yMap.put(y, setY);
            }
            setY.add(x);
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = 0; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if (xMap.get(x1).contains(y2) && yMap.get(y1).contains(x2)) {
                    int area = Math.abs((x1 - x2) * (y1 - y2));
                    if (area > 0)
                        result = Math.min(result, area);
                }
            }
        }

        if (result == Integer.MAX_VALUE)
            return 0;
        else
            return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println(minAreaRect(a));
    }
}