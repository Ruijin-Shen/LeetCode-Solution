package Solution.R;

public class ReversePairs {
}

class Solution493 {
    private static int[] temp = new int[50000];

    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1);
    }

    private static int reversePairs(int[] nums, int left, int right){
        if(left >= right) return 0;
        int mid = left + right >> 1;

        int result = 0;
        result += reversePairs(nums, left, mid);
        result += reversePairs(nums, mid + 1, right);

        int i = left, j = mid + 1, total = left;
        int ptr = mid + 1;
        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                while(ptr <= right && (long)nums[ptr] * 2 < nums[i]) ptr++;
                result += ptr - mid - 1;
                temp[total++] = nums[i++];
            }
            else temp[total++] = nums[j++];
        }
        while(i <= mid){
            while(ptr <= right && (long)nums[ptr] * 2 < nums[i]) ptr++;
            result += ptr - mid - 1;
            temp[total++] = nums[i++];
        }
        while(j <= right) temp[total++] = nums[j++];

        for(i = left; i <= right; i++){
            nums[i] = temp[i];
        }
        return result;
    }
}