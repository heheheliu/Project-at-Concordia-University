public class Solution {
    public TreeNode pruneTree(TreeNode root) {

        if(root == null) return null;
        root.left = pruneTree(root.left);//得到修剪后的左子树
        root.right = pruneTree(root.right);//得到修剪后的右子树
        if(root.left == null && root.right == null && root.val != 1)
            return null;
        return root;

    }
}
