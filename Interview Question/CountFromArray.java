import java.io.*;
import java.util.*;

public class CountFromArray {

    static int printIt(int sum) {
        int arr[] = new int[5];
        arr[0] = 1;
        arr[1] = 5;
        arr[2] = 7;
        arr[3] = 9;
        arr[4] = 11;
        int c = -1;
        for (int i = 4; i >= 1; i--) {
            int num = sum;
            int l = 1;
            num -= arr[i];
            for (int j = i - 1; j >= 0;) {
                if (arr[j] <= num) {
                    l++;
                    num -= arr[j];
                    if (num == 0)
                        break;
                } else
                    j--;
            }
            if (c == -1 && num == 0)
                c = l;
            else if (l < c && num == 0)
                c = l;
        }
        return c;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        System.out.println(printIt(num));
    }
}