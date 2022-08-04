public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        while(right < len){
            if(nums[right] != 0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }



    public void moveZeroes_2(int[] nums) {
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == 0){
                count++;
                continue;
            }
            //减去前面有多少0
            nums[i - count] = nums[i];
        }
        for(int i = len - count; i < len; i++){
            nums[i] = 0;
        }
    }
    public void moveZeroes_3(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        for(int i = index; i < nums.length; i++){
            nums[i] = 0;
        }
    }


}
