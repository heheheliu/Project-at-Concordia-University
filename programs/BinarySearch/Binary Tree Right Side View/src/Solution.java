import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private List<Integer> ans = new ArrayList<>();

    //BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightList = new ArrayList<>();
        if(root == null){
            return rightList;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(! queue.isEmpty()){
            int len = queue.size();
            for(int i =0; i < len; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(i == len - 1){//每层最后一个加到答案中
                    rightList.add(node.val);
                }
            }
        }
        return rightList;
    }
    public List<Integer> rightSideView_dfs(TreeNode root) {

        dfs(root, 0);
        return ans;
    }
    public void dfs(TreeNode root, int depth){
        if(root == null){
            return;
        }
        if(depth == ans.size()){
            ans.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }


}
