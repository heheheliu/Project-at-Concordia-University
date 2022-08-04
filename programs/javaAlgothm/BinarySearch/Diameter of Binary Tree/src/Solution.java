public class Solution {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        depth(root);
        return max;

    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        max = Math.max(l + r, max);
        return Math.max(l,r) + 1;

    }
}
