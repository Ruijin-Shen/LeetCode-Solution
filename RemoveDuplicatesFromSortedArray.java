public class RemoveDuplicatesFromSortedArray {
}

class Solution26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left, right;
        for(left = 1, right = 1; right < n; right++){
            if(nums[right] != nums[left - 1]) nums[left++] = nums[right];
        }
        return left;
    }
}