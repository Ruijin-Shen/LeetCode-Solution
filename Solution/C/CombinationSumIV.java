package Solution.C;

import java.util.Arrays;

public class CombinationSumIV {
}

class Solution377 {
    private int[] mem;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        this.mem = new int[target + 1];
        Arrays.fill(mem, -1);
        return dp(nums, target);
    }

    private int dp(int[] nums, int target){
        if(target == 0) return 1;
        if(mem[target] != -1) return mem[target];

        int result = 0;
        for(int i = 0; i < nums.length && nums[i] <= target; i++){
            result += dp(nums, target - nums[i]);
        }
        mem[target] = result;
        return result;
    }
}