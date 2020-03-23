import java.io.*;
import java.util.*;

public class RemoveContinousNCharacterfromString {

    static String printIt(String str, int n) {

        StringBuffer sb = new StringBuffer();

        sb.append(str);

        for (int i = 0; i < sb.length(); i++) {

            int c = 0;
            for (int j = i; j < sb.length(); j++) {

                if (sb.charAt(i) == sb.charAt(j)) {
                    // System.out.println(i + " " + j);
                    c++;
                    if (c == n && (j == sb.length() || sb.charAt(j) != sb.charAt(j + 1))) {
                        // System.out.println("deleted" + (j - n + 1) + " " + j + 1);
                        sb.delete(j - n + 1, j + 1);
                    }
                } else
                    c = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int n = sc.nextInt();

        System.out.println(printIt(str, n));
        sc.close();
    }
}