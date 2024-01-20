package Solution.M;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumSumCircularSubarray {
}

class Solution918MonotonicQueue {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[2 * n];
        int sum = 0;
        Deque<Integer> mq = new ArrayDeque<>();  // monotinic queue
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < 2 * n; i++){
            sum += nums[i % n];
            prefixSum[i] = sum;
            if(i >= n) result = Math.max(result, sum - prefixSum[mq.getFirst()]);
            while(!mq.isEmpty() && prefixSum[mq.getLast()] >= sum) mq.removeLast();
            mq.addLast(i);
            if(mq.getFirst() <= i - n) mq.removeFirst();
        }
        return result;
    }
}

class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];
        int suffixSum = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suffixSum += nums[i];
            suffixMax[i] = Math.max(suffixSum, suffixMax[i + 1]);
        }

        int prevSum = 0;
        int prefixSum = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int curSum = nums[i] + Math.max(0, prevSum);
            int spanMax = prefixSum + suffixMax[i];
            result = Math.max(result, Math.max(curSum, spanMax));
            prefixSum += nums[i];
            prevSum = curSum;
        }
        return result;
    }
}