package Solution.S;

public class SortLinkedListAlreadySortedUsingAbsoluteValues {
}

class Solution2046 {
    static class ListNode {
        int val;
        ListNode next;
    }
    public ListNode sortLinkedList(ListNode head) {
        ListNode negative = head;
        ListNode node = head;
        while(node != null && node.next != null){
            ListNode nextNode = node.next;
            if(nextNode.val < 0){
                node.next = nextNode.next;
                nextNode.next = negative;
                negative = nextNode;
            }else{
                node = node.next;
            }
        }
        return negative;
    }
}