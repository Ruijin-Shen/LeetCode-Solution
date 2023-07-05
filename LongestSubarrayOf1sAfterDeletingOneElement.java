public class LongestSubarrayOf1sAfterDeletingOneElement {
}

class Solution1493 {
    public int longestSubarray(int[] nums) {
        int a = 0, c = 0;
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                result = Math.max(result, a + c);
                a = c;
                c = 0;
            }else{
                c++;
            }
        }
        result = Math.max(result, a + c);
        return result < nums.length ? result : result - 1;
    }
}