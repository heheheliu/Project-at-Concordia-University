import java.util.ArrayList;
import java.util.List;

public class Program {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = null;
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        for(int i =0; i<path_p.size() && i<path_q.size(); i++){
            if(path_p.get(i) == path_q.get(i)){
                ancestor = path_q.get(i);
            }else{
                break;
            }
        }
        return ancestor;

    }
    public List<TreeNode> getPath(TreeNode root, TreeNode target){
        TreeNode current = root;
        List<TreeNode> path = new ArrayList<>();
        while(current != target){
            path.add(current);
            if(current.val > target.val){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        path.add(current);
        return path;
    }

    public TreeNode lowestCommonAncestorBetter(TreeNode root, TreeNode p, TreeNode q) {
        //如果根节点和p,q的差相乘是正数，说明这两个差值要么都是正数要么都是负数，也就是说
        //他们肯定都位于根节点的同一侧，就继续往下找
        if((root.val - p.val) * (root.val - q.val) <= 0){
            return root;
        }
        return lowestCommonAncestorBetter((root.val>p.val ? root.left : root.right), p, q);

    }

}
