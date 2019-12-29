import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TrappingWater {

    static int findWater(int arr[]) {
        int result=0;
        int left_max=0,right_max=0;

        int lo=0,hi=arr.length-1;

        while(lo <= hi) {
            if(arr[lo] < arr[hi]) {
                if(arr[lo] > left_max) {
                    left_max=arr[lo];
                }
                else {
                    result+=left_max-arr[lo];
                    lo++;
                }
            } else {
                if(arr[hi] > right_max) {
                    right_max=arr[hi];
                } else {
                    result+=right_max-arr[hi];
                    hi--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args)throws IOException
    {
        Scanner sc =new Scanner(System.in);
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; 
        System.out.println("Water "+findWater(arr)); 
    }
}