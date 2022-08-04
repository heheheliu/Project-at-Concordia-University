import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        Stack<Integer> stack= new Stack<>();
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            if(cur.val != stack.pop()){
                return false;
            }
            cur = cur.next;
        }
        return true;

    }
    public boolean isPalindrome_2(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int l = 0, r = list.size()-1;
        while(l <= r){
            if(list.get(l) != list.get(r)){
                return false;
            }
            --r;
            ++l;
        }
        return true;

    }
}
