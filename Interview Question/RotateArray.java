import java.io.*;
import java.util.*;

public class RotateArray {

    static void displayArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void rotateArray1(int arr[], int d, int n) // Using Same Array
    {

        int temp[] = new int[n - d];

        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for (int j = 0, i = d; i < n && j < n; i++, j++) {
            arr[j] = arr[i];
        }

        for (int j = 0, i = n - d; i < n; i++, j++) {
            arr[i] = temp[j];
        }

        displayArray(arr);
    }

    static void rotateArray2(int arr[], int d, int n) // Using Same Array
    {

        int temp[] = new int[n];
        int j = 0;
        for (int i = d; i < n && j < n; i++, j++) {
            temp[j] = arr[i];
        }

        for (int i = 0; i < d; i++, j++) {
            temp[j] = arr[i];
        }

        displayArray(temp);
    }

    static void rotateArray3(int arr[], int d, int n) {
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
        displayArray(arr);
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int arr[] = { 11, 211, 5, 777777, 78, 1784 };

        rotateArray1(arr, 2, arr.length);
        displayArray(arr);
        rotateArray2(arr, 2, arr.length);
        rotateArray3(arr, 2, arr.length);
        sc.close();
    }
}