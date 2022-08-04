public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if(nums[l] <= nums[r]) return nums[0];
        while(l <= r){
            int mid = l + ( r - l )/2;
            if(nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            else if(nums[l] <= nums[mid]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return -1;
    }
    public int findMin_duplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] < nums[r]){
                r = mid;
            }
            else if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            else{
                r = r - 1;
            }
        }
        return nums[l];
    }
}
