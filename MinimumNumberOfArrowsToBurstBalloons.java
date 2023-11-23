import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons {
}

class Solution452 {
    public int findMinArrowShots(int[][] points) {
        int result = 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int end = Integer.MAX_VALUE;
        for(int[] balloon : points){
            if(balloon[0] > end){
                result++;
                end = balloon[1];
            }else{
                end = Math.min(end, balloon[1]);
            }
        }
        return result + 1;
    }
}