package Solution.I;

import Definition.ListNode;

public class InsertGreatestCommonDivisorsInLinkedList {
}

class Solution2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        for(ListNode node = head; node.next != null; node = node.next.next){
            int a = node.val, b = node.next.val;
            node.next = new ListNode(gcd(a, b), node.next);
        }
        return head;
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
