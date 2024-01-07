package Solution.N;

import java.util.Arrays;

public class NeitherMinimumNorMaximum {
}

class Solution2733 {
    public int findNonMinOrMax(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return -1;
        }

        int[] sub = new int[]{nums[0], nums[1], nums[2]};
        Arrays.sort(sub);
        return sub[1];
    }
}
