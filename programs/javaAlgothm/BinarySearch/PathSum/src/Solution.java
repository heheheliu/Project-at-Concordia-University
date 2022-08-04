import java.util.ArrayDeque;
import java.util.Queue;


public class Solution {
    boolean ans = false;
    int target = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right==null){
            return targetSum == root.val;
        }
       return hasPathSum(root.left, targetSum-root.val) ||
        hasPathSum(root.right,targetSum-root.val);

    }
    public boolean hasPathSum_dfs(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        target = targetSum;
        dfs(root,0);

        return ans;

    }
    private void dfs(TreeNode node, int cur){
        if(node == null){
            return;
        }
        int newCur = cur + node.val;
        if(node.left == null && node.right == null){
            if(newCur == target){
                ans = true;
            }
        }
        dfs(node.left, newCur);
        dfs(node.right, newCur);
    }



}
