public class Solution {
    public static  int searchInsert(int[] nums, int target) {

        int len = nums.length;
        if(target<=nums[0]){
            return 0;
        }
        if (target > nums[len-1]) {
            return len;

        }
        int left=0, right = len-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target < nums[mid]){
                right = mid-1;
            }
            else {
                left = mid+1;

            }

        }

        return left;



    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int []{1,3,5,6}, 7));
    }
}
