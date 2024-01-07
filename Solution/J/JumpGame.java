package Solution.J;

public class JumpGame {
}

class Solution55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxDistance = 0;

        for(int i = 0; i < n && i <= maxDistance; i++){
            maxDistance = Math.max(maxDistance, i + nums[i]);
        }

        return maxDistance >= n - 1;
    }
}