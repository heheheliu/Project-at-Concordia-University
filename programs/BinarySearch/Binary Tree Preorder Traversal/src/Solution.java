import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    public void helper(TreeNode root,List<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        helper(root.left, ans);
        helper(root.right,ans);
    }

    public List<Integer> preorderTraversal_2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }
}
