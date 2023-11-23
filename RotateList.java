public class RotateList {
}

class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int n = 1;
        ListNode tail = head;
        while(tail.next != null){
            n++;
            tail = tail.next;
        }
        tail.next = head;

        k = k % n;
        ListNode node = head;
        for(int i = 1; i < n - k; i++){
            node = node.next;
        }
        ListNode result = node.next;
        node.next = null;
        return result;
    }
}