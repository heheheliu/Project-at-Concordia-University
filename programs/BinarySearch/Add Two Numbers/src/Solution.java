public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位
        int carry = 0;
        //假字节头
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        int sum = 0;
        while(l1 != null || l2 != null){
            //sum = l1 + l2 + carry
            sum = (l1 == null? 0 : l1.val) + (l2 == null? 0 : l2.val) + carry;
            //用除法 求进位与否
            carry = sum / 10;
            //余数 求该位上应为多少
            sum %= 10;
            curNode.next = new ListNode(sum);
            //下一个
            if(l1 != null){
                l1 = l1.next;
            }
            //下一个
            if(l2 != null){
                l2 = l2.next;
            }
            curNode = curNode.next;

        }
        //还有进位的话
        if(carry == 1){
            curNode.next = new ListNode(carry);
        }
        return head.next;
    }
}
