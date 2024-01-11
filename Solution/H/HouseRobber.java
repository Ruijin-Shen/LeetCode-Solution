package Solution.H;

public class HouseRobber {
}

class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n >= 1) dp[0] = nums[0];
        if(n >= 2) dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}