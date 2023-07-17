import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbersII {
}

class SolutionT {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = reverse(l1);
        List<Integer> list2 = reverse(l2);

        var it1 = list1.iterator();
        var it2 = list2.iterator();
        ListNode result = null;
        int totalSum = 0;

        while(it1.hasNext() || it2.hasNext() || totalSum / 10 != 0){
            if(it1.hasNext()) totalSum += it1.next();
            if(it2.hasNext()) totalSum += it2.next();

            result = new ListNode(totalSum % 10, result);
            totalSum /= 10;
        }
        return result;
    }

    private List<Integer> reverse(ListNode list){
        LinkedList<Integer> result = new LinkedList<>();
        while(list != null){
            result.addFirst(list.val);
            list = list.next;
        }
        return result;
    }
}