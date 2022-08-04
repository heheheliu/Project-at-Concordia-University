public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
       return helper(nums, 0, nums.length-1);

    }
    public TreeNode helper(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid-1);
        root.right = helper(nums, mid+1,right);
        return root;
    }

    public TreeNode sortedArrayToBST_2(int[] nums) {
        return helper(nums, 0, nums.length-1);

    }
    public TreeNode helper_2(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + (right-left+1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper_2(nums, left, mid-1);
        root.right = helper_2(nums, mid+1,right);
        return root;
    }
}
