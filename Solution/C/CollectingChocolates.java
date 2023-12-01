package Solution.C;

public class CollectingChocolates {
}

class Solution03 {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[] minNums = new int[n];
        long minCount = 0;
        for(int i = 0; i < n; i++){
            minNums[i] = nums[i];
            minCount += nums[i];
        }

        for(int i = 1; i < n; i++){
            long curCount = 0;
            for(int j = 0; j < n; j++){
                minNums[j] = Math.min(minNums[j], nums[(j + i) % n]);
                curCount += minNums[j];
            }
            curCount += (long)i * (long)x;
            minCount = Math.min(minCount, curCount);
        }
        return minCount;
    }
}