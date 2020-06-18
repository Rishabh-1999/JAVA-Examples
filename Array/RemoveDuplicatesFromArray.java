import java.util.*;

public class RemoveDuplicatesFromArray {

    static void removeDuplicate(ArrayList<Integer> s) {
        if(s.size()==0)
            return;
        for(int i=1;i<s.size();) {
            if(s.get(i)==s.get(i-1))
                s.remove(i-1);
            else
                i++;
        }
    }

    static void printAll(ArrayList<Integer> s) {
        for(int i=0;i<s.size();i++) {
            System.out.print(s.get(i)+" ");
        }
    }

    public static void main(String agrs[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int data;
        ArrayList<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data = sc.nextInt();
            s.add(data);
        }

        removeDuplicate(s);
        printAll(s);
    }
}