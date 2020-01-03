import java.util.*;

public class FindMultiplyOf3 {

    static int MAX_VALUE = 20;

    static int acculmate(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }

    static void sortArrayUsingCounts(int arr[]) {
        int[] count = new int[MAX_VALUE];

        for (int i = 0; i < arr.length; i++)
            count[arr[i]]++;

        int index = 0;
        for (int i = 0; i < MAX_VALUE; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    static void removePrint(int arr[], int num1, int num2) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i != num1 && i != num2)
                System.out.print(arr[i]);
        }
        System.out.println();
    }

    static boolean largest3Multiple(int arr[]) {
        int sum = acculmate(arr);

        if (sum % 3 == 0)
            return true;

        sortArrayUsingCounts(arr);

        int remainder = sum % 3;

        if (remainder == 1) {
            int[] rem2 = new int[2];
            rem2[0] = -1;
            rem2[1] = -1;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 3 == 1) {
                    removePrint(arr, i, -1);
                    return true;
                }
                if (arr[i] % 3 == 2) {
                    if (rem2[0] == -1)
                        rem2[0] = i;
                    else if (rem2[1] == -1)
                        rem2[1] = i;
                }
            }
            if (rem2[0] == -1 && rem2[1] == -1) {
                removePrint(arr, rem2[0], rem2[1]);
                return true;
            }
        } else if (remainder == 2) {
            int[] rem1 = new int[2];
            rem1[0] = -1;
            rem1[1] = -1;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 3 == 2) {
                    removePrint(arr, i, -1);
                    return true;
                }
                if (arr[i] % 3 == 1) {
                    if (rem1[0] == -1)
                        rem1[0] = i;
                    else if (rem1[1] == -1)
                        rem1[1] = i;
                }
            }
            if (rem1[0] != -1 && rem1[1] != -1) {
                removePrint(arr, rem1[0], rem1[1]);
                return true;
            }
        }
        System.out.println("Not Possible");
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(largest3Multiple(arr));
    }
}