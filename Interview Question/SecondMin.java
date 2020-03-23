import java.io.*;
import java.util.*;

public class SecondMin {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int arr[] = { 11, 211, 5, 777777, 78, 1784 };

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("No Second Min");
        } else {
            System.out.println("Second Min " + second);
        }
        sc.close();
    }
}