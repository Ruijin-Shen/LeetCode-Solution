package Solution.C;

import java.util.*;

public class CheckIfItIsPossibleToSplitArray {
}

class Solution2811 {
    public boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size();
        if(n <= 2) return true;

        int maxSum = 0;
        var iterator = nums.iterator();
        int prev = iterator.next();
        while(iterator.hasNext()){
            int next = iterator.next();
            maxSum = Math.max(maxSum, prev + next);
            prev = next;
        }
        return maxSum >= m;
    }
}