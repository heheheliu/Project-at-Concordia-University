import java.util.Stack;

public class Solution {
    //迭代
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

    }
    //递归
    public ListNode reverseList_2(ListNode head) {

        if(head == null || head.next == null){
            return head;

        }else{
            ListNode newNode = reverseList_2(head.next);
            head.next.next = head;
            head.next = null;
            return newNode;
        }

    }

}
