import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

// head = 0->1->2->3->4->5
// k = 2
//output 4->5->0->1->2->3
// function that takes in the head of a singly linked list and an integer k, shifts the list in place by k postions, and return s its new head
// time=O(n), space=O(1)
public class shift_LinkedList {
    public static LinkedList shiftLinkedList(LinkedList head, int k){
        int listLength = 1;
        LinkedList listTail = head;
        while(listTail.next != null){
            listTail = listTail.next;
            listLength++;
        }
        int offset = Math.abs(k) % listLength;
        if(offset==0){
            return head;
        }
        int newTailPostion;
        if(k>0)
            newTailPostion = listLength - offset;
        else
            newTailPostion = offset;
        LinkedList newTail = head;
        for(int i=1; i<newTailPostion; i++){

            newTail = newTail.next;
        }
        LinkedList newHead = newTail.next;
        listTail.next = head;//old tail node connect to old head
        newTail.next = null;
        return newHead;
    
    }
    
    
    static class LinkedList{
        public int value;
        public LinkedList next;

        public LinkedList(int value){
            this.value = value;
            next = null;
        }

    }
    public static List<Integer> linkedListToArray(LinkedList head) {
        var array = new ArrayList<Integer>();
        var current = head;
        while (current != null) {
          array.add(current.value);
          current = current.next;
        }
        return array;
      }
    public static void main(String[] args)  {
        var head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);
        var result = shiftLinkedList(head, 2);
        var array = linkedListToArray(result);
        System.out.println(array);
    }
}
