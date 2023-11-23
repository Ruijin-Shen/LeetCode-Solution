public class FindPeakElement {
}

class Solution162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = -1, right = n - 1;
        while(right - left > 1){ // left upwards, right downwards.
            int mid = left + right >> 1;
            if(mid == n - 1 || nums[mid] > nums[mid + 1]){ // downwards
                right = mid;
            }else{
                left = mid;
            }
        }
        return right;
    }
}