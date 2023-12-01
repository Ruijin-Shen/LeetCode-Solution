import Definition.ListNode;

public class ReverseLinkedListII {
}

class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;

        ListNode node = head;
        ListNode prev = null;
        for(int i = 1; i < left; i++){
            prev = node;
            node = node.next;
        }
        ListNode start = prev;
        ListNode end = node;

        for(int i = left; i <= right; i++){
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }

        if(start != null) start.next = prev;
        end.next = node;
        return start == null ? prev: head;
    }
}