import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        TreeNode result = new TreeNode(0), cur = result;
        for (int v:list) {

            cur.right = new TreeNode(v);
            cur = cur.right;

        }
        return result.right;

    }
    public void inOrder(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);

    }

}
