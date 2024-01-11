package Solution.T;

public class TrappingRainWater {
}

class Solution42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] greater = new int[n];

        int maxNum = 0;
        for(int i = 0; i < n; i++){
            if(height[i] > maxNum) maxNum = height[i];
            greater[i] = maxNum;
        }

        int result = 0;
        maxNum = 0;
        for(int i = n - 1; i >= 0; i--){
            if(height[i] > maxNum) maxNum = height[i];
            greater[i] = Math.min(greater[i], maxNum);
            result += greater[i] - height[i];
        }

        return result;
    }
}