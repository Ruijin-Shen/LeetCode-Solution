package Solution.C;

import java.util.Arrays;

public class CheckIfThereIsAValidPartitionForTheArray {
}

class Solution2369RecursiveDynamicProgramming {
    private int[] dp;

    public boolean validPartition(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0);
    }

    public boolean helper(int[] nums, int index){
        int n = nums.length;
        if(index == n) return true;
        if(dp[index] != -1) return dp[index] == 1 ? true : false;

        boolean result = false;
        if(index + 1 < n && nums[index + 1] == nums[index]){
            result |= helper(nums, index + 2);
        }

        if(index + 2 < n && nums[index + 1] == nums[index] && nums[index + 2] == nums[index + 1]){
            result |= helper(nums, index + 3);
        }

        if(index + 2 < n && nums[index + 1] - nums[index] == 1 && nums[index + 2] - nums[index + 1] == 1){
            result |= helper(nums, index + 3);
        }

        dp[index] = result ? 1 : 0;
        return result;
    }
}

class Solution2369DynamicProgramming {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[3];

        dp[0] = true; dp[1] = false; dp[2] = nums[0] == nums[1];

        for(int i = 3; i <= n; i++){
            boolean result = false;
            if(nums[i - 1] == nums[i - 2]) result |= dp[(i - 2) % 3];
            if(nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3]) result |= dp[i % 3];
            if(nums[i - 1] - nums[i - 2] == 1 && nums[i - 2] - nums[i - 3] == 1) result |= dp[i % 3];
            dp[i % 3] = result;
        }
        return dp[n % 3];
    }
}