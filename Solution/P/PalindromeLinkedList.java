package Solution.P;

import Definition.ListNode;

import java.util.*;

public class PalindromeLinkedList {
}

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();
        for(int i = 0; i < (n + 1) / 2; i++){
            if(list.get(i) != list.get(n - 1 - i)) return false;
        }
        return true;
    }
}