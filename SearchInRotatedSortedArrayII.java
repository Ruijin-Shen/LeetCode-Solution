public class SearchInRotatedSortedArrayII {
}

class Solution81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(right >= 0 && nums[right] == nums[0]) right--;
        if(right == -1) return nums[0] == target;
        n = right + 1;

        // Find the pivot index.
        while(left < right){
            int mid = left + right + 1 >> 1;
            if(nums[mid] >= nums[0]) left = mid;
            else right = mid - 1;
        }
        int pivot = left;

        if(target >= nums[0]){
            left = 0;
            right = pivot;
        }else{
            left = pivot + 1;
            right = n - 1;
        }
        while(left < right){
            int mid = left + right + 1 >> 1;
            if(target >= nums[mid]) left = mid;
            else right = mid - 1;
        }

        return nums[right] == target;
    }
}
