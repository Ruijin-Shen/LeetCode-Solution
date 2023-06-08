public class AddTwoNumbers {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode cur1 = l1, cur2 = l2;
        ListNode resultCur = result;

        int carry = 0;
        while(cur1 != null || cur2 != null){
            int value1 = 0, value2 = 0;

            if(cur1 != null){
                value1 = cur1.val;
                cur1 = cur1.next;
            }
            if(cur2 != null){
                value2 = cur2.val;
                cur2 = cur2.next;
            }

            int value = value1 + value2 + carry;
            carry = value / 10;
            value = value % 10;

            resultCur.next = new ListNode(value);
            resultCur = resultCur.next;
        }

        if(carry == 1){
            resultCur.next = new ListNode(1);
        }
        return result.next;
    }
}