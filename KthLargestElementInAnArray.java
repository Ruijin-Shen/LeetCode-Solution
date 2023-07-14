public class KthLargestElementInAnArray {
}

class Solution215QuickSelect {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    // Return the k-th (0-indexed) smallest element in the array.
    public static int quickSelect(int[] nums, int left, int right, int k){
        if(left >= right) return nums[left];

        int i = left - 1, j = right + 1, pivot = nums[left + right >> 1];
        while(true){
            do i++; while(nums[i] < pivot);
            do j--; while(nums[j] > pivot);

            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] =  temp;
            }else{
                break;
            }
        }

        if(k <= j) return quickSelect(nums, left, j, k);
        else return quickSelect(nums, j + 1, right, k);
    }
}