package Solution.R;

public class RemoveElement {
}

class Solution27 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right--];
            }else{
                left++;
            }
        }
        return right + 1;
    }
}