public class JumpGameII {
}

class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int step = 0, end = 0, maxPos = 0;

        for(int i = 0; i < n - 1; i++){
            maxPos = Math.max(maxPos, i + nums[i]);
            if(i == end){
                end = maxPos;
                step++;
                if(end >= n - 1) break;
            }
        }
        return step;
    }
}