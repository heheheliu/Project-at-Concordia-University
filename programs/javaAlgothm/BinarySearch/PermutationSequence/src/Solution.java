import java.util.ArrayList;
import java.util.List;

public class Solution {
   static int[] fact;
    public static String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        fact(n);
        k = k -1;
        for(int i = n - 1; i>=0; i--){
            int index = k / fact[i];
            sb.append(nums.remove(index));
            k = k % fact[i];

        }
        return sb.toString();


    }

    public static void fact(int n){
        fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++)
        {
            fact[i] = fact[i-1] * i;
        }
    }
    public static void main(String[] args) {
        System.out.println(getPermutation(3,3));

    }
}
