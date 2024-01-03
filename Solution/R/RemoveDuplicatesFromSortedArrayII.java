package Solution.R;

public class RemoveDuplicatesFromSortedArrayII {
}

class Solution80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow, fast;
        for(slow = 2, fast = 2; fast < n; fast++){
            if(nums[fast] != nums[slow - 2]) nums[slow++] = nums[fast];
        }
        return Math.min(n, slow);
    }
}