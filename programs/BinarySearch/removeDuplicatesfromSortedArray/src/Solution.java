public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int count = 0;
        int k = 1;
        for(int i = 1; i<len;i++){
            if(nums[i] == nums[i-1]){
                count++;
                continue;
            }
            nums[i - count] = nums[i];
            k++;

        }
        return k;

    }
}
