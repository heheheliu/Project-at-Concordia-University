import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class Solution {
    HashMap<Node, Node> visited = new HashMap<>();//原图的node， 克隆图的对应Node
    public Node cloneGraph_DFS(Node node) {
        if(node == null){
            return node;
        }
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        //克隆节点， 为了deep clone我们不能直接克隆他的邻居列表
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node,cloneNode);
        //遍历邻居列表
        for (Node n : node.neighbors){
            //递归
            cloneNode.neighbors.add(cloneGraph_DFS(n));
        }
        return cloneNode;
    }

    public Node cloneGraph_BFS(Node node) {
        if(node == null){
            return node;
        }
        HashMap<Node,Node> seen = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        Node cloneNode = new Node(node.val, new ArrayList<>());
        seen.put(node, cloneNode);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(Node n : cur.neighbors){
                if(!seen.containsKey(n)){
                    seen.put(n, new Node(n.val,new ArrayList<>()));
                    queue.add(n);
                }
                // 更新当前节点的邻居节点
                seen.get(cur).neighbors.add(seen.get(n));
            }
        }
        return cloneNode;
    }
}
