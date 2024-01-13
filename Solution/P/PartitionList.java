package Solution.P;

import Definition.ListNode;

public class PartitionList {
}

class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode lHead = new ListNode();
        ListNode gHead = new ListNode();
        ListNode i = lHead, j = gHead;
        while(head != null){
            if(head.val < x){
                i.next = head;
                i = i.next;
            }else{
                j.next = head;
                j = j.next;
            }
            head = head.next;
        }
        i.next = gHead.next;
        j.next = null;
        return lHead.next;
    }
}