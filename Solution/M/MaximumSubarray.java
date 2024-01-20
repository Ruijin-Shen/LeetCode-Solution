package Solution.M;

public class MaximumSubarray {
}

class Solution53DP {
    public int maxSubArray(int[] nums) {
        int prev = 0;
        int result = Integer.MIN_VALUE;
        for(int num : nums){
            if(prev > 0) prev += num;
            else prev = num;
            if(prev > result) result = prev;
        }
        return result;
    }
}

class Solution53DivideAndConquer {
    public int maxSubArray(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int left, int right){
        if(left == right) return nums[left];

        int mid = left + right >> 1;
        int leftMax = find(nums, left, mid);
        int rightMax = find(nums, mid + 1, right);

        int spanMax = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i >= left; i--){
            sum += nums[i];
            spanMax = Math.max(spanMax, sum);
        }
        sum = spanMax;
        for(int i = mid + 1; i <= right; i++){
            sum += nums[i];
            spanMax = Math.max(spanMax, sum);
        }

        return Math.max(leftMax, Math.max(rightMax, spanMax));
    }
}