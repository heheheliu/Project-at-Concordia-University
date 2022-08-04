public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int left = 0, right = 0;
        while(right<len){
           if(nums[right] != val){
               nums[left] = nums[right];
               ++left;

           }
           ++right;
        }
        return left;

    }
}
