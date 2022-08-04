import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;


    }
    public void helper(TreeNode root, List<Integer> ans ){
        if(root == null){
            return;
        }
        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);
    }
    public List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }

}
