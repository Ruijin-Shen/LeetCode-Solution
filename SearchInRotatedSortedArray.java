public class SearchInRotatedSortedArray {
}

class Solution33BinarySearCh {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0, right = n - 1;
        while(left < right){
            System.out.println(left + " " + right);
            int mid = (left + right + 1) >> 1;
            System.out.println(mid);
            if(target < nums[mid] && target >= nums[0]){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}

class Solution33OneBinarySearch {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0, right = n - 1;
        while(left < right){
            int mid = left + right + 1 >> 1;
            if((inLeft(nums, nums[mid]) && inLeft(nums, target) && target < nums[mid]) ||
                    (!inLeft(nums, nums[mid]) && !inLeft(nums, target) && target < nums[mid]) ||
                    !inLeft(nums, nums[mid]) && inLeft(nums, target)){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public boolean inLeft(int[] nums, int target){
        return target >= nums[0];
    }
}