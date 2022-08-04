import java.util.HashMap;

public class Solution {
    private HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;

        while(cur != null){
            Node newNode = new Node(cur.val);
            map.put(cur,newNode);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);

    }
}
