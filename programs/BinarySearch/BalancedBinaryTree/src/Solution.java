public class Solution {
    //自上而下递归
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int l = height(root.left);
        int r = height(root.right);
        if(Math.abs(l-r) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;




    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right)) + 1;
    }


    //自下而上递归
    public boolean isBalance(TreeNode root){
        if(root == null){
            return true;
        }
        return height2(root) != -1;
    }
    public int height2(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);
        if(Math.abs(leftHeight-rightHeight)>1 || leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight) + 1;
    }

}
