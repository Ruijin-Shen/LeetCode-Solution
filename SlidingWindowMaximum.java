import java.util.*;

public class SlidingWindowMaximum {
}

class Solution239MonotonicDeque {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> monotonicQ = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];

        monotonicQ.add(0);
        for(int i = 0; i < nums.length; i++){
            int value = nums[i];
            if(monotonicQ.getFirst() < i - k + 1) monotonicQ.removeFirst();
            while(!monotonicQ.isEmpty() && nums[monotonicQ.getLast()] <= value) monotonicQ.removeLast();
            monotonicQ.addLast(i);
            if(i >= k - 1){
                result[i - k + 1] = nums[monotonicQ.getFirst()];
            }
        }
        return result;
    }
}