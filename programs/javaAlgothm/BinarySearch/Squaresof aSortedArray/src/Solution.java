import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i =0; i< nums.length;i++){
            nums[i] = nums[i]*nums[i];

        }
        Arrays.sort(nums);
        return nums;


    }
    public int[] sortedSquares_2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for(int i = 0, j = len-1, pos = len-1; i <= j && pos >= 0; pos--){
            if(nums[i]*nums[i] >= nums[j]*nums[j]){
                ans[pos] = nums[i]*nums[i];
                ++i;
            }else{
                ans[pos] = nums[j]*nums[j];
                --j;
            }
        }
        return ans;
    }
}
