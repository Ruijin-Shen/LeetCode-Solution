package Solution.S;

public class SearchInsertPosition {
}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + right >> 1;
            if(nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}