import java.util.Arrays;

public class Solution {
    public static int missingNumber(int[] nums) {

        Arrays.sort(nums);
        int m = 0;
        for(int i=0; i<nums.length;i++){
            if(nums[i] != m){
                return m;
            }
            m++;
        }
        return m;
    }
    public static int missingNumber_2(int[] nums) {
        int[] n = new int[nums.length+1];
        Arrays.fill(n,0);
        for(int i = 0; i < nums.length; i++){
            n[nums[i]]++;
        }
        for(int i = 0; i < n.length; i++){
            if(n[i]==0){
                return i;
            }
        }
        return n[n.length-1];
    }


    public static void main(String[] args) {
        int[] nums ={1};
        System.out.println(missingNumber(nums));
    }
}
