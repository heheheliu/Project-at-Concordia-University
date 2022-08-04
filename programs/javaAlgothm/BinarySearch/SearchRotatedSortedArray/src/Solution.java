import java.util.Arrays;

public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return -1;
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int peakIndex = searchPeakIndex(nums);
        int left = 0;
        int right = nums.length-1;
        if(peakIndex >=0){
            if(target >= nums[left]){
                return binarySearch(nums, target, left, peakIndex);
            }
            else{
                return binarySearch(nums, target, peakIndex + 1, right);
            }
        }
        return -1;
    }

    public int searchPeakIndex(int[] nums){

        int left = 0;
        int right = nums.length-1;
        if(nums[left] < nums[right]) return right;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[mid+1]) return mid;
            else if(nums[left] <= nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public int binarySearch(int[] nums, int target, int left, int right){
        while(left <= right){
            int mid = left + (right - left)/2;
            if (target == nums[mid]){
                return mid;
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;

    }
}
