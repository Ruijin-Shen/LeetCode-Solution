import Definition.ListNode;

public class RemoveDuplicatesFromSortedListII {
}

class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        int prev = Integer.MIN_VALUE;
        ListNode prevNode = new ListNode(0, head);
        ListNode result = prevNode;

        ListNode node = head;
        while(node != null){
            if(node.val == prev || (node.next != null && node.next.val == node.val)){
                prevNode.next = node.next;
            }else{
                prevNode = node;
            }
            prev = node.val;
            node = node.next;
        }
        return result.next;
    }
}