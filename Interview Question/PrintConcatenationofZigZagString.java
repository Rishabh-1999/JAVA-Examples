import java.io.*;
import java.util.*;

public class PrintConcatenationofZigZagString {

    static String printIt(String str, int n) {

        if (n == 1) {
            return str;
        }

        char str1[] = str.toCharArray();

        int len = str.length();

        String arr[] = new String[n];

        Arrays.fill(arr, "");

        int row = 0;
        boolean down = true;

        for (int i = 0; i < len; i++) {

            arr[row] += (str1[i]);

            if (row == n - 1)
                down = false;
            else if (row == 0)
                down = true;

            if (down)
                row++;
            else
                row--;
        }

        String retStr = new String();

        for (int i = 0; i < n; i++) {
            retStr += arr[i];
        }
        return retStr;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int n = sc.nextInt();

        System.out.println(printIt(str, n));
    }
}