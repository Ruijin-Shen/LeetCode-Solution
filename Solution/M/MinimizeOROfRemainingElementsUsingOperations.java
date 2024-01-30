package Solution.M;

public class MinimizeOROfRemainingElementsUsingOperations {
}

class Solution3022 {
    public int minOrAfterOperations(int[] nums, int k) {
        int n = nums.length;
        int mask = 0;
        for(int i = 31; i >= 0; i--){
            mask |= 1 << i;
            int cnt = 0;
            int and = -1;

            for(int num : nums){
                and &= (mask & num);
                if(and == 0){
                    cnt++;
                    and = -1;
                }
            }
            if(n - cnt > k){
                mask &= ~(1 << i);
            }
        }
        return ~mask;
    }
}