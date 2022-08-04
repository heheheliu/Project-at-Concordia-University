import apple.laf.JRSUIUtils;

import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            ans.add(levelList);

        }
        return ans;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            ans.add(levelList);

        }

        for(int i = 0, j= ans.size()-1; i < j; i++){
            ans.add(i,ans.remove(j));//加到index， value
        }
        //下面这个会慢点
        //Collections.reverse(ans);
        return ans;
    }
}
