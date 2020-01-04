import java.io.*;
import java.util.*;

public class CharacterCount {

    static String printIt(String str) {
        String ans = new String();
        int hash[] = new int[200];
        Arrays.fill(hash, 0);
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i) - 'A']++;
        }
        ans += hash[str.charAt(0) - 'A'];
        ans += str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                ans += hash[str.charAt(i) - 'A'];
                ans += str.charAt(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(printIt(str));
    }
}