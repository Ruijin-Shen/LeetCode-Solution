import java.util.*;

import static java.util.Arrays.asList;

public class WaysToSplitArrayIntoGoodSubarrays {
}

class Solution2750 {
    private static final int modulo = 1000000007;

    public int numberOfGoodSubarraySplits(int[] nums) {
        ArrayList<Integer> index = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) index.add(i);
        }

        if(index.size() == 0) return 0;

        long count = 1;
        for(int i = 1; i < index.size(); i++){
            count = count * (index.get(i) - index.get(i - 1)) % modulo;
        }

        return (int)count;
    }
}