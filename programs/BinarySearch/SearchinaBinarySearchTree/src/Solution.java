import java.util.Stack;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        TreeNode ans;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val == val){
                return root;
            }
            root = root.right;
        }
        return null;

    }
    public TreeNode searchBST_re(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        return searchBST_re(val < root.val ? root.left : root.right, val);
    }
}
