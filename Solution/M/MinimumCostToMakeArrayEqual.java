package Solution.M;

import java.util.Arrays;

public class MinimumCostToMakeArrayEqual {
}

class Solution2448 {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        long ni = 0;
        int[][] array = new int[n][2];
        for(int i = 0; i < n; i++){
            array[i][0] = nums[i];
            array[i][1] = cost[i];
            ni += (long)cost[i];
        }

        Arrays.sort(array, Arrays::compare);

        long medianIndex = ni + 1 >> 1;
        long index = 0;
        int median = 0;
        for(int i = 0; i < n; i++){
            index += (long)array[i][1];
            if(index >= medianIndex){
                median = array[i][0];
                break;
            }
        }

        long totalCost = 0;
        for(int i = 0; i < n; i++){
            totalCost += (long)Math.abs(array[i][0] - median) * array[i][1];
        }
        return totalCost;
    }
}

class Solution2448PrefixSum {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] numsAndCost = new int[n][2];
        for(int i = 0; i < n; i++){
            numsAndCost[i][0] = nums[i];
            numsAndCost[i][1] = cost[i];
        }
        Arrays.sort(numsAndCost, Arrays::compare);

        long[] prefixCost = new long[n];
        prefixCost[0] = numsAndCost[0][1];
        for(int i = 1; i < n; i++){
            prefixCost[i] = prefixCost[i - 1] + numsAndCost[i][1];
        }

        long totalCost = 0;
        for(int i = 1; i < n; i++){
            totalCost += (long)numsAndCost[i][1] * (numsAndCost[i][0] - numsAndCost[0][0]);
        }
        long result = totalCost;

        for(int i = 1; i < n; i++){
            int gap = numsAndCost[i][0] - numsAndCost[i - 1][0];
            totalCost += prefixCost[i - 1] * gap;
            totalCost -= (prefixCost[n - 1] - prefixCost[i - 1]) * gap;
            result = Math.min(result, totalCost);
        }

        return result;
    }
}

class Solution2448BinarySearch {
    private long getCost(int[] nums, int[] cost, int base){
        long result = 0;
        for(int i = 0; i < nums.length; i++){
            result += (long)Math.abs(base - nums[i]) * cost[i];
        }
        return result;
    }

    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        while(left < right){
            int mid = left + right >> 1;
            if(getCost(nums, cost, mid) < getCost(nums, cost, mid + 1)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return getCost(nums, cost, left);
    }
}



