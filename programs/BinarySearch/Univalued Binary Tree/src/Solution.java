import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> list;
    public boolean isUnivalTree(TreeNode root) {
        list = new ArrayList<>();
        int val = root.val;
        dfs(root);
        for(int n  : list){
            if(n != val){
                return false;
            }
        }
        return true;
     }
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public boolean isUnivalTree_2(TreeNode root){
        boolean left = (root.left == null) || (root.left.val == root.val && isUnivalTree_2(root.left));
        boolean right = (root.right == null) || (root.right.val == root.val && isUnivalTree_2(root.right));
        return left && right;
    }

}
