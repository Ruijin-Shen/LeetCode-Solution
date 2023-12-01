import Definition.ListNode;

public class RemoveNthNodeFromEndOfList {
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode node = head;
        while(node != null){
            count++;
            node = node.next;
        }

        if(count - n == 0){
            return head.next;
        }else{
            node = head;
            for(int i = 0; i < count - n - 1; i++){
                node = node.next;
            }
            node.next = node.next.next;
            return head;
        }
    }
}