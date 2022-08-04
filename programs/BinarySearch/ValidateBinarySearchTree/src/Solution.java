import java.util.Stack;

public class Solution {


    //递归 保持记录上下界限
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long lower, long upper){
        if(root == null){
            return true;
        }
        if(root.val <= lower || root.val >= upper){
            return false;
        }

        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    public boolean isValid(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;

        while(! stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= inorder){
                return false;

            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
