import java.util.*;

class IsAnagram {

    static int isAnag(String f, String s) {
        int count[] = new int[256];
        Arrays.fill(count, 0);
        int i = 0;
        for (i = 0; i < f.length() && i < s.length(); i++) {
            count[f.charAt(i)]++;
            count[s.charAt(i)]--;
        }

        if (i < f.length() || i < s.length())
            return 0;

        for (i = 0; i < 256; i++)
            if (count[i] != 0)
                return 0;
        return 1;
    }

    static public void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.next();

        System.out.println(isAnag(first, second));

    }

}