package Solution.F;

public class FindMinimumInRotatedSortedArray {
}

class Solution153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1 || nums[0] < nums[n - 1]) return nums[0];
        int left = 0, right = n - 1;
        int pivot = nums[0];
        while(left < right){
            int mid = left + right >> 1;
            if(nums[mid] >= pivot) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}