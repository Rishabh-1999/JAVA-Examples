import java.io.*;
import java.util.*;

public class CharcterRemoval {

    static int printIt(String arr[]) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {

            int count = 0;
            int comp = 0, main = 0;
            while (arr[i].length() > comp && arr[0].length() > main) {
                if (((arr[i].charAt(comp)) == (arr[0].charAt(main)))) {
                    main++;
                    comp++;
                } else {
                    main++;
                    count++;
                }
            }
            if (min > count && comp == arr[i].length()) {
                min = arr[0].length() - arr[i].length();
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // TestCase 1 : ["baseball","b","hello","ball"] -> 4
        // TestCase 2 : ["worlcde","hello","work","human","world"] -> 2
        // TestCase 3 : ["apbpleeef","a","ab","abc","zzz","gdf"] -> 8
        int length = sc.nextInt();
        String arr[] = new String[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.next();
        }
        System.out.println(printIt(arr));
        sc.close();
    }
}