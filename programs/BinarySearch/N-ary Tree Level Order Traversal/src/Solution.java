import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i < len; i++){
                Node node = queue.poll();
                cur.add(node.val);
                if(node.children != null){
                    for(Node n : node.children){
                        queue.offer(n);
                    }
                }
            }
            res.add(cur);
        }
        return res;

    }
}
