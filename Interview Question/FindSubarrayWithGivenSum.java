import java.util.*;

/* Question and Answer

*/

public class FindSubarrayWithGivenSum {

    static void subarrayIs1(int a[], int n, int sum) {
        int curr_sum = 0;

        for (int i = 0; i < n; i++) {
            curr_sum = a[i];

            for (int j = i + 1; j <= n; j++) {
                if (curr_sum == sum) {
                    int p = j - 1;
                    System.out.println("Sum found between indexes " + i + " and " + p);
                    return;
                }

                if (curr_sum > sum || j == n)
                    break;

                curr_sum = curr_sum + a[j];
            }
        }

        System.out.println("No Subarray Found");
    }

    static void subarrayIs2(int a[], int n, int sum) {
        int curr_sum = a[0], start = 0;

        for (int i = 1; i <= n; i++) {
            while (curr_sum > sum && start < i - 1) {
                curr_sum = curr_sum - a[start];
                start++;
            }

            if (curr_sum == sum) {
                System.out.println("Sum found between indexes" + start + " and " + (i - 1));
                return;
            }

            if (i < n)
                curr_sum = curr_sum + a[i];
        }

        System.out.println("No array found");
    }

    static void subarrayIs3(int a[], int n, int sum) {
        int curr_sum = 0;
        int start = 0;
        int end = -1;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            curr_sum = curr_sum + a[i];

            if (curr_sum == sum) {
                start = 0;
                end = i;
                break;
            }

            if (hashMap.containsKey(curr_sum - sum)) {
                start = hashMap.get(curr_sum - sum) + 1;
                end = i;
                break;
            }
            hashMap.put(curr_sum, i);
        }

        if (end == -1) {
            System.out.println("No subarray found");
        } else {
            System.out.println("Sum found between indexes" + start + " to " + end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int sum = sc.nextInt();

        subarrayIs1(a, n, sum); // Navie Method
        subarrayIs2(a, n, sum); // Optimized method
        subarrayIs3(a, n, sum); // Capable of accepting negative No
        sc.close();
    }
}