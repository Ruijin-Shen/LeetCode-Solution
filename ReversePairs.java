public class ReversePairs {
}

class Solution493 {
    private static final int[] temp = new int[50000];

    public int reversePairs(int[] nums) {
        return (int)countPairs(nums, 0, nums.length - 1);
    }

    private static long countPairs(int[] nums, int left, int right){
        if(left >= right) return 0;
        int mid = left + right >> 1;
        long intraCount = countPairs(nums, left, mid) + countPairs(nums, mid + 1, right);
        long interCount = 0;

        // calculate
        int i = left, j = mid + 1;
        while(i <= mid && j <= right){
            long leftNum = nums[i], rightNum = 2L * nums[j];
            if(leftNum <= rightNum){
                i++;
            }else{
                interCount += mid - i + 1;
                j++;
            }
        }

        // mergeSort
        i = left;
        j = mid + 1;
        int k = left;

        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] =  nums[j++];
        }

        while(i <= mid) temp[k++] = nums[i++];
        while(j <= right) temp[k++] = nums[j++];

        for(i = left; i <= right; i++){
            nums[i] = temp[i];
        }

        return interCount + intraCount;
    }
}