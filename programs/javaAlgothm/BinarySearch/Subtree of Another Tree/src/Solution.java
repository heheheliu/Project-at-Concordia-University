

public class Solution {

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            return dfs(root, subRoot);

        }
        public boolean dfs(TreeNode s, TreeNode t){
            if(s == null){
                return false;
            }
            return checkSame(s,t) || dfs(s.left,t) || dfs(s.right,t);
        }

        public boolean checkSame(TreeNode root, TreeNode subRoot){
            if(root == null && subRoot == null){
                return true;
            }
            if(root == null || subRoot == null){
                return false;
            }
            return root.val == subRoot.val && checkSame(root.left, subRoot.left) && checkSame(root.right, subRoot.right);
        }


}
