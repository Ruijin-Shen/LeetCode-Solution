package Solution.K;

import java.util.Arrays;

public class KRadiusSubarrayAverages {
}

class Solution2090 {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        if(2 * k + 1 > n) return result;

        int left = 0, right = 2 * k;
        long sum = 0;
        for(int i = 0; i < right; i++){
            sum = sum + nums[i];
        }
        while(right < n){
            sum += nums[right];
            result[left + right >> 1] = (int)(sum / (2 * k + 1));
            sum -= nums[left];
            left++;
            right++;
        }
        return result;
    }
}