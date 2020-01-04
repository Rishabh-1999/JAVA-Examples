import java.io.*;
import java.util.*;

public class SeatingArrangement {

    static int printIt(int arr[]) {
        int count = 0;
        int temp[] = new int[arr[0] + 1];
        for (int i = 0; i < arr.length; i++)
            temp[arr[i]] = 1;

        for (int i = 1; i <= arr[0]; i++) {
            if (temp[i] == 0 && i % 2 != 0) {
                if (i + 1 <= arr[0] && temp[i + 1] == 0)
                    count++;
                if (i + 2 <= arr[0] && temp[i + 2] == 0)
                    count++;
            } else if (temp[i] == 0 && i % 2 == 0) {
                if (i + 2 <= arr[0] && temp[i + 2] == 0)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int arr[] = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(printIt(arr));
    }
}