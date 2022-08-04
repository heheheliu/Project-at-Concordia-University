import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return  ans;

    }
    public void helper(TreeNode root, List<Integer> ans ){
        if(root == null){
            return;
        }
        helper(root.left, ans);
        helper(root.right, ans);
        ans.add(root.val);
    }


}
