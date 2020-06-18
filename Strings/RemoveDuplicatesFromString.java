import java.util.*;

public class RemoveDuplicatesFromString {

    static String removeDuplicate(ArrayList<String> s) {
        for(int i=1;i<s.size();) {
                if((s.get(i)).equals(s.get(i-1)))
                    s.remove(i);
                else
                    i++;
        }

        String ans=new String();
        for(int i=0;i<s.size();i++) {
            ans+=s.get(i);
            if(i<s.size()-1)
                ans+=",";
        }

        return ans;
    }

    public static void main(String agrs[]) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();

        String c[]=str.split(",");
        ArrayList<String> s=new ArrayList<>(Arrays.asList(c));
        System.out.print(removeDuplicate(s));
    }
}