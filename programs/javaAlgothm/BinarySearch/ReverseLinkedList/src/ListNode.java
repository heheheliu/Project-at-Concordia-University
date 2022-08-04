import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int x) {
     val = x;
     next = null;
    }
    ListNode(int x, ListNode next){
        this.val = x;
        this.next = next;
    }
}
