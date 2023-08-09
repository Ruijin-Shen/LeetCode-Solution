public class SearchInRotatedSortedArray {
}

class Solution33 {
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