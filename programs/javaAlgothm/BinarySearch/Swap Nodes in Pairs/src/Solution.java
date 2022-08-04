public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode hat = new ListNode(0);
        hat.next = head;
        ListNode temp = hat;
        while(temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            node1.next = node2.next;
            temp.next = node2;
            node2.next = node1;
            temp = node1;
        }
        return hat.next;
    }

    public ListNode swapPairs_recursion(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs_recursion(newHead.next);
        newHead.next = head;
        return newHead;

    }
}
