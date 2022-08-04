import java.util.Stack;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode head = new ListNode(0);
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        int sum = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || carry >0){
            sum = (s1.isEmpty()? 0 : s1.pop())+ (s2.isEmpty()? 0 : s2.pop()) + carry;
            carry = sum / 10;
            sum %= 10;
            //用头插法 插入节点
            ListNode newNode = new ListNode(sum);
            newNode.next = head.next;
            head.next = newNode;

        }
        return head.next;
    }
}
