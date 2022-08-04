import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root,targetSum,0);

        return ans;
    }
    public void dfs(TreeNode root, int targetSum, int cur){
        if(root == null){
            return;
        }
        path.add(root.val);
        int newCur = cur + root.val;
        if(root.left == null & root.right == null){
            if(newCur == targetSum){
                ans.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, targetSum, newCur);
        dfs(root.right, targetSum, newCur);
        path.remove(path.size()-1);
    }



}
