public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode  dummyHead = new ListNode(0);//引入哑节点是为了便于在 head 节点之前插入节点。
        dummyHead.next = head;
        //lastSorted 为链表的已排序部分的最后一个节点，初始时 lastSorted = head。
        //curr 为待插入的元素，初始时 curr = head.next。
        ListNode lastSorted = head, cur = head.next;

        while(cur != null){

            if(lastSorted.val <= cur.val){
                lastSorted = lastSorted.next;

            }else{
                ListNode prev = dummyHead;
                while(cur.val >= prev.next.val){
                     prev = prev.next;
                }
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = lastSorted.next;


        }
        return dummyHead.next;


    }


}
