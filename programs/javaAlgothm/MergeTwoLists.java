public class mergeTwoLists {
    public ListNode merge_Two_Lists(ListNode list1, ListNode list2) {
        // if either list is empty
        if(list1 == null){return list2;}
        if(list2 == null){return list1;}
        // head for the new list that we will return
        ListNode head;
        if(list1.getVal()<=list2.getVal()){
            head = new ListNode(list1.getVal(),null);
            list1 = list1.getNext();//move next node

        }else {
            head = new ListNode(list2.getVal(),null);
            list2 = list2.getNext();//move next node
        }
        ListNode cur = head;
        while(list1 != null  && list2 != null){
            if(list1.getVal()<=list2.getVal()){
                cur.setNext(new ListNode(list1.getVal(),null));
                list1 = list1.getNext();

            }else{
                cur.setNext(new ListNode(list2.getVal(),null));
                list2 = list2.getNext();
            }
            cur = cur.getNext();
        }

        if(list2 != null){
            cur.setNext(list2);
        }
        if(list1 != null){
            cur.setNext(list1);
        }


        return head;

    }



}
