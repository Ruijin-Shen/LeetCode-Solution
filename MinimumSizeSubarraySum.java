public class MinimumSizeSubarraySum {
}

class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int result = n + 1;
        int i = 0, j = 1, sum = nums[0];
        for(i = 0; i < n; i++){
            while(sum < target && j < n){
                sum += nums[j++];
            }
            if(sum >= target) result = Math.min(result, j - i);
            sum -= nums[i];
        }

        return result == n + 1 ? 0 : result;
    }
}
