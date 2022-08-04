import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while(cur != null){
            if(!visited.add(cur)) {
                return true;
            }
            cur = cur.next;
        }
        return false;

    }
    public boolean hasCycleSlowFast(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }

}
