import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur);
            cur = cur.next;
        }
        return list.get(list.size()/2);

    }

    public ListNode middleNode_fastslow(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
