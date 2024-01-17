package Solution.F;

public class FindFirstAndLastPositionOfElementInSortedArray {
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};

        int left = 0, right = nums.length - 1;
        while(nums[left] < nums[right]){
            int mid = left + right >> 1;
            if(nums[mid] > target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
            else if(nums[left] < target) left = left + 1;
            else right = right - 1;
        }
        return nums[left] == target ? new int[]{left, right} : new int[]{-1, -1};
    }
}