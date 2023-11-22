public class ContainerWithMostWater {
}

class Solution11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int result = 0;
        int i = 0, j = n - 1, h = 0;

        while(i < j){
            h = Math.min(height[i], height[j]);
            result = Math.max(result, h * (j - i));

            while(i < j && height[i] <= h) i++;
            while(i < j && height[j] <= h) j--;
        }
        return result;
    }
}